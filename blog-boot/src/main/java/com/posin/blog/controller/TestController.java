package com.posin.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zkP
 * @date 2023/12/19 21:45
 * @func
 * @description
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, posin!";
    }
}
