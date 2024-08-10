package com.posin.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.posin.blog.entity.AdminMenu;

import java.util.List;

/**
 * @author zkP
 * @date 2024/1/23 0:03
 * @func
 * @description
 */
public interface IMenuService extends IService<AdminMenu> {
    List<AdminMenu> getList(String userId);

    List<AdminMenu> getListAll(AdminMenu menu, String userId);

    List<AdminMenu> selectMenuList(AdminMenu menu, Long userId);

    /**
     * 根据菜单ID查询信息
     *
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    AdminMenu selectMenuById(String menuId);

    /**
     * 校验菜单名称是否唯一
     *
     * @param menu 菜单信息
     * @return 结果
     */
    boolean checkMenuNameUnique(AdminMenu menu);

    /**
     * 新增保存菜单信息
     *
     * @param menu 菜单信息
     * @return 结果
     */
     int insertMenu(AdminMenu menu);

    /**
     * 是否存在菜单子节点
     *
     * @param menuId 菜单ID
     * @return 结果 true 存在 false 不存在
     */
    boolean hasChildByMenuId(String menuId);

    /**
     * 查询菜单是否存在角色
     *
     * @param menuId 菜单ID
     * @return 结果 true 存在 false 不存在
     */
    boolean checkMenuExistRole(String menuId);

    /**
     * 删除菜单管理信息
     *
     * @param menuId 菜单ID
     * @return 结果
     */
    int deleteMenuById(String menuId);

    /**
     * 查询权限列表
     * @param id
     * @return
     */
    List<String> getAuthority(String id);
}
