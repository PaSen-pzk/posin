package com.posin.blog.controller;

import com.posin.blog.constants.Constants;
import com.posin.blog.pojo.AdminUser;
import com.posin.manage.service.ISysUserService;
import com.posin.blog.vo.ResultVo;
import com.posin.manage.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zkP
 * @date 2024/2/20 20:39
 * @func
 * @description
 */
@RestController
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/login")
    public ResultVo login(@RequestBody AdminUser adminUser) {
        UserVo userVo = sysUserService.login(adminUser);
        return ResultVo.success(userVo);
    }

    @GetMapping("/loginOut")
    public ResultVo loginOut() {
        sysUserService.loginOut();
        return ResultVo.success(Constants.Code.SUCCESS);
    }
}
