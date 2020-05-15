package com.service.impl;

import com.constant.CommonConstant;
import com.dao.SiteMapper;
import com.entity.Site;
import com.entity.SiteExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.SiteService;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SiteServiceImpl implements SiteService {

    @Resource
    private SiteMapper siteMapper;

    @Resource
    RedisUtil redisUtil;

    /**
     * 查询状态为 0000 的站点信息
     * @return
     */
    @Override
    public List<Site> getSiteInfo() {
        SiteExample siteExample = new SiteExample();
        SiteExample.Criteria criteria = siteExample.createCriteria();
        criteria.andStateEqualTo("0000");
        return siteMapper.selectByExample(siteExample);
    }

    @Override
    public PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy) {
        PageHelper.startPage(page, pageSize);

        SiteExample example = new SiteExample();
        if(!StringUtils.isBlank(fuzzy)){
            example.or().andNameLike("%" + fuzzy + "%");
            if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                example.or().andStateLike("%" + fuzzy + "%");
            }
        }

        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
            example.createCriteria().andStateEqualTo("0000");
        }

        List<Site> list = siteMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public Map<String, Object> updateInfoDataByAdmin(Site site) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        SiteExample example = new SiteExample();
        SiteExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(site.getId());

        siteMapper.updateByExampleSelective(site, example);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public Map<String, Object> addInfoDataByAdmin(Site site, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        site.setState("0000");
        siteMapper.insert(site);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteInfoByAdmin(String ids) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        SiteExample example = new SiteExample();
        SiteExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if(!StringUtils.isBlank(id)){
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Site> adminList = siteMapper.selectByExample(example);

        for (Site site : adminList) {
            site.setState("9999");
            siteMapper.updateByPrimaryKey(site);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public List<Site> fetchInfoDataBySelect() {
        SiteExample siteExample = new SiteExample();
        SiteExample.Criteria criteria = siteExample.createCriteria();
        criteria.andStateEqualTo("0000");
        return siteMapper.selectByExample(siteExample);
    }
}
