package com.service.interfaces;

import com.entity.Message;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface MessageService {
    PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy);

    Map<String,Object> updateInfoDataByAdmin(Message message);

    Map<String,Object> addInfoDataByAdmin(Message message, HttpServletRequest request);

    Map<String,Object> deleteInfoByAdmin(String ids);

    PageInfo<Message> fetchInfoData(Integer page, Integer size,String fuzzy);

    List<Message> fetchNewInfoData();
}
