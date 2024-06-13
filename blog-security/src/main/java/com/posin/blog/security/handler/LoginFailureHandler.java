package com.posin.blog.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zkP
 * @date 2024/2/19 23:19
 * @func 登录失败处理器
 * @description
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private final String forwardUrl;

    public LoginFailureHandler(String forwardUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(forwardUrl), () -> {
            return "'" + forwardUrl + "' is not a valid forward URL";
        });
        this.forwardUrl = forwardUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect(this.forwardUrl);
    }
}
