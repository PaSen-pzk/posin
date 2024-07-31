package com.posin.web.admin.interceptor;

import com.posin.web.admin.service.BlogGlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zkP
 * @date 2024/1/24 19:51
 * @func
 * @description
 */
public class FrontInterceptor implements HandlerInterceptor {

//    @Autowired
//    private BlogGlobalService blogGlobalService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        Map<String, String> services = blogGlobalService.getGlobalServices();
//        modelAndView.addObject("applicationUrlPath", services);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
