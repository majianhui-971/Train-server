package com.controller;

import com.entity.Customer;
import com.github.pagehelper.PageInfo;
import com.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PutMapping("/login")   //用户登录
    public Map<String, Object> login(@RequestBody Customer customer, HttpServletRequest request){
        return customerService.login(customer.getUsername(), customer.getPassword(), request);
    }


    @PutMapping("/register")    //用户注册
    public Map<String, String> register(@RequestBody Customer customer){
        return customerService.register(customer);
    }


    @PutMapping("/updateInfo")  //修改信息
    public Map<String, String> updateInfo(@RequestBody Customer customer){
        return customerService.updateInfo(customer);
    }

    @PutMapping("/updatePass")  //修改密码
    public Map<String, String> updatePass(@RequestBody Map<String, Object> map){
        return customerService.updatePass(map);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/")
    public List<Customer> fetchInfoData(){
        return null;
    }

    @PutMapping("/")
    public List<Customer> updateInfoData(@RequestBody Customer customer){
        return null;
    }

    @PostMapping("/")
    public List<Customer> addInfoData(@RequestBody Customer customer){
        return null;
    }

    @GetMapping("/select")
    public List<Customer> fetchInfoDataBySelect(){
        return customerService.fetchInfoDataBySelect();
    }

    @DeleteMapping("/{ids}")
    public List<Customer> deleteInfo(@PathVariable String ids){
        return null;
    }

    @GetMapping("/admin")
    public PageInfo fetchInfoDataByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy){
        return customerService.fetchInfoDataByAdmin(page, pageSize, fuzzy);
    }

    @PutMapping("/admin")
    public List<Customer> updateInfoDataByAdmin(@RequestBody Customer customer){
        return null;
    }

    @PostMapping("/admin")
    public List<Customer> addInfoDataByAdmin(@RequestBody Customer customer){
        return null;
    }

    @DeleteMapping("/admin/{ids}")
    public Map<String, Object> deleteInfoByAdmin(@PathVariable String ids){
        return customerService.deleteInfoByAdmin(ids);
    }

}
