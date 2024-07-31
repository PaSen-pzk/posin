package com.posin.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zkP
 * @date 2024/7/31 20:40
 * @func
 * @description 常用组件
 */
@Controller
@RequestMapping("components/frame")
public class FrameComponentController {

    @GetMapping("buttons")
    public ModelAndView buttons() {
        return new ModelAndView("/components/frame/ui-buttons");
    }

    @GetMapping("progress")
    public ModelAndView progress() {
        return new ModelAndView("/components/frame/ui-sliders-progress");
    }

    @GetMapping("modals")
    public ModelAndView modals() {
        return new ModelAndView("/components/frame/ui-modals-popus");
    }

    @GetMapping("accordions")
    public ModelAndView accordions() {
        return new ModelAndView("/components/frame/ui-tabs-accordions");
    }

    @GetMapping("alerts")
    public ModelAndView alerts() {
        return new ModelAndView("/components/frame/ui-alerts-notifications");
    }

    @GetMapping("lists")
    public ModelAndView lists() {
        return new ModelAndView("/components/frame/ui-nestable-lists");
    }

    @GetMapping("panels")
    public ModelAndView panels() {
        return new ModelAndView("/components/frame/ui-panels");
    }

    @GetMapping("icons")
    public ModelAndView icons() {
        return new ModelAndView("/components/frame/ui-icons");
    }

    @GetMapping("typography")
    public ModelAndView typography() {
        return new ModelAndView("/components/frame/ui-typography");
    }
}
