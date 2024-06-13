package com.posin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zkP
 * @date 2024/1/25 23:48
 * @func 系统管理-菜单管理
 * @description
 */
@Controller
@RequestMapping("/sys/manage/menu")
public class MenuManageController {

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("sys/menuManage");
    }
}
