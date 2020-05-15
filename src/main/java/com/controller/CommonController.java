package com.controller;

import com.constant.CommonConstant;
import com.util.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
public class CommonController {

    @Resource
    RedisUtil redisUtil;

    @RequestMapping("/message")
    public String getMessage() {
        return CommonConstant.MESSAGE;
    }

    @RequestMapping("/online")
    public Integer getOnline() {
        return (Integer) redisUtil.get("OnLineCount");
    }

    @RequestMapping("/session")
    public void deleteUserSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(CommonConstant.USER_SESSION_USERNAME);
        session.removeAttribute(CommonConstant.USER_SESSION_ID);
    }

    @RequestMapping("/admin/session")
    public void deleteAdminSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(CommonConstant.ADMIN_SESSION_NAME);
        session.removeAttribute(CommonConstant.ADMIN_SESSION_ID);
    }

    @RequestMapping("/redis/data/{key}")
    public Object initRedisData(@PathVariable String key) {
        if (StringUtils.isBlank(key)) {
            return "";
        }
        return redisUtil.get(key);
    }
}
