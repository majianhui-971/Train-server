package com.service.interfaces;

import com.entity.Order;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface OrderService {
    PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy);

    Map<String,Object> updateInfoDataByAdmin(Order order);

    Map<String,Object> addInfoDataByAdmin(Order order, HttpServletRequest request);

    Map<String,Object> deleteInfoByAdmin(String ids);

    Map<String, Object> addInfoData(Order order);

    PageInfo<Order> fetchPageInfo(Integer page, Integer size, String fuzzy, String fetchType, HttpServletRequest request);

    List<Order> fetchTicketInfo(HttpServletRequest request);

    Map<String, Object> updateInfoData(Map map);

    Map<String, Object> deleteInfo(String id);
}
