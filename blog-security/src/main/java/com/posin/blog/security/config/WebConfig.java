package com.posin.blog.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zkP
 * @date 2024/5/21 1:01
 * @func
 * @description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许跨域请求的域名设置
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
    }
}
