package com.controller;

import com.constant.CommonConstant;
import com.entity.Order;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/")
    public List<Order> fetchInfoData(HttpServletRequest request){
        return orderService.fetchTicketInfo(request);
    }

    @PutMapping("/back")
    public Map<String, Object> updateInfoData(@RequestBody Map map){
        return orderService.updateInfoData(map);
    }

    @PostMapping("/addInfoData")
    public Map<String, Object> addInfoData(@RequestBody Order order){
        return orderService.addInfoData(order);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteInfo(@PathVariable String id){
        return orderService.deleteInfo(id);
    }

    @GetMapping("/fetchPageInfo")
    public PageInfo<Order> fetchPageInfo(@RequestParam(required = false, defaultValue = "1") Integer page,
                                         @RequestParam(required = false) String fuzzy,
                                         @RequestParam(required = false, defaultValue = "A") String fetchType,
                                         HttpServletRequest request){
        return orderService.fetchPageInfo(page, CommonConstant.PAGE_SIZE, fuzzy, fetchType, request);
    }

    @GetMapping("/admin")
    public PageInfo fetchInfoDataByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return orderService.fetchInfoDataByAdmin(page, pageSize, fuzzy);
    }

    @PutMapping("/admin")
    public Map<String, Object> updateInfoDataByAdmin(@RequestBody Order order){
        return orderService.updateInfoDataByAdmin(order);
    }

    @PostMapping("/admin")
    public Map<String, Object> addInfoDataByAdmin(@RequestBody Order order, HttpServletRequest request){
        return orderService.addInfoDataByAdmin(order, request);
    }

    @DeleteMapping("/admin/{ids}")
    public Map<String, Object> deleteInfoByAdmin(@PathVariable String ids){
        return orderService.deleteInfoByAdmin(ids);
    }

}
