package com.posin.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zkP
 * @date 2024/2/20 20:47
 * @func
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUser {
    private String id;
    private String username;
    private String password;
    private Integer status;
}
