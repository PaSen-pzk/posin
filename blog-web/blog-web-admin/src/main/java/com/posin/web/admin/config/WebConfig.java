package com.posin.web.admin.config;

import com.posin.web.admin.interceptor.FrontInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("security.interceptor.exclude_path")
    private String excludePathPatterns;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getFrontInterceptor())
                // 需要包含的路径
//                .addPathPatterns()
                // 需要排除的路径
                .excludePathPatterns(getExcludePathPatterns())
                // 添加拦截器顺序
                .order(1);
    }

    protected FrontInterceptor getFrontInterceptor() {
        return new FrontInterceptor();
    }

    protected String[] getExcludePathPatterns() {
        if(StringUtils.isNoneBlank(excludePathPatterns)) {
            return excludePathPatterns.split(",");
        }
        return new String[]{};
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
