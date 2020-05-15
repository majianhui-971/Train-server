package com.controller;

import com.entity.Admin;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PutMapping("/login")     //管理员登录
    public Map<String, Object> login(@RequestBody Admin admin, HttpServletRequest request){
        return adminService.login(admin.getUsername(), admin.getPassword(), request);
    }

    @GetMapping("/info")        //查询    (分页查询)
    public PageInfo fetchInfoData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return adminService.selectInfoData(page, pageSize, fuzzy);
    }

    @PutMapping("/info")        //修改
    public Map<String, Object> updateInfoData(@RequestBody Admin admin){
        return adminService.updateInfoData(admin);
    }

    @PostMapping("/info")       //添加
    public Map<String, Object> addInfoData(@RequestBody Admin admin){
        return adminService.addInfoData(admin);
    }

    @DeleteMapping("/info/{ids}")   //删除
    public Map<String, Object> deleteInfo(@PathVariable String ids){
        return adminService.deleteInfo(ids);
    }




}
