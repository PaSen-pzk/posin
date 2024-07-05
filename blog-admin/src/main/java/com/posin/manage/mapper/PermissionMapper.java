package com.posin.manage.mapper;

import org.springframework.stereotype.Repository;

import java.security.Permission;
import java.util.List;

/**
 * @author zkP
 * @date 2024/7/5 20:33
 * @func
 * @description
 */
@Repository
public interface PermissionMapper {
    List<Permission> findAll();

}
