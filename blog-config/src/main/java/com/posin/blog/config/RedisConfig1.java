//package com.posin.blog.config;
//
//import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Scope;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.StringRedisConnection;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//
//@SuppressWarnings("ALL")
//@Component
//public class RedisConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.redis.lettuce.pool")
//    @Scope(value = "prototype")
//    public GenericObjectPoolConfig redisPool() {
//        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
//        return genericObjectPoolConfig;
//    }
//
//    @Bean("stringRedisTemplate")
//    public StringRedisTemplate stringRedisTemplate() {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());
//        stringRedisTemplate.setValueSerializer(new StringRedisSerializer());
//        stringRedisTemplate.setConnectionFactory(new LettuceConnectionFactory());
//        return stringRedisTemplate;
//    }
//
//    @Bean
//    @Primary
//    public LettuceConnectionFactory stringRedisTemplateFactory() {
//        GenericObjectPoolConfig config = redisPool();
//        LettucePoolingClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder()
//                .poolConfig(config)
//                .commandTimeout(Duration.ofMillis(config.getMaxWaitDuration().toMillis()))
//                .build();
//        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(), clientConfiguration);
//    }
//}
