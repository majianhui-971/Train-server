package com.service.interfaces;

import com.entity.Ticket;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface TicketService {
    PageInfo<Ticket> getTicketInfo(Ticket ticket);

    Map<String,Object> updateInfoDataByAdmin(Ticket ticket);

    PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy);

    Map<String,Object> addInfoDataByAdmin(Ticket ticket, HttpServletRequest request);

    Map<String,Object> deleteInfoByAdmin(String ids);

    List<Ticket> fetchNewInfoData();
}
