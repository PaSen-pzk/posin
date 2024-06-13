package com.posin.blog.security.filter;

import com.posin.blog.cache.RedisCache;
import com.posin.blog.security.model.LoginUser;
import com.posin.blog.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private RedisCache redisCache;

    public JwtAuthenticationTokenFilter(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        // 获取token
        String token = request.getHeader("Authorization");
        // 1.如果没有获取到token，直接放行，后面会有拦截器拦截它的, 即表明用户未登录过
        if(!StringUtils.hasText(token)){
            chain.doFilter(request, response);
            return;
        }
        // 2. 如果获取到token后才进行以下操作,即表明已经登录过了
        // 2.1 解析token
        Claims claims = null;
        try {
            claims = JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            //token超时  token非法
            //响应告诉前端需要重新登录
            throw new RuntimeException("token非法");
        }
        // 2.2根据token解析的用户id去redis中获取用户信息 TODO
        String userId = claims.getSubject();
        LoginUser loginUser = redisCache.getCacheObject("bloglogin:" + userId);

        // 2.2.1 如果获取不到,说明登录过期  提示重新登录
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("用户登录过期");
        }

        //2.2.2 存入SecurityContextHolder
        // TODO 获取权限信息封装到 authenticationToken
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // token存在且解析完了，则放行
        chain.doFilter(request, response);
    }


}
