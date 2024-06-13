//package com.posin.manage.security.filter;
//
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.List;
//
///**
// * @author zkP
// * @date 2024/5/21 21:38
// * @func
// * @description
// */
//public class WhiteListFilter implements Filter {
//
//    private List<RequestMatcher> whiteListMatchers;
//
//    public WhiteListFilter(List<String> whiteListPatterns) {
//        whiteListMatchers = whiteListPatterns.stream()
//                .map(AntPathRequestMatcher::new)
//                .toList();
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        if (whiteListMatchers.stream().anyMatch(matcher -> matcher.matches(httpRequest))) {
//            chain.doFilter(request, response);
//        } else {
//            // 这里可以调用Spring Security的其他过滤器逻辑，让Spring Security正常处理请求
//            // 例如，调用 chain.doFilter(request, response) 会跳过其他Spring Security过滤器
//        }
//    }
//
//    // ... 省略其他方法
//}
