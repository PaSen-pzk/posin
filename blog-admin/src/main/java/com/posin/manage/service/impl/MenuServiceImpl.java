package com.posin.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.posin.blog.entity.AdminMenu;
import com.posin.common.core.utils.StringUtils;
import com.posin.manage.dao.AdminMenuMapper;
import com.posin.manage.service.IMenuService;
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
}
