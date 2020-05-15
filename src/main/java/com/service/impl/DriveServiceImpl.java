package com.service.impl;

import com.constant.CommonConstant;
import com.dao.DriveMapper;
import com.entity.Drive;
import com.entity.DriveExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.DriveService;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class DriveServiceImpl implements DriveService {

    @Resource
    private DriveMapper driveMapper;

    @Resource
    RedisUtil redisUtil;

    @Override
    public PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy) {
        PageHelper.startPage(page, pageSize);

        DriveExample example = new DriveExample();
        if(!StringUtils.isBlank(fuzzy)){
            example.or().andDriverNameLike("%" + fuzzy + "%");
            example.or().andDriveAgeLike("%" + fuzzy + "%");
            if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                example.or().andStateLike("%" + fuzzy + "%");
            }
        }

        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
            example.createCriteria().andStateEqualTo("0000");
        }

        List<Drive> list = driveMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    @Override
    public Map<String, Object> updateInfoDataByAdmin(Drive drive) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        DriveExample example = new DriveExample();
        DriveExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(drive.getId());

        driveMapper.updateByExampleSelective(drive, example);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public Map<String, Object> addInfoDataByAdmin(Drive drive, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        HttpSession session = request.getSession();

        drive.setState("0000");
        driveMapper.insert(drive);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteInfoByAdmin(String ids) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        DriveExample example = new DriveExample();
        DriveExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if(!StringUtils.isBlank(id)){
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Drive> adminList = driveMapper.selectByExample(example);

        for (Drive drive : adminList) {
            drive.setState("9999");
            driveMapper.updateByPrimaryKey(drive);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public List<Drive> fetchInfoDataBySelect() {


        DriveExample example = new DriveExample();
        DriveExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo("0000");

        return driveMapper.selectByExample(example);
    }
}
