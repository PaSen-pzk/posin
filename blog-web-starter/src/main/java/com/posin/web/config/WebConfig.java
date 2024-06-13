package com.posin.web.config;

import com.posin.web.interceptor.FrontInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zkP
 * @date 2024/1/24 20:15
 * @func
 * @description
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private FrontInterceptor frontInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(frontInterceptor)
                // 需要包含的路径
//                .addPathPatterns()
                // 需要排除的路径
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/icons/**")
                // 添加拦截器顺序
                .order(1);
    }

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
