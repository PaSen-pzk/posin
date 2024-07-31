package com.posin.manage.controller;

import com.posin.blog.security.model.LoginUser;
import com.posin.blog.security.util.SecurityUtils;
import com.posin.blog.vo.StdResultVo;
import com.posin.blog.entity.AdminMenu;
import com.posin.common.core.context.SecurityContextHolder;
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
     * 获取菜单列表
     */
    @PreAuthorize("hasAnyAuthority('system:menu:list')")
    @GetMapping("/list")
    public StdResultVo<List<AdminMenu>> list(AdminMenu menu)
    {
        Long userId = SecurityUtils.getUserId();
        List<AdminMenu> menus = menuService.selectMenuList(menu, userId);
        return StdResultVo.success(menus);
    }

    /**
     * 登录人权限内菜单列表
     * @return
     */
    @PreAuthorize("hasAnyAuthority('system:menu:list')")
    @GetMapping("/getRouters")
    public StdResultVo<List<AdminMenu>> getList() {
        StdResultVo<List<AdminMenu>> response = new StdResultVo();
        LoginUser loginUser = SecurityUtils.getLoginUser();
        List<AdminMenu> menuList = menuService.getList(loginUser.getAdminUser().getId());
        response.setData(menuList);
        return response;
    }

    /**
     * 获取菜单下拉树列表
     */
    @GetMapping("/treeselect")
    public StdResultVo<List<AdminMenu>> treeselect(AdminMenu menu) {
        StdResultVo<List<AdminMenu>> response = new StdResultVo();
        LoginUser loginUser = SecurityUtils.getLoginUser();
        String userId = loginUser.getAdminUser().getId();
        List<AdminMenu> menuList = menuService.getListAll(menu, userId);
        response.setData(menuList);
        return response;
    }



}
