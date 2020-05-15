package com.service.interfaces;

import com.entity.Line;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface LineService {
    PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy);

    Map<String,Object> updateInfoDataByAdmin(Line line);

    Map<String,Object> addInfoDataByAdmin(Line line, HttpServletRequest request);

    Map<String,Object> deleteInfoByAdmin(String ids);

    List<Line> fetchInfoDataBySelect();
}
