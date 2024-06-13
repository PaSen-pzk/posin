package com.posin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zkP
 * @date 2024/1/30 23:06
 * @func 门户装修-导航管理
 * @description
 */
@Controller
@RequestMapping("/article/manage")
public class ArticleManageController {

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("article/manage");
    }

    @GetMapping("/edit")
    public ModelAndView edit() {
        return new ModelAndView("article/editor");
    }
}
