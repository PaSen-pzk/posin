//package com.posin.blog.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * @author zkP
// * @date 2023/12/19 21:49
// * @func
// * @description
// */
//@Configuration
//public class SecurityConfig
////        extends WebSecurityConfigurerAdapter
//{
//
//    //定义用户信息服务（查询用户信息）
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("posin").password("123456").authorities("p1").build());
//        manager.createUser(User.withUsername("admin").password("123456").authorities("p2").build());
//        return manager;
//    }
//
//    //密码编码器,不加密，字符串直接比较
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/hello");
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        //指定了认证方式为 HTTP Basic 登录，并且所有请求都需要进行认证
////        http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
////    }
//
//    @Bean
//    WebSecurityCustomizer webSecurityCustomizer() {
//        return web -> web.ignoring().antMatchers("/hello");
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .csrf().disable();
//        return http.build();
//    }
//}
