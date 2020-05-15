package com.controller;

import com.entity.Drive;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.DriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drive")
public class DriveController {

    @Autowired
    DriveService driveService;

    @GetMapping("/")
    public List<Drive> fetchInfoData(){
        return null;
    }

    @PutMapping("/")
    public List<Drive> updateInfoData(@RequestBody Drive drive){
        return null;
    }

    @PostMapping("/")
    public List<Drive> addInfoData(@RequestBody Drive drive){
        return null;
    }

    @DeleteMapping("/{ids}")
    public List<Drive> deleteInfo(@PathVariable String ids){
        return null;
    }

    @GetMapping("/admin")
    public PageInfo fetchInfoDataByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return driveService.fetchInfoDataByAdmin(page, pageSize, fuzzy);
    }

    @PutMapping("/admin")
    public Map<String, Object> updateInfoDataByAdmin(@RequestBody Drive drive){
        return driveService.updateInfoDataByAdmin(drive);
    }

    @PostMapping("/admin")
    public Map<String, Object> addInfoDataByAdmin(@RequestBody Drive drive, HttpServletRequest request){
        return driveService.addInfoDataByAdmin(drive, request);
    }

    @DeleteMapping("/admin/{ids}")
    public Map<String, Object> deleteInfoByAdmin(@PathVariable String ids){
        return driveService.deleteInfoByAdmin(ids);
    }

    @GetMapping("/select")
    public List<Drive> fetchInfoDataBySelect(){
        return driveService.fetchInfoDataBySelect();
    }
}
