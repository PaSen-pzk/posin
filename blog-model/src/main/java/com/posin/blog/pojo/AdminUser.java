package com.posin.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("blog_user")
public class AdminUser {

    @TableId("user_id")
    private String id;
    @TableField("user_name")
    private String username;
    @TableField("nick_name")
    private String nickName;
    @TableField("user_type")
    private String userType;
    @TableField("email")
    private String email;
    @TableField("mobile")
    private String mobile;
    @TableField("gender")
    private Byte gender;
    @TableField("avatar")
    private String avatar;
    @TableField("password")
    private String password;
    @TableField("status")
    private Integer status;
    @TableField("remark")
    private String remark;

}
