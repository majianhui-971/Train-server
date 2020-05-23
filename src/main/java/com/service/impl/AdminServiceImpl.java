package com.service.impl;

import com.constant.CommonConstant;
import com.dao.AdminMapper;
import com.entity.Admin;
import com.entity.AdminExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.AdminService;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    RedisUtil redisUtil;

    /*
    * 管理员登录
    * */
    @Override
    public Map<String, Object> login(String username, String password, HttpServletRequest request) {

        Map<String, Object> resultMap = new HashMap<>();

        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        criteria.andStateNotEqualTo("9999");

        List<Admin> list = adminMapper.selectByExample(adminExample);

        if (list != null && list.size() > 0) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(CommonConstant.SESSION_TIMEOUT);
            session.setAttribute(CommonConstant.ADMIN_SESSION_NAME, username);
            session.setAttribute(CommonConstant.ADMIN_SESSION_ID, list.get(0).getId());
            resultMap.put("type", CommonConstant.SUCCESS_CODE);
            resultMap.put("message", CommonConstant.SUCCESS_MSG);
            resultMap.put("admin", list.get(0));
        } else {
            resultMap.put("type", CommonConstant.FAIL_CODE);
            resultMap.put("message", CommonConstant.FAIL_MSG);
        }
        return resultMap;
    }

    /*
    * 管理员查询信息
    * */
    @Override
    public PageInfo selectInfoData(Integer page, Integer pageSize, String fuzzy) {

        PageHelper.startPage(page, pageSize);

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isBlank(fuzzy)){
            criteria.andUsernameLike("%" + fuzzy + "%");
            if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                example.or().andStateLike("%" + fuzzy + "%");
            }
        }

        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
            criteria.andStateEqualTo("0000");
        }

        List<Admin> list = adminMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    /*
    * 修改信息
    * */
    @Override
    public Map<String, Object> updateInfoData(Admin admin) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(admin.getId());

        adminMapper.updateByExampleSelective(admin, example);
        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    /*
    * 添加信息
    * */
    @Override
    public Map<String, Object> addInfoData(Admin admin) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(admin.getUsername());
        criteria.andStateEqualTo("0000");

        List<Admin> list = adminMapper.selectByExample(example);

        if (list != null && list.size() > 0) {
            resultMap.put("type", CommonConstant.FAIL_CODE);
            resultMap.put("message", "此账号已被占用");
        } else {
            admin.setState("0000");
            adminMapper.insert(admin);
            resultMap.put("type", CommonConstant.SUCCESS_CODE);
            resultMap.put("message", CommonConstant.SUCCESS_MSG);
        }
        return resultMap;
    }

    /*
    * 删除
    * */
    @Override
    public Map<String, Object> deleteInfo(String ids) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if(!StringUtils.isBlank(id)){
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Admin> adminList = adminMapper.selectByExample(example);

        for (Admin admin : adminList) {
            admin.setState("9999");
            adminMapper.updateByPrimaryKey(admin);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }
}
