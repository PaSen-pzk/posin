package com.posin.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.posin.blog.pojo.AdminUser;
import com.posin.blog.security.model.LoginUser;
import com.posin.manage.vo.UserVo;

/**
 * @author zkP
 * @date 2024/2/20 20:40
 * @func
 * @description
 */
public interface ISysUserService extends IService<AdminUser> {

    UserVo login(AdminUser adminUser);

    void loginOut();

    LoginUser getLoginUserInfo(String userId);
}
