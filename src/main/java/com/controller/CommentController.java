package com.controller;

import com.entity.Comment;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/")
    public Map<String, Object> addInfoData(@RequestBody Comment comment, HttpServletRequest request){
        return commentService.addInfoData(comment, request);
    }

    @GetMapping("/all")
    public List<Comment> fetchAllInfoData(){
        return commentService.fetchAllInfoData();
    }

    @GetMapping("/newCommentInfo")
    public List<Comment> fetchNewInfoData(){
        return commentService.fetchNewInfoData();
    }

    @GetMapping("/admin")
    public PageInfo fetchInfoDataByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return commentService.fetchInfoDataByAdmin(page, pageSize, fuzzy);
    }

    @DeleteMapping("/admin/{ids}")
    public Map<String, Object> deleteInfoByAdmin(@PathVariable String ids){
        return commentService.deleteInfoByAdmin(ids);
    }


}
