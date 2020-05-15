package com.util;

import com.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ApplicationInit implements ApplicationRunner {

    @Resource
    RedisUtil redisUtil;

    @Value("${state.show}")
    private Boolean stateShow;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisUtil.set("0000", "正常状态");
        redisUtil.set("9999", "删除状态");
        redisUtil.set(CommonConstant.STATE_CONFIG, stateShow);
    }
}
