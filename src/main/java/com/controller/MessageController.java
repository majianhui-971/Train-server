package com.controller;

import com.entity.Message;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/messageInfo/fetchInfoData")
    public PageInfo<Message> fetchInfoData(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size,
                                           @RequestParam(required = false) String fuzzy){
        return messageService.fetchInfoData(page,size,fuzzy);
    }

    @PutMapping("/")
    public List<Message> updateInfoData(@RequestBody Message message){
        return null;
    }

    @PostMapping("/")
    public List<Message> addInfoData(@RequestBody Message message){
        return null;
    }

    @DeleteMapping("/{ids}")
    public List<Message> deleteInfo(@PathVariable String ids){
        return null;
    }

    @GetMapping("/newMessageInfo")
    public List<Message> fetchNewInfoData(){
        return messageService.fetchNewInfoData();
    }


    @GetMapping("/admin")
    public PageInfo fetchInfoDataByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return messageService.fetchInfoDataByAdmin(page, pageSize, fuzzy);
    }

    @PutMapping("/admin")
    public Map<String, Object> updateInfoDataByAdmin(@RequestBody Message message){
        return messageService.updateInfoDataByAdmin(message);
    }

    @PostMapping("/admin")
    public Map<String, Object> addInfoDataByAdmin(@RequestBody Message message, HttpServletRequest request){
        return messageService.addInfoDataByAdmin(message,request);
    }

    @DeleteMapping("/admin/{ids}")
    public Map<String, Object> deleteInfoByAdmin(@PathVariable String ids){
        return messageService.deleteInfoByAdmin(ids);
    }

}
