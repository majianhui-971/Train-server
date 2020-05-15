package com.service.impl;

import com.constant.CommonConstant;
import com.dao.CustomerMapper;
import com.dao.LineMapper;
import com.dao.SiteMapper;
import com.dao.TicketMapper;
import com.entity.*;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.TicketService;
import com.util.DateUtils;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImpl implements TicketService {

    @Resource
    private TicketMapper ticketMapper;

    @Resource
    private SiteMapper siteMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private LineMapper lineMapper;


    @Resource
    RedisUtil redisUtil;

    @Override
    public PageInfo<Ticket> getTicketInfo(Ticket ticket) {
        PageInfo<Ticket> ticketPageInfo = PageHelper.startPage(ticket.getPage(),ticket.getSize()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                if(ticket.getStartTime()!=null && !StringUtils.isEmpty(ticket.getEndSite()) && !StringUtils.isEmpty(ticket.getStartSite())){
                    String startTime= DateUtils.date2StringByDay(ticket.getStartTime());
                    List<Ticket> list = ticketMapper.selectTicketInfos(ticket.getStartSite(),ticket.getEndSite(),startTime );
                    if(list != null && list.size() !=0){
                        for (Ticket ticket1:list
                             ) {
                            if(ticket1.getStartTime()!=null && ticket1.getEndTime()!=null){
                                    ticket1.setTotalTime( DateUtils.getDatePoor(ticket1.getEndTime(),ticket1.getStartTime()));
                                    ticket1.setLeaveTime(DateUtils.date2String(ticket1.getStartTime(),"yyyy-MM-dd HH:mm"));
                            }
                            if(!StringUtils.isEmpty(ticket1.getStartSite()) && !StringUtils.isEmpty(ticket1.getEndSite())){
                                Site site=siteMapper.selectByPrimaryKey(Integer.parseInt(ticket1.getStartSite()));
                                ticket1.setStartSiteName(site.getName());
                                Site site1=siteMapper.selectByPrimaryKey(Integer.parseInt(ticket1.getEndSite()));
                                ticket1.setEndSiteName(site1.getName());
                            }
                        }
                    }
                }
            }
        });
        return ticketPageInfo;
    }

    @Override
    public Map<String, Object> updateInfoDataByAdmin(Ticket ticket) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        TicketExample example = new TicketExample();
        TicketExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(ticket.getId());

        ticketMapper.updateByExampleSelective(ticket, example);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy) {
        PageHelper.startPage(page, pageSize);
   /*     TicketExample example = new TicketExample();
        if(!StringUtils.isBlank(fuzzy)){
            example.or().andPriceLike("%" + fuzzy + "%");
            if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                example.or().andStateLike("%" + fuzzy + "%");
            }
        }

        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
            example.createCriteria().andStateEqualTo("0000");
        }

        List<Ticket> list = ticketMapper.selectByExample(example);*/

        List<Ticket> list = ticketMapper.selectInfoDataByAdmin(fuzzy);

        for(Ticket ticket : list){
            ticket.setStartSiteName(siteMapper.selectByPrimaryKey(Integer.parseInt(ticket.getStartSite())).getName());
            ticket.setEndSiteName(siteMapper.selectByPrimaryKey(Integer.parseInt(ticket.getEndSite())).getName());
            Line line = lineMapper.selectByPrimaryKey(ticket.getLineId());

            if(line != null){
                StringBuilder passName = new StringBuilder();
                String[] passSite = line.getPassSite().split(",");
                for (String pass : passSite) {
                    passName.append(siteMapper.selectByPrimaryKey(Integer.parseInt(pass)).getName()).append("-");
                }

                ticket.setLineName(passName.toString().substring(0, passName.toString().length() - 1));
            }

        }

        return new PageInfo<>(list);
    }

    @Override
    public Map<String, Object> addInfoDataByAdmin(Ticket ticket, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        ticket.setState("0000");
        ticketMapper.insert(ticket);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public List<Ticket> fetchNewInfoData() {
        return ticketMapper.fetchNewInfoData();
    }

    @Override
    public Map<String, Object> deleteInfoByAdmin(String ids) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        TicketExample example = new TicketExample();
        TicketExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if(!StringUtils.isBlank(id)){
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Ticket> adminList = ticketMapper.selectByExample(example);

        for (Ticket ticket : adminList) {
            ticket.setState("9999");
            ticketMapper.updateByPrimaryKey(ticket);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }
}
