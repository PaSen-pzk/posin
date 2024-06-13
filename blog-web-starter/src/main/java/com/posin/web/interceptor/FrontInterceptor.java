package com.posin.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.posin.web.service.BlogGlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zkP
 * @date 2024/1/24 19:51
 * @func
 * @description
 */
@Component
public class FrontInterceptor implements HandlerInterceptor {

    @Autowired
    private BlogGlobalService blogGlobalService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Map<String, String> services = blogGlobalService.getGlobalServices();
        modelAndView.addObject("ADMIN_API_SERVICE", services.get("ADMIN_SERVICE"));
        modelAndView.addObject("UI_WEB_SERVICE", services.get("UI_SYS_SERVICE"));
        modelAndView.addObject("BLOG_API_SERVICE", services.get("BLOG_SERVICE"));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
