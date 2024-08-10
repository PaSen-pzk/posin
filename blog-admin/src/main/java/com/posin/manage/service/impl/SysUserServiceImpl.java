package com.posin.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.posin.blog.cache.RedisCache;
import com.posin.blog.pojo.AdminUser;
import com.posin.blog.security.model.LoginUser;
import com.posin.manage.mapper.SysUserMapper;
import com.posin.manage.service.IMenuService;
import com.posin.manage.service.ISysUserService;
import com.posin.blog.util.JwtUtils;
import com.posin.manage.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author zkP
 * @date 2024/2/20 20:43
 * @func
 * @description
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, AdminUser> implements ISysUserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private IMenuService menuService;

    @Override
    public UserVo login(AdminUser user) {
        // 获取AuthenticationManager 进行用户认证
        // 1.将用户登录的用户名、密码 封装成一个authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        // 2.authenticationManager来进行认证,
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // 判断认证结果
        // 1.如果认证不通过则抛出异常；
        if(Objects.isNull(authentication)){
            throw new RuntimeException("登录失败");
        }
        // 2.如果认证通过 利用userid生成应该jwt
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userid = loginUser.getAdminUser().getId();
        String jwt = JwtUtils.createJWT(userid);

        // 把完整的用户信息存入redis中
        redisCache.setCacheObject("bloglogin:"+userid,loginUser);

        UserVo userVo = new UserVo(jwt, loginUser);
        return userVo;
    }

    @Override
    public void loginOut() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser principal = (LoginUser) authentication.getPrincipal();
        redisCache.deleteObject("bloglogin:" + principal.getAdminUser().getId());
    }

    @Override
    public LoginUser getLoginUserInfo(String userId) {
        AdminUser adminUser = baseMapper.selectById(userId);
        // 判断用户是否存在
        if(userId == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 添加权限
        List<String> authorities = menuService.getAuthority(adminUser.getId());
        // 返回UserDetails实现类
        return new LoginUser(adminUser, authorities);
    }
}
