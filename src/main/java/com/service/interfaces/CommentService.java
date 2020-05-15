package com.service.interfaces;

import com.entity.Comment;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CommentService {

    PageInfo fetchInfoDataByAdmin(Integer page, Integer pageSize, String fuzzy);

    Map<String, Object> deleteInfoByAdmin(String ids);

    List<Comment> fetchNewInfoData();

    List<Comment> getTreeData();

    List<Comment> fetchAllInfoData();

    Map<String,Object> addInfoData(Comment comment, HttpServletRequest request);
}
