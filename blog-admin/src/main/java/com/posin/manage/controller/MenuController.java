package com.posin.manage.controller;

import com.posin.blog.vo.StdResultVo;
import com.posin.blog.entity.AdminMenu;
import com.posin.manage.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zkP
 * @date 2024/1/22 23:09
 * @func 后台管理系统菜单服务
 * @description
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    /**
     * 菜单列表
     * @return
     */
    @PreAuthorize("hasAnyAuthority('menu:admin')")
    @GetMapping("/list/{role}")
    public StdResultVo<List<AdminMenu>> getList(@PathVariable("role") String role) {
        StdResultVo<List<AdminMenu>> response = new StdResultVo();
        List<AdminMenu> menuList = menuService.getList(role);
        response.setData(menuList);
        return response;
    }

    /**
     * 菜单列表
     * @return
     */
    @GetMapping("/list/all/{role}")
    public StdResultVo<List<AdminMenu>> getListAll(@PathVariable("role") String role) {
        StdResultVo<List<AdminMenu>> response = new StdResultVo();
        List<AdminMenu> menuList = menuService.getListAll(role);
        response.setData(menuList);
        return response;
    }

}
