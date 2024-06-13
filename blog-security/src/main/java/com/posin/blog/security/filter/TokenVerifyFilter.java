//package com.posin.manage.security.filter;
//
//import com.posin.manage.model.Payload;
//import com.posin.manage.pojo.LoginUser;
//import com.posin.manage.utils.JwtTokenUtils;
//import com.posin.manage.utils.RSAKeyProperties;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author zkP
// * @date 2024/2/19 22:37
// * @func
// * @description
// */
//public class TokenVerifyFilter extends BasicAuthenticationFilter {
//    private RSAKeyProperties prop;
//
//    public TokenVerifyFilter(AuthenticationManager authenticationManager, RSAKeyProperties prop) {
//        super(authenticationManager);
//        this.prop = prop;
//    }
//
//    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader("Authorization");
//        if (header == null || !header.startsWith("Bearer ")) {
//            //如果携带错误的token，则给用户提示请登录！
//            chain.doFilter(request, response);
//        } else {
//            //如果携带了正确格式的token要先得到token
//            String token = header.replace("Bearer ", "");
//            //通过公钥进行解密：验证tken是否正确
//            Payload<LoginUser> payload = JwtTokenUtils.getInfoFromToken(token, prop.getPublicKey(), LoginUser.class);
//            LoginUser user = payload.getUserInfo();
//            if(user!=null){
//                UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
//                //将认证信息存到安全上下文中
//                SecurityContextHolder.getContext().setAuthentication(authResult);
//                chain.doFilter(request, response);
//            }
//        }
//    }
//}
