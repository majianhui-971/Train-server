package com.service.interfaces;

import com.entity.Drive;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DriveService {
    PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy);

    Map<String,Object> updateInfoDataByAdmin(Drive drive);

    Map<String,Object> addInfoDataByAdmin(Drive drive, HttpServletRequest request);

    Map<String,Object> deleteInfoByAdmin(String ids);

    List<Drive> fetchInfoDataBySelect();
}
