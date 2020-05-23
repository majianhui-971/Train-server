package com.service.impl;

import com.constant.CommonConstant;
import com.dao.CustomerMapper;
import com.entity.Customer;
import com.entity.CustomerExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.CustomerService;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    RedisUtil redisUtil;

    @Override
    public Customer getCustomer(int id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy) {
        PageHelper.startPage(page, pageSize);

        CustomerExample example = new CustomerExample();
        if(!StringUtils.isBlank(fuzzy)) {
            example.or().andUsernameLike("%" + fuzzy + "%");
            example.or().andPasswordLike("%" + fuzzy + "%");
            example.or().andSexLike("%" + fuzzy + "%");
            example.or().andNameLike("%" + fuzzy + "%");
            example.or().andEmailLike("%" + fuzzy + "%");
            if((Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
                example.or().andStatusLike("%" + fuzzy + "%");
            }
        }

        if(!(Boolean) redisUtil.get(CommonConstant.STATE_CONFIG)){
            example.createCriteria().andStatusEqualTo("0000");
        }

        List<Customer> list = customerMapper.selectByExample(example);

        return new PageInfo<>(list);
    }

    /*
    * 管理员删除用户信息
    * */
    @Override
    public Map<String, Object> deleteInfoByAdmin(String ids) {

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("type", CommonConstant.FAIL_CODE);
        resultMap.put("message", CommonConstant.FAIL_MSG);

        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();

        List<Integer> list = new ArrayList<>();

        for (String id : ids.split(",")) {
            if(!StringUtils.isBlank(id)){
                list.add(Integer.valueOf(id));
            }
        }

        criteria.andIdIn(list);
        List<Customer> infoList = customerMapper.selectByExample(example);

        for (Customer customer : infoList) {
            customer.setStatus("9999");
            customerMapper.updateByPrimaryKey(customer);
        }

        resultMap.put("type", CommonConstant.SUCCESS_CODE);
        resultMap.put("message", CommonConstant.SUCCESS_MSG);

        return resultMap;
    }

    @Override
    public List<Customer> fetchInfoDataBySelect() {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo("0000");
        return customerMapper.selectByExample(example);
    }

    /*
    * 修改密码
    * */
    @Override
    public Map<String, String> updatePass(Map<String, Object> map) {
        Map<String, String> resultMap = new HashMap<>();
        Customer info = customerMapper.selectByPrimaryKey((Integer) map.get("id"));

        if(!info.getPassword().equals(map.get("oldPassword"))){
            resultMap.put("type", CommonConstant.FAIL_CODE);
            resultMap.put("message", "原密码输入错误");
        }else if(info.getPassword().equals(map.get("newPassword"))){
            resultMap.put("type", CommonConstant.FAIL_CODE);
            resultMap.put("message", "新密码不可与上次旧密码一样");
        } else{
            info.setPassword((String) map.get("newPassword"));
            customerMapper.updateByPrimaryKeySelective(info);
            resultMap.put("type", CommonConstant.SUCCESS_CODE);
            resultMap.put("message", "密码修改成功");
        }

        return resultMap;
    }

    /*
    修改个人信息
    * */
    @Override
    public Map<String, String> updateInfo(Customer customer) {

        Map<String, String> resultMap = new HashMap<>();
        try {
            CustomerExample example = new CustomerExample();
            example.createCriteria().andIdEqualTo(customer.getId());

            CustomerExample emailExample = new CustomerExample();
            CustomerExample.Criteria emailCriteria = emailExample.createCriteria();
            emailCriteria.andEmailEqualTo(customer.getEmail());
            emailCriteria.andIdNotEqualTo(customer.getId());
            List<Customer> emailList = customerMapper.selectByExample(emailExample);

            CustomerExample cardExample = new CustomerExample();
            CustomerExample.Criteria cardCriteria = cardExample.createCriteria();
            cardCriteria.andIdentityCardEqualTo(customer.getIdentityCard());
            cardCriteria.andIdNotEqualTo(customer.getId());
            List<Customer> cardList = customerMapper.selectByExample(cardExample);

            if (emailList != null && emailList.size() > 0) {
                resultMap.put("type", CommonConstant.FAIL_CODE);
                resultMap.put("message", "邮箱已被注册");
            } else if (cardList != null && cardList.size() > 0) {
                resultMap.put("type", CommonConstant.FAIL_CODE);
                resultMap.put("message", "身份证已被占用");
            } else {
                customerMapper.updateByExampleSelective(customer, example);
                resultMap.put("type", CommonConstant.SUCCESS_CODE);
                resultMap.put("message", CommonConstant.SUCCESS_MSG);
            }
        } catch (Exception e) {
            resultMap.put("type", CommonConstant.FAIL_CODE);
            resultMap.put("message", CommonConstant.FAIL_MSG);
        }
        return resultMap;
    }

    /*
    * 用户注册
    * */
    @Override
    public Map<String, String> register(Customer customer) {

        Map<String, String> resultMap = new HashMap<>();
        try {

            CustomerExample emailExample = new CustomerExample();
            CustomerExample.Criteria emailCriteria = emailExample.createCriteria();
            emailCriteria.andEmailEqualTo(customer.getEmail());
            List<Customer> emailList = customerMapper.selectByExample(emailExample);

            CustomerExample cardExample = new CustomerExample();
            CustomerExample.Criteria cardCriteria = cardExample.createCriteria();
            cardCriteria.andIdentityCardEqualTo(customer.getIdentityCard());
            List<Customer> cardList = customerMapper.selectByExample(cardExample);

            if (emailList != null && emailList.size() > 0) {
                resultMap.put("type", CommonConstant.FAIL_CODE);
                resultMap.put("message", "邮箱已被注册");
            } else if (cardList != null && cardList.size() > 0) {
                resultMap.put("type", CommonConstant.FAIL_CODE);
                resultMap.put("message", "身份证已被占用");
            } else {
                customer.setRegisterTime(new Date());
                customer.setStatus("0000");

                customerMapper.insertSelective(customer);
                resultMap.put("type", CommonConstant.SUCCESS_CODE);
                resultMap.put("message", CommonConstant.SUCCESS_MSG);
            }
        } catch (Exception e) {
            resultMap.put("type", CommonConstant.FAIL_CODE);
            resultMap.put("message", CommonConstant.FAIL_MSG);
        }
        return resultMap;
    }

    /*
    * 用户登录
    * */
    @Override
    public Map<String, Object> login(String username, String password, HttpServletRequest request) {

        Map<String, Object> resultMap = new HashMap<>();

        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        criteria.andStatusEqualTo("0000");
        List<Customer> customerList = customerMapper.selectByExample(customerExample);

        if (customerList != null && customerList.size() > 0) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(CommonConstant.SESSION_TIMEOUT);
            session.setAttribute(CommonConstant.USER_SESSION_USERNAME, username);
            session.setAttribute(CommonConstant.USER_SESSION_ID, customerList.get(0).getId());
            resultMap.put("type", CommonConstant.SUCCESS_CODE);
            resultMap.put("message", CommonConstant.SUCCESS_MSG);
            resultMap.put("user", customerList.get(0));
        } else {
            resultMap.put("type", CommonConstant.FAIL_CODE);
            resultMap.put("message", CommonConstant.FAIL_MSG);
        }
        return resultMap;
    }
}
