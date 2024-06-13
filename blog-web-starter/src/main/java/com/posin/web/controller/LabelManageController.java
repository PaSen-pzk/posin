package com.posin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zkP
 * @date 2024/2/19 20:19
 * @func
 * @description
 */
@Controller
@RequestMapping("/sys/manage/label")
public class LabelManageController {

    @GetMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("sys/labelManage");
    }
}
