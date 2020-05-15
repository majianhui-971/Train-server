package com.service.interfaces;

import com.entity.Site;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SiteService {
    List<Site> getSiteInfo();

    PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy);

    Map<String,Object> updateInfoDataByAdmin(Site site);

    Map<String,Object> addInfoDataByAdmin(Site site, HttpServletRequest request);

    Map<String,Object> deleteInfoByAdmin(String ids);

    List<Site> fetchInfoDataBySelect();
}
