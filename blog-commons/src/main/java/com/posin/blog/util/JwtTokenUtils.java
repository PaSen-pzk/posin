//package com.posin.blog.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.posin.blog.model.Payload;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.time.LocalDateTime;
//import java.util.Base64;
//import java.util.UUID;
//
///**
// * @author zkP
// * @date 2024/2/19 22:40
// * @func
// * @description
// */
//public class JwtTokenUtils {
//
//    private static final String JWT_PAYLOAD_USER_KEY = "user";
//
//    /**
//     * 私钥加密token
//     *
//     * @param userInfo   载荷中的数据
//     * @param privateKey 私钥
//     * @param expire     过期时间，单位分钟
//     * @return JWT
//     */
//    public static String generateTokenExpireInMinutes(Object userInfo, PrivateKey privateKey,
//                                                      int expire) {
//        return Jwts.builder()
//                .claim(JWT_PAYLOAD_USER_KEY, JSON.toJSONString(userInfo))
//                .setId(createJTI())
//                .setExpiration(DateUtils.asDate(LocalDateTime.now().plusMinutes(expire)))
//                .signWith(SignatureAlgorithm.RS256, privateKey)
//                .compact();
//
//    }
//
//    /**
//     * 私钥加密token
//     *
//     * @param userInfo   载荷中的数据
//     * @param privateKey 私钥
//     * @param expire     过期时间，单位秒
//     * @return JWT
//     */
//    public static String generateTokenExpireInSeconds(Object userInfo, PrivateKey privateKey,
//                                                      int expire) {
//        return Jwts.builder()
//                .claim(JWT_PAYLOAD_USER_KEY, JSON.toJSONString(userInfo))
//                .setId(createJTI())
//                .setExpiration(DateUtils.asDate(LocalDateTime.now().plusSeconds(expire)))
//                .signWith(SignatureAlgorithm.RS256, privateKey)
//                .compact();
//    }
//
//    /**
//     * 公钥解析token
//     *
//     * @param token     用户请求中的token
//     * @param publicKey 公钥
//     * @return Jws<Claims>
//     */
//    private static Jws<Claims> parserToken(String token, PublicKey publicKey) {
//        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
//    }
//
//    private static String createJTI() {
//        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
//    }
//
//    /**
//     * 获取token中的用户信息
//     *
//     * @param token     用户请求中的令牌
//     * @param publicKey 公钥
//     * @return 用户信息
//     */
//    public static <T> Payload<T> getInfoFromToken(String token, PublicKey publicKey, Class<T>
//            userType) {
//        Jws<Claims> claimsJws = parserToken(token, publicKey);
//        Claims body = claimsJws.getBody();
//        Payload<T> claims = new Payload<>();
//        claims.setId(body.getId());
//        claims.setUserInfo(JSONObject.parseObject(body.get(JWT_PAYLOAD_USER_KEY).toString(), userType));
//        claims.setExpiration(body.getExpiration());
//        return claims;
//    }
//
//    /**
//     * 获取token中的载荷信息
//     *
//     * @param token     用户请求中的令牌
//     * @param publicKey 公钥
//     * @return 用户信息
//     */
//    public static <T> Payload<T> getInfoFromToken(String token, PublicKey publicKey) {
//        Jws<Claims> claimsJws = parserToken(token, publicKey);
//        Claims body = claimsJws.getBody();
//        Payload<T> claims = new Payload<>();
//        claims.setId(body.getId());
//        claims.setExpiration(body.getExpiration());
//        return claims;
//    }
//
//}
//
