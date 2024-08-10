package com.posin.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.posin.blog.entity.RoleMenu;

/**
 * @author zkP
 * @date 2024/8/10 21:19
 * @func
 * @description
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    /**
     * 查询菜单使用数量
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    int checkMenuExistRole(String menuId);
}
