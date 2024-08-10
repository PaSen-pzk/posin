package com.posin.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author zkP
 * @date 2024/8/10 21:16
 * @func
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TableName("blog_role_menu")
public class RoleMenu {

    @TableField("role_id")
    private Long roleId;
    @TableField("menu_id")
    private String menuId;
}
