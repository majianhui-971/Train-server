package com.controller;

import com.entity.Ticket;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/")
    public List<Ticket> fetchInfoData(){
        return null;
    }

    @PutMapping("/")
    public List<Ticket> updateInfoData(@RequestBody Ticket ticket){
        return null;
    }

    @PostMapping("/")
    public List<Ticket> addInfoData(@RequestBody Ticket ticket){
        return null;
    }

    @DeleteMapping("/{ids}")
    public List<Ticket> deleteInfo(@PathVariable String ids){
        return null;
    }

    @GetMapping("/newTicketInfo")
    public List<Ticket> fetchNewInfoData(){
        return ticketService.fetchNewInfoData();
    }

    @PostMapping("/getTicketInfo")
    public PageInfo<Ticket> getTicketInfo(@RequestBody Ticket ticket){
        return ticketService.getTicketInfo(ticket);
    }

    @GetMapping("/admin")
    public PageInfo fetchInfoDataByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return ticketService.fetchInfoDataByAdmin(page, pageSize, fuzzy);
    }

    @PutMapping("/admin")
    public Map<String, Object> updateInfoDataByAdmin(@RequestBody Ticket ticket){
        return ticketService.updateInfoDataByAdmin(ticket);
    }

    @PostMapping("/admin")
    public Map<String, Object> addInfoDataByAdmin(@RequestBody Ticket ticket, HttpServletRequest request){
        return ticketService.addInfoDataByAdmin(ticket, request);
    }

    @DeleteMapping("/admin/{ids}")
    public Map<String, Object> deleteInfoByAdmin(@PathVariable String ids){
        return ticketService.deleteInfoByAdmin(ids);
    }

}
