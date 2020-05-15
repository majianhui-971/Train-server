package com.service.interfaces;

import com.entity.Admin;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AdminService {

    Map<String, Object> login(String username, String password, HttpServletRequest request);

    PageInfo selectInfoData(Integer page, Integer pageSize, String fuzzy);

    Map<String, Object> updateInfoData(Admin admin);

    Map<String, Object> addInfoData(Admin admin);

    Map<String, Object> deleteInfo(String ids);
}
