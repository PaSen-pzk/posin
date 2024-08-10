package com.posin.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.posin.blog.entity.AdminMenu;
import com.posin.common.core.constant.UserConstants;
import com.posin.common.core.utils.StringUtils;
import com.posin.manage.mapper.AdminMenuMapper;
import com.posin.manage.service.IMenuService;
import com.posin.manage.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkP
 * @date 2024/1/23 0:04
 * @func
 * @description
 */
@Service
public class MenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenu> implements IMenuService {

    @Autowired
    private IRoleMenuService roleMenuService;

    @Override
    public List<AdminMenu> getList(String userId) {
        return baseMapper.queryMenuTree(userId);
    }

    @Override
    public List<AdminMenu> getListAll(AdminMenu menu, String userId) {
        return baseMapper.queryCompleteMenuTree(menu);
    }

    @Override
    public List<AdminMenu> selectMenuList(AdminMenu menu, Long userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(StringUtils.isNotEmpty(menu.getMenuName()))
            queryWrapper.like("menu_name", menu.getMenuName());
        if(menu.getStatus() != null)
            queryWrapper.eq("status", menu.getStatus());
        queryWrapper.orderByAsc("order_num");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public AdminMenu selectMenuById(String menuId) {
        return baseMapper.selectById(menuId);
    }

    @Override
    public boolean checkMenuNameUnique(AdminMenu menu)
    {
        String menuId = StringUtils.isNull(menu.getMenuId()) ? "-1" : menu.getMenuId();
        AdminMenu info = baseMapper.checkMenuNameUnique(menu.getMenuName(), menu.getParentId());
        if (StringUtils.isNotNull(info) && !menuId.equals(info.getMenuId()))
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int insertMenu(AdminMenu menu)
    {
        return baseMapper.insert(menu);
    }

    @Override
    public boolean hasChildByMenuId(String menuId)
    {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", menuId);
        int result = baseMapper.selectCount(queryWrapper);
        return result > 0;
    }

    @Override
    public boolean checkMenuExistRole(String menuId)
    {
        int result = roleMenuService.checkMenuExistRole(menuId);
        return result > 0;
    }

    @Override
    public int deleteMenuById(String menuId)
    {
        return baseMapper.deleteById(menuId);
    }

    @Override
    public List<String> getAuthority(String id) {
        return baseMapper.getAuthority(id);
    }
}
