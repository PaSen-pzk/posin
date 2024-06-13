package com.posin.blog.security.handler;

import com.alibaba.fastjson.JSON;
import com.posin.blog.constants.Constants;
import com.posin.blog.security.util.ServletUtils;
import com.posin.blog.vo.ResultVo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkP
 * @date 2024/5/21 0:57
 * @func
 * @description 权限校验处理器
 */
@Component
public class AccessDeniedHandlerExceptionHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        //权限校验失败
        ResultVo<Object> resultVo = ResultVo.success(Constants.Code.NO_AUTHORITY);
        String string = JSON.toJSONString(resultVo);
        ServletUtils.renderString(httpServletResponse, string);
    }
}
