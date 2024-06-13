package com.posin.manage.vo;

import com.posin.blog.security.model.LoginUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zkP
 * @date 2024/2/20 20:41
 * @func
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

    private String token;
    private LoginUser userInfo;
}
