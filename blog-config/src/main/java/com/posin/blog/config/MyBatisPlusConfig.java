//package com.posin.blog.config;
//
//import com.baomidou.mybatisplus.core.config.GlobalConfig;
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import com.posin.blog.handler.DefaultMetaObjectHandler;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author zkP
// * @date 2024/5/29 20:38
// * @func
// * @description
// */
//@Configuration
//public class MyBatisPlusConfig {
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
//        //忽略代码....
//        factoryBean.setGlobalConfig(globalConfig());
//        return factoryBean.getObject();
//    }
//
//    @Bean
//    public GlobalConfig globalConfig() {
//        GlobalConfig globalConfig = new GlobalConfig();
//        globalConfig.setMetaObjectHandler(new DefaultMetaObjectHandler());
//        return globalConfig;
//    }
//}
