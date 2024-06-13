//package com.posin.blog.util;
//
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class CommonUtils {
//
//    private CommonUtils() {
//    }
//
//    public static String validateToken(HttpServletRequest request) {
//        String accessToken = request.getParameter("token");
//        if(!StringUtils.hasText(accessToken)) {
//            accessToken = request.getHeader("Authorization");
//            if(!StringUtils.hasText(accessToken)) {
//                accessToken = request.getHeader("token");
//            }
//        }
//        return accessToken;
//    }
//}
