package com.posin.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.posin.blog.entity.AdminMenu;
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
    public List<AdminMenu> getList(String role) {
        return baseMapper.queryMenuTree(role);
    }

    @Override
    public List<AdminMenu> getListAll(String role) {
        return baseMapper.queryCompleteMenuTree(role);
    }
}
