package com.controller;

import com.entity.Site;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    @GetMapping("/getSiteInfo")
    public List<Site> fetchInfoData(){
        return siteService.getSiteInfo();
    }

    @PutMapping("/")
    public List<Site> updateInfoData(@RequestBody Site site){
        return null;
    }

    @PostMapping("/")
    public List<Site> addInfoData(@RequestBody Site site){
        return null;
    }

    @DeleteMapping("/{ids}")
    public List<Site> deleteInfo(@PathVariable String ids){
        return null;
    }

    @GetMapping("/select")
    public List<Site> fetchInfoDataBySelect(){
        return siteService.fetchInfoDataBySelect();
    }

    @GetMapping("/admin")
    public PageInfo fetchInfoDataByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return siteService.fetchInfoDataByAdmin(page, pageSize, fuzzy);
    }

    @PutMapping("/admin")
    public Map<String, Object> updateInfoDataByAdmin(@RequestBody Site site){
        return siteService.updateInfoDataByAdmin(site);
    }

    @PostMapping("/admin")
    public Map<String, Object> addInfoDataByAdmin(@RequestBody Site site, HttpServletRequest request){
        return siteService.addInfoDataByAdmin(site, request);
    }

    @DeleteMapping("/admin/{ids}")
    public Map<String, Object> deleteInfoByAdmin(@PathVariable String ids){
        return siteService.deleteInfoByAdmin(ids);
    }
}
