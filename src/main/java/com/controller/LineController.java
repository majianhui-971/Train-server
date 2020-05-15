package com.controller;

import com.entity.Line;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/line")
public class LineController {

    @Autowired
    LineService lineService;

    @GetMapping("/")
    public List<Line> fetchInfoData(){
        return null;
    }

    @PutMapping("/")
    public List<Line> updateInfoData(@RequestBody Line line){
        return null;
    }

    @PostMapping("/")
    public List<Line> addInfoData(@RequestBody Line line){
        return null;
    }

    @DeleteMapping("/{ids}")
    public List<Line> deleteInfo(@PathVariable String ids){
        return null;
    }

    @GetMapping("/select")
    public List<Line> fetchInfoDataBySelect(){
        return lineService.fetchInfoDataBySelect();
    }

    @GetMapping("/admin")
    public PageInfo fetchInfoDataByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return lineService.fetchInfoDataByAdmin(page, pageSize, fuzzy);
    }

    @PutMapping("/admin")
    public Map<String, Object> updateInfoDataByAdmin(@RequestBody Line line){
        return lineService.updateInfoDataByAdmin(line);
    }

    @PostMapping("/admin")
    public Map<String, Object> addInfoDataByAdmin(@RequestBody Line line, HttpServletRequest request){
        return lineService.addInfoDataByAdmin(line, request);
    }

    @DeleteMapping("/admin/{ids}")
    public Map<String, Object> deleteInfoByAdmin(@PathVariable String ids){
        return lineService.deleteInfoByAdmin(ids);
    }

}
