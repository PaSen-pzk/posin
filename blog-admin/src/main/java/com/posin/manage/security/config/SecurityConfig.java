package com.posin.manage.security.config;

import com.posin.blog.cache.RedisCache;
import com.posin.blog.security.filter.JwtAuthenticationTokenFilter;
import com.posin.blog.security.handler.AccessDeniedHandlerExceptionHandler;
import com.posin.blog.security.handler.AuthenticationEntryPointExceptionHandler;
import com.posin.manage.security.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author zkP
 * @date 2024/2/19 22:03
 * @func
 * @description
 */
//开启全局方法安全性
@Configuration
@EnableWebSecurity
//开启security权限配置
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final SysUserInfoService sysUserInfoService;

    public SecurityConfig(SysUserInfoService sysUserDetailService) {
        this.sysUserInfoService = sysUserDetailService;
    }

    @Autowired
    private AuthenticationEntryPointExceptionHandler authenticationEntryPointExceptionHandler;

    @Autowired
    private AccessDeniedHandlerExceptionHandler accessDeniedHandlerExceptionHandler;

    @Autowired
    private RedisCache redisCache;

    @Value("${sys.url.portal_url}")
    private String redirectUrl;

    @Value("${sys.url.login_url}")
    private String forwardUrl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //CSRF禁用，因为不使用session
                .csrf().disable()
                //基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPointExceptionHandler)
                    .accessDeniedHandler(accessDeniedHandlerExceptionHandler)
                .and()
                //过滤请求
                .authorizeRequests()
                //对于登录login  允许匿名访问
                .antMatchers("/login","/**/login","/blog-admin-service/login").anonymous()
                //除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();
        http
                // 添加JWT filter
                .addFilterBefore(new JwtAuthenticationTokenFilter(redisCache), UsernamePasswordAuthenticationFilter.class);
        //允许跨域
        http.cors();

    }

    //指定认证对象的来源
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(sysUserInfoService)
                //从前端传递过来的密码就会被加密，所以从数据库
                //查询到的密码必须是经过加密的，而这个过程都是
                //在用户注册的时候进行加密的。
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login","/**/login","/blog-admin-service/login")
                .antMatchers(HttpMethod.GET,
                "/view/login_",
                "/*.html",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js");
    }

    //密码加密
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
