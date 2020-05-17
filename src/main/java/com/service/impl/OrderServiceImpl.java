package com.service.impl;

import com.constant.CommonConstant;
import com.dao.*;
import com.entity.*;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.OrderService;
import com.util.DateUtils;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private LineMapper lineMapper;

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private SiteMapper siteMapper;

    @Resource
    private TicketMapper ticketMapper;

    @Resource
    RedisUtil redisUtil;

    @Override
    public PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy) {
        PageHelper.startPage(page, pageSize);

 /*       OrderExample example = new OrderExample();
        if(!StringUtils.isBlank(fuzzy)){
            example.or().andFreeLike("%" + fuzzy + "%");
            example.or().andTypeLike("%" + fuzzy + "%");
            if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                example.or().andStateLike("%" + fuzzy + "%");
            }
        }

        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
            example.createCriteria().andStateEqualTo("0000");
        }

        List<Order> list = orderMapper.selectByExample(example);*/

        List<Order> list = orderMapper.selectInfoDataByAdmin(fuzzy);

        for(Order order : list){
            order.setcName(customerMapper.selectByPrimaryKey(order.getcId()).getName());
            Line line = lineMapper.selectByPrimaryKey(order.getLineId());

            if (line != null && line.getPassSite() != null) {
                StringBuilder passName = new StringBuilder();
                String[] passSite = line.getPassSite().split(",");
                for (String pass : passSite) {
                    passName.append(siteMapper.selectByPrimaryKey(Integer.parseInt(pass)).getName()).append("-");
                }
                order.setLineName(passName.toString().substring(0, passName.toString().length() - 1));
            }else {
                order.setLineName(order.getStartSiteName() + "-" + order.getEndSiteName());
            }

        }
        return new PageInfo<>(list);
    }

    @Override
    public Map<String, Object> updateInfoDataByAdmin(Order order) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(order.getId());

        orderMapper.updateByExampleSelective(order, example);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public Map<String, Object> addInfoDataByAdmin(Order order, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        order.setState("0000");
        orderMapper.insert(order);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    /**
     * 生成订单
     * @param order
     * @return
     */
    @Override
    public Map<String, Object> addInfoData(Order order) {
        Map<String, Object> map = new HashMap<>();
        order.setState("0000");
        // 线程锁
        synchronized (this) {
            double price = Double.parseDouble(order.getOrderPrice());
            int num = order.getOrderSum();
            double value = price * num;
            order.setOrderAmount(String.valueOf(value));
            order.setCreateTime(new Date());
            int oldTicketNumber = order.getTicketNumber();
            int ticketNumber = oldTicketNumber - num;
            OrderExample orderExample = new OrderExample();
            OrderExample.Criteria criteria = orderExample.createCriteria();
            criteria.andCIdEqualTo(order.getcId()).andTicketIdEqualTo(order.getTicketId());
            if(order.getId() != null){
                criteria.andIdNotEqualTo(order.getId());
            }
            // 是否重复购票
            boolean bool = orderMapper.selectByExample(orderExample) == null;

            if (ticketNumber >= 0 && !bool) {
                ticketMapper.updateTicketNumber(ticketNumber, order.getTicketId());
                if(order.getId() != null){
                    order.setType("改签");
                    OrderExample example = new OrderExample();
                    OrderExample.Criteria criteriaInfo = example.createCriteria();
                    criteriaInfo.andIdEqualTo(order.getId());

                    orderMapper.updateByExampleSelective(order, example);
                }else {
                    order.setType("订票");
                    orderMapper.insert(order);
                }
                map.put("type", CommonConstant.SUCCESS_CODE);
            } else if (bool) {
                map.put("type", "repeat");
            } else {
                map.put("type", CommonConstant.FAIL_CODE);
            }
        }

        return map;
    }

    @Override
    public PageInfo<Order> fetchPageInfo(Integer page, Integer size, String fuzzy, String fetchType, HttpServletRequest request) {
        PageHelper.startPage(page, size);
        HttpSession session = request.getSession();
        List<Order> list = new ArrayList<>();

        Integer userId = (Integer) session.getAttribute(CommonConstant.USER_SESSION_ID);

        if (userId != null) {
            if (CommonConstant.FETCH_TYPE_NORMAL.equals(fetchType)) {
                list = orderMapper.selectOrderInfoOne(userId, fuzzy);
            } else if (CommonConstant.FETCH_TYPE_BACK.equals(fetchType)) {
                list = orderMapper.selectOrderInfoTwo(userId, fuzzy);
            } else if (CommonConstant.FETCH_TYPE_FINISH.equals(fetchType)) {
                list = orderMapper.selectOrderInfoThree(userId, fuzzy);
            }else if(CommonConstant.FETCH_TYPE_ALL.equals(fetchType)){
                list = orderMapper.selectOrderInfoFour(userId, fuzzy);
            }
        }

        return new PageInfo<>(list);
    }

    @Override
    public Map<String, Object> deleteInfoByAdmin(String ids) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if(!StringUtils.isBlank(id)){
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Order> adminList = orderMapper.selectByExample(example);

        for (Order order : adminList) {
            order.setState("9999");
            orderMapper.updateByPrimaryKey(order);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public List<Order> fetchTicketInfo(HttpServletRequest request){
        HttpSession session = request.getSession();

        Integer userId = (Integer) session.getAttribute(CommonConstant.USER_SESSION_ID);

        if(userId != null){
            return orderMapper.selectTicketInfo(userId);
        }else {
            return new ArrayList<>();
        }

    }

    @Override
    public Map<String, Object> deleteInfo(String id) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(Integer.valueOf(id));
        List<Order> adminList = orderMapper.selectByExample(example);

        if (adminList != null && adminList.size() > 0) {
            Order order = adminList.get(0);
            order.setState("9999");
            orderMapper.updateByPrimaryKey(order);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public Map<String, Object> updateInfoData(Map map) {

        Map<String, Object> resultMap = new HashMap<>();
        try {
            Integer id = (Integer) map.get("id");
            String price = (String) map.get("price");

            if(id != null && StringUtils.isNotBlank(price)){
                Order order = orderMapper.selectByPrimaryKey(id);

                // 车票
                Ticket ticket = ticketMapper.selectByPrimaryKey(order.getTicketId());
                ticket.setTicketNumber(ticket.getTicketNumber() + order.getOrderSum());
                ticketMapper.updateByPrimaryKeySelective(ticket);

                order.setFree(price);
                order.setType("退票");
                orderMapper.updateByPrimaryKey(order);
            }
            resultMap.put("type", CommonConstant.SUCCESS_CODE);
            resultMap.put("message", CommonConstant.SUCCESS_MSG);
        }catch (Exception e){
            resultMap.put("type", CommonConstant.FAIL_CODE);
            resultMap.put("message", CommonConstant.FAIL_MSG);
        }

        return resultMap;
    }

}
