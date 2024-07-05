//package com.posin.manage.security.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.util.PathMatcher;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//
///**
// * @author zkP
// * @date 2024/6/13 22:32
// * @func
// * @description
// */
//@Slf4j
//@Component
//public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
//
//    private static Map<String, ConfigAttribute> configAttributeMap = null;
//
//    @Autowired
//    private DynamicSecurityService dynamicSecurityService;
//
//    @PostConstruct
//    public void loadDataSource() {
//        configAttributeMap = dynamicSecurityService.loadDataSource();
//    }
//
//    public void clearDataSource() {
//        configAttributeMap.clear();
//        configAttributeMap = null;
//    }
//
//    /**
//     * 参考链接： https://juejin.cn/post/7176803095525982269?searchId=20240613224032EAC908DCD7011D359553
//     */
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        if (configAttributeMap == null) {
//            this.loadDataSource();
//        }
//        List<ConfigAttribute> configAttributes = new ArrayList<>();
//        //获取当前访问的路径
//        String url = ((FilterInvocation) object).getRequestUrl();
////        String path = URLUtil.getPath(url);
//        PathMatcher pathMatcher = new AntPathMatcher();
//        Iterator<String> iterator = configAttributeMap.keySet().iterator();
//        //获取访问该路径所需资源
//        while (iterator.hasNext()) {
//            String pattern = iterator.next();
//            if (pathMatcher.match(pattern, url)) {
//                configAttributes.add(configAttributeMap.get(pattern));
//            }
//        }
//        // 未设置操作请求权限，返回空集合
//        return configAttributes;
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return true;
//    }
//}
