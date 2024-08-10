package com.posin.manage.controller;

import com.posin.blog.security.model.LoginUser;
import com.posin.blog.security.util.SecurityUtils;
import com.posin.blog.vo.StdResultVo;
import com.posin.blog.entity.AdminMenu;
import com.posin.common.core.constant.UserConstants;
import com.posin.common.core.context.SecurityContextHolder;
import com.posin.common.core.utils.StringUtils;
import com.posin.manage.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据菜单编号获取详细信息
     */
    @GetMapping(value = "/{menuId}")
    public StdResultVo<AdminMenu> getInfo(@PathVariable String menuId){
        StdResultVo<AdminMenu> response = new StdResultVo();
        AdminMenu menu = menuService.selectMenuById(menuId);
        response.setData(menu);
        return response;
    }

    /**
     * 新增菜单
     */
    @PreAuthorize("hasAnyAuthority('system:menu:add')")
    @PostMapping
    public StdResultVo<?> add(@Validated @RequestBody AdminMenu menu)
    {
        if (!menuService.checkMenuNameUnique(menu))
        {
            return StdResultVo.error("新增菜单'" + menu.getMenuName() + "'失败，菜单名称已存在");
        }
        else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.ishttp(menu.getPath()))
        {
            return StdResultVo.error("新增菜单'" + menu.getMenuName() + "'失败，地址必须以http(s)://开头");
        }
        menu.setCreateBy(SecurityUtils.getUsername());
        return StdResultVo.success(menuService.insertMenu(menu));
    }

    /**
     * 删除菜单
     */
    @PreAuthorize("hasAnyAuthority('system:menu:remove')")
    @DeleteMapping("/{menuId}")
    public StdResultVo<?> remove(@PathVariable("menuId") String menuId)
    {
        if (menuService.hasChildByMenuId(menuId))
        {
            return StdResultVo.error("存在子菜单,不允许删除");
        }
        if (menuService.checkMenuExistRole(menuId))
        {
            return StdResultVo.error("菜单已分配,不允许删除");
        }
        return StdResultVo.success(menuService.deleteMenuById(menuId));
    }

}
