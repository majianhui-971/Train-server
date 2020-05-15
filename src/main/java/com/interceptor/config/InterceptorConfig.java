package com.interceptor.config;

import com.interceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private static String[] defaultExcludes = new String[]{"/customer/login", "/customer/register", "/admin/login"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(defaultExcludes);
    }
}
