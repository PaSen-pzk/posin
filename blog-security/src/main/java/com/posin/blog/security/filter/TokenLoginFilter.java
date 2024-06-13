//package com.posin.manage.security.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.posin.manage.pojo.LoginUser;
//import com.posin.manage.utils.JwtTokenUtils;
//import com.posin.manage.utils.RSAKeyProperties;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author zkP
// * @date 2024/2/19 22:12
// * @func
// * @description
// */
//public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {
//
//    private AuthenticationManager authenticationManager;
//
//    private RSAKeyProperties prop;
//
//    public TokenLoginFilter(AuthenticationManager authenticationManager, RSAKeyProperties prop) {
//        this.authenticationManager = authenticationManager;
//        this.prop = prop;
//    }
//
//    /**
//     * @author cheetah
//     * @description 登陆验证
//     * @date 2021/6/28 16:17
//     * @Param [request, response]
//     * @return org.springframework.security.core.Authentication
//     **/
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            LoginUser sysUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);
//            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword());
//            return authenticationManager.authenticate(authRequest);
//        }catch (Exception e){
//            try {
//                response.setContentType("application/json;charset=utf-8");
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                PrintWriter out = response.getWriter();
//                Map resultMap = new HashMap();
//                resultMap.put("code", HttpServletResponse.SC_UNAUTHORIZED);
//                resultMap.put("msg", "用户名或密码错误！");
//                out.write(new ObjectMapper().writeValueAsString(resultMap));
//                out.flush();
//                out.close();
//            }catch (Exception outEx){
//                outEx.printStackTrace();
//            }
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    /**
//     * @author cheetah
//     * @description 登陆成功回调
//     * @date 2021/6/28 16:17
//     * @Param [request, response, chain, authResult]
//     * @return void
//     **/
//    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        LoginUser user = new LoginUser();
//        user.getAdminUser().setUsername(authResult.getName());
////        user.setRoles((List<RolePojo>)authResult.getAuthorities());
//        //通过私钥进行加密：token有效期一天
//        String token = JwtTokenUtils.generateTokenExpireInMinutes(user, prop.getPrivateKey(), 24 * 60);
//        response.addHeader("Authorization", "Bearer "+token);
//        try {
//            response.setContentType("application/json;charset=utf-8");
//            response.setStatus(HttpServletResponse.SC_OK);
//            PrintWriter out = response.getWriter();
//            Map resultMap = new HashMap();
//            resultMap.put("code", HttpServletResponse.SC_OK);
//            resultMap.put("msg", "认证通过！");
//            resultMap.put("token", token);
//            out.write(new ObjectMapper().writeValueAsString(resultMap));
//            out.flush();
//            out.close();
//        }catch (Exception outEx){
//            outEx.printStackTrace();
//        }
//    }
//}
