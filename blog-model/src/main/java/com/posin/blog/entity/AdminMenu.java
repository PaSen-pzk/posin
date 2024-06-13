package com.posin.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author zkP
 * @date 2024/1/23 0:00
 * @func
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TableName("blog_admin_menu")
public class AdminMenu implements Serializable {

    @TableId("id")
    private String id;
    @TableField("module_id")
    private String moduleId;
    @TableField("parent_id")
    private String parentId;
    @TableField("en_code")
    private String enCode;
    @TableField("full_name")
    private String fullName;
    @TableField("icon")
    private String icon;
    @TableField("url_address")
    private String urlAddress;
    @TableField("target")
    private String target;
    @TableField("role")
    private Integer role;

    private List<AdminMenu> childs;
}
