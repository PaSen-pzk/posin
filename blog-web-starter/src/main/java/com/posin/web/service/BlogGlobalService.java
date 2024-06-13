package com.posin.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zkP
 * @date 2024/1/24 20:00
 * @func
 * @description
 */
@Service
public class BlogGlobalService {

    @Value("${services.admin_url}")
    private String adminServiceUrl;

    @Value("${services.blog_url}")
    private String blogServiceUrl;

    @Value("${services.ui_sys_url}")
    private String uiSysUrl;

    public Map<String, String> getGlobalServices() {
        Map<String, String> services = new HashMap<>();
        services.put("ADMIN_SERVICE", adminServiceUrl);
        services.put("BLOG_SERVICE", blogServiceUrl);
        services.put("UI_SYS_SERVICE", uiSysUrl);
        return services;
    }
}
