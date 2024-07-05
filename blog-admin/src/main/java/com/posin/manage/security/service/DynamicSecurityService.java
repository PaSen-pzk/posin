//package com.posin.manage.security.service;
//
//import com.posin.manage.mapper.PermissionMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.stereotype.Service;
//
//import java.security.Permission;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class DynamicSecurityService {
//
//  @Autowired
//  private PermissionMapper permissionMapper;
//
//  // 加载资源ANT通配符和资源对应MAP
//  public Map<String, ConfigAttribute> loadDataSource() {
//    Map<String, ConfigAttribute> urlAndResourceNameMap = new ConcurrentHashMap<>();
//    List<Permission> permissions = permissionMapper.findAll();
//    permissions.forEach(permission -> urlAndResourceNameMap
//        .put(permission.getUrl(), new SecurityConfig(permission.getName())));
//    return urlAndResourceNameMap;
//  }
//}
