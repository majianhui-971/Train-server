package com.service.impl;

import com.constant.CommonConstant;
import com.dao.LineMapper;
import com.dao.SiteMapper;
import com.entity.Line;
import com.entity.LineExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.LineService;
import com.service.interfaces.SiteService;
import com.util.DateUtils;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class LineServiceImpl implements LineService {

    @Resource
    private LineMapper lineMapper;

    @Resource
    private SiteMapper siteMapper;

    @Resource
    RedisUtil redisUtil;

    @Override
    public PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy) {
        PageHelper.startPage(page, pageSize);

/*        LineExample example = new LineExample();
        if(!StringUtils.isBlank(fuzzy)){
            example.or().andStartSiteLike("%" + fuzzy + "%");
            example.or().andEndSiteLike("%" + fuzzy + "%");
            example.or().andPassSiteLike("%" + fuzzy + "%");
            if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                example.or().andStateLike("%" + fuzzy + "%");
            }
        }

        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
            example.createCriteria().andStateEqualTo("0000");
        }

        List<Line> list = lineMapper.selectByExample(example);*/

        List<Line> list = lineMapper.selectInfoDataByAdmin(fuzzy);

        for(Line line : list){
            line.setStartSiteName(siteMapper.selectByPrimaryKey(Integer.parseInt(line.getStartSite())).getName());
            line.setEndSiteName(siteMapper.selectByPrimaryKey(Integer.parseInt(line.getEndSite())).getName());

         /*   StringBuilder passName = new StringBuilder();
            String[] passSite = line.getPassSite().split(",");
            for (String pass : passSite) {
                passName.append(siteMapper.selectByPrimaryKey(Integer.parseInt(pass)).getName()).append(",");
            }*/

/*            line.setPassSiteName(passName.toString().substring(0, passName.toString().length() - 1));*/

        }
        return new PageInfo<>(list);
    }

    /*
    * 修改线路信息
    * */
    @Override
    public Map<String, Object> updateInfoDataByAdmin(Line line) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        LineExample example = new LineExample();
        LineExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(line.getId());

        line.setOffsetTime(DateUtils.getDatePoor(line.getEndTime(), line.getStartTime()));
        lineMapper.updateByExampleSelective(line, example);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    /*
    * 添加线路信息
    * */
    @Override
    public Map<String, Object> addInfoDataByAdmin(Line line, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        line.setOffsetTime(DateUtils.getDatePoor(line.getEndTime(), line.getStartTime()));
        line.setState("0000");
        lineMapper.insert(line);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    /*
    * 删除线路信息
    * */
    @Override
    public Map<String, Object> deleteInfoByAdmin(String ids) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        LineExample example = new LineExample();
        LineExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if(!StringUtils.isBlank(id)){
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Line> adminList = lineMapper.selectByExample(example);

        for (Line line : adminList) {
            line.setState("9999");
            lineMapper.updateByPrimaryKey(line);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public List<Line> fetchInfoDataBySelect() {
        LineExample example = new LineExample();
        LineExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo("0000");

        List<Line> list = lineMapper.selectByExample(example);

        for(Line line : list){
            line.setStartSiteName(siteMapper.selectByPrimaryKey(Integer.parseInt(line.getStartSite())).getName());
            line.setEndSiteName(siteMapper.selectByPrimaryKey(Integer.parseInt(line.getEndSite())).getName());
        }

        return list;
    }
}
