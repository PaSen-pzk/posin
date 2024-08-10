package com.posin.manage.controller;

import com.posin.blog.pojo.AdminUser;
import com.posin.blog.security.model.LoginUser;
import com.posin.blog.security.util.SecurityUtils;
import com.posin.blog.vo.StdResultVo;
import com.posin.manage.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zkP
 * @date 2024/8/10 22:24
 * @func
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private ISysUserService userService;

    @GetMapping("/getUserInfo")
    public StdResultVo<LoginUser> getUserInfo() {
        String userId = SecurityUtils.getLoginUser().getAdminUser().getId();
        return StdResultVo.success(userService.getLoginUserInfo(userId));
    }
}
