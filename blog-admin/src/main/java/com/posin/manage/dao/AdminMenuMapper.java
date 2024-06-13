package com.posin.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.posin.blog.entity.AdminMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zkP
 * @date 2024/1/23 21:00
 * @func
 * @description
 */
@Mapper
public interface AdminMenuMapper extends BaseMapper<AdminMenu> {

    List<AdminMenu> querySubMenuList(@Param("parentId")String parentId);

    List<AdminMenu> queryMenuTree(@Param("role")String role);

    List<AdminMenu> queryCompleteMenuTree(@Param("role")String role);

    List<String> getAuthority(@Param("uid")String uid);
}
