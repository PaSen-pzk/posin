package com.posin.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zkP
 * @date 2024/7/31 19:35
 * @func
 * @description 面板控制器
 */
@Controller
@RequestMapping("dashboard")
public class DashboardController {

    @GetMapping("index")
    public ModelAndView index() {
        return new ModelAndView("dashboard");
    }
}
