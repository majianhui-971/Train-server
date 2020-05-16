package com.interceptor;

import com.constant.CommonConstant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        String path = request.getServletPath();

        if(path.contains("select")){
            return true;
        }

        if (path.contains("admin")) {
            String adminName = (String) session.getAttribute(CommonConstant.ADMIN_SESSION_NAME);
            return !StringUtils.isBlank(adminName);
        }else {
            String userName = (String) session.getAttribute(CommonConstant.USER_SESSION_USERNAME);
            return !StringUtils.isBlank(userName);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
