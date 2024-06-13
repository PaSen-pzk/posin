package com.posin.manage.service;

import com.posin.blog.pojo.AdminUser;
import com.posin.manage.vo.UserVo;

/**
 * @author zkP
 * @date 2024/2/20 20:40
 * @func
 * @description
 */
public interface ISysUserService {

    UserVo login(AdminUser adminUser);

    void loginOut();
}
