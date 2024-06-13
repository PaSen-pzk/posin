//package com.posin.manage.utils;
//
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//
///**
// * @author zkP
// * @date 2024/2/19 22:18
// * @func RSA工具封装类
// * @description
// */
//@Data
//@Component
//@ConfigurationProperties(prefix = "rsa.key")
//public class RSAKeyProperties {
//
//    private String publicKeyFile;
//    private String privateKeyFile;
//
//    private PublicKey publicKey;
//    private PrivateKey privateKey;
//    private String secret;
//
//    @PostConstruct
//    public void createRSAKey() throws Exception {
//        RSAUtils.generateKey(publicKeyFile, privateKeyFile, secret, 0);
//        this.publicKey = RSAUtils.getPublicKey(publicKeyFile);
//        this.privateKey = RSAUtils.getPrivateKey(privateKeyFile);
//    }
//}
