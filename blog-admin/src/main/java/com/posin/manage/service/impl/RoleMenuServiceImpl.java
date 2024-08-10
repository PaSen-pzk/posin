package com.posin.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.posin.blog.entity.RoleMenu;
import com.posin.manage.mapper.RoleMenuMapper;
import com.posin.manage.service.IRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * @author zkP
 * @date 2024/8/10 21:25
 * @func
 * @description
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Override
    public int checkMenuExistRole(String menuId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("menu_id", menuId);
        return baseMapper.selectCount(queryWrapper);
    }
}
