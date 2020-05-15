package com.service.interfaces;

import com.entity.Customer;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CustomerService{

    Map<String,Object> login(String username, String password, HttpServletRequest request);

    Map<String,String> register(Customer customer);

    Map<String,String> updateInfo(Customer customer);

    Map<String,String> updatePass(Map<String, Object> map);

    Customer getCustomer(int id);

    PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy);

    Map<String, Object> deleteInfoByAdmin(String ids);

    List<Customer> fetchInfoDataBySelect();
}
