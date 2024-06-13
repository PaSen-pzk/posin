//package com.posin.manage.security.service;
//
//import com.alibaba.fastjson.JSON;
//import com.posin.manage.utils.ServletUtils;
//import com.posin.manage.vo.ResultVo;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.Serializable;
//
///**
// * @author zkP
// * @date 2024/2/19 22:04
// * @func 返回未授权
// * @description
// */
//@Component
//public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        HttpStatus code = HttpStatus.UNAUTHORIZED;
//        String msg = "认证失败，无法访问系统资源，请先登陆";
//        ServletUtils.renderString(response, JSON.toJSONString(ResultVo.error(String.valueOf(code.value()), msg)));
//    }
//}
