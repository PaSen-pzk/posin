//package com.posin.manage.utils;
//
//import com.posin.manage.pojo.LoginUser;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.util.*;
//
///**
// * @author zkP
// * @date 2024/2/19 22:20
// * @func
// * @description
// */
//@Data
//@Component
//public class JwtTokenUtil {
//
//    @Value("${token.header}")
//    private String header;
//
//    //@Value("${token.secret}")
//    //private String secret;
//
//    @Value("${token.expiration}")
//    private long expiration;
//
//    /**
//     * 生成token令牌
//     * @param user 用户
//     * @return token令牌
//     */
//    public String generateToken(LoginUser user, PrivateKey privateKey) {
//        HashMap<String, Object> claims = new HashMap<>();
//        claims.put("sub", user.getUsername());
//        return generateToken(claims, privateKey);
//    }
//
//    /**
//     * 生成token令牌
//     * @param userDetails 用户
//     * @return token令牌
//     */
//    public String generateToken(UserDetails userDetails, PrivateKey privateKey) {
//            HashMap<String, Object> claims = new HashMap<>();
//        claims.put("sub", userDetails.getUsername());
//        return generateToken(claims, privateKey);
//    }
//
//    /**
//     * 从令牌中获取用户名
//     * @param token 令牌
//     * @return 用户名
//     */
//    public String getUsernameFromToken(String token, PublicKey publicKey) {
//            String username;
//        try {
//            Claims claims = getClaimsFromToken(token, publicKey);
//            username = claims.getSubject();
//        } catch (Exception e) {
//            username =null;
//        }
//        return username;
//    }
//
//    /**
//     * 判断令牌是否过期
//     * @param token 令牌
//     * @return 是否过期
//     */
//    public Boolean isTokenExpired(String token, PublicKey publicKey) {
//        try {
//            Claims claims = getClaimsFromToken(token, publicKey);
//            Date expiration = claims.getExpiration();
//            return expiration.before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * 刷新令牌
//     * @param token 原令牌
//     * @return 新令牌
//     */
//    public String refreshToken(String token, PublicKey publicKey, PrivateKey privateKey) {
//        String refreshedToken;
//        try {
//            Claims claims = getClaimsFromToken(token, publicKey);
//            refreshedToken = generateToken(claims, privateKey);
//        } catch (Exception e) {
//            refreshedToken = null;
//        }
//        return refreshedToken;
//    }
//
//    /**
//     * 验证令牌
//     * @param token         令牌
//     * @param userDetails   用户
//     * @return 是否有效
//     */
//    public Boolean validateToken(String token, UserDetails userDetails, PublicKey publicKey) {
//        String username = getUsernameFromToken(token, publicKey);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token, publicKey));
//    }
//
//    /**
//     * 生成令牌
//     * @param claims 数据声明
//     * @return token令牌
//     */
//    private String generateToken(Map<String, Object> claims, PrivateKey privateKey) {
//            Date date = new Date(System.currentTimeMillis());
//        return Jwts.builder().setClaims(claims)
//                .setId(createJTI())
//                .setIssuedAt(date)
//                .setExpiration(new Date(date.getTime() + expiration))
//                .signWith(SignatureAlgorithm.RS256, privateKey)
//                .compact();
//    }
//
//    /**
//     * 获取数据声明
//     * @param token 令牌
//     * @return 数据声明
//     */
//    private Claims getClaimsFromToken(String token, PublicKey publicKey) {
//        Claims claims;
//        try {
//            claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getBody();
//        } catch (Exception e) {
//            claims = null;
//        }
//        return claims;
//    }
//
//    private static String createJTI() {
//        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
//    }
//}
