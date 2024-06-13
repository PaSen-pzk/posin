package com.posin.blog.security.handler;

import com.alibaba.fastjson.JSON;
import com.posin.blog.constants.Constants;
import com.posin.blog.security.util.ServletUtils;
import com.posin.blog.vo.ResultVo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkP
 * @date 2024/5/21 0:52
 * @func
 * @description 认证失败处理器
 */
@Component
public class AuthenticationEntryPointExceptionHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //用户认证失败
        ResultVo<Object> resultVo = ResultVo.success(Constants.Code.SECURITY_CODE);
        String string = JSON.toJSONString(resultVo);
        ServletUtils.renderString(httpServletResponse, string);
    }
}
