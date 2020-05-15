package com.config;

import com.util.RedisUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
@Component
public class OnLineListener implements HttpSessionListener {

    @Resource
    RedisUtil redisUtil;

    public OnLineListener() {
    }

    /*
    * 创建监听器
    * */

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int onLineCount = 0;
        if (redisUtil.get("OnLineCount") != null) {
            onLineCount = (int) redisUtil.get("OnLineCount");
        }
        redisUtil.set("OnLineCount", ++onLineCount);
    }

    /*
    * 监听器销毁
    * */

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        int onLineCount = 0;
        if (redisUtil.get("OnLineCount") != null) {
            onLineCount = (int) redisUtil.get("OnLineCount");
        }
        if(onLineCount > 1){
            redisUtil.set("OnLineCount", --onLineCount);
        }else {
            redisUtil.set("OnLineCount", 0);
        }
    }
}
