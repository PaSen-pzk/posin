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
    List<AdminMenu> getList(String role);

    List<AdminMenu> getListAll(String role);
}
