package com.posin.manage.security.service;

import com.posin.blog.pojo.AdminUser;
import com.posin.blog.security.model.LoginUser;
import com.posin.manage.dao.AdminMenuMapper;
import com.posin.manage.mapper.SysRoleMapper;
import com.posin.manage.mapper.SysUserMapper;
import com.posin.manage.mapper.SysUserRoleMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkP
 * @date 2024/2/19 22:34
 * @func
 * @description
 */
@Service
public class SysUserInfoService implements UserDetailsService {

    private final SysUserMapper sysUserMapper;
    private final SysRoleMapper sysRoleMapper;
    private final SysUserRoleMapper sysUserRoleMapper;
    private final AdminMenuMapper menuMapper;

    public SysUserInfoService(SysUserMapper sysUserMapper, SysRoleMapper sysRoleMapper,
                              SysUserRoleMapper sysUserRoleMapper, AdminMenuMapper menuMapper) {
        this.sysUserMapper = sysUserMapper;
        this.sysRoleMapper = sysRoleMapper;
        this.sysUserRoleMapper = sysUserRoleMapper;
        this.menuMapper = menuMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中取出用户信息
        AdminUser user = sysUserMapper.selectByName(username);
        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        List<String> authorities = menuMapper.getAuthority(user.getId());
        // 返回UserDetails实现类
        return new LoginUser(user, authorities);
    }
}
