package com.posin.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.posin.common.core.web.domain.BaseEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
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
@TableName("blog_menu")
public class AdminMenu {

    @TableId("menu_id")
    private String menuId;
    @TableField("menu_name")
    private String menuName;
    @TableField("parent_id")
    private String parentId;
    @TableField("order_num")
    private Integer orderNum;
    @TableField("path")
    private String path;
    @TableField("is_frame")
    private int isFrame;
    @TableField("menu_type")
    private String menuType;
    @TableField("visible")
    private int visible;
    @TableField("status")
    private Byte status;
    @TableField("perms")
    private String perms;
    @TableField("icon")
    private String icon;
    @TableField("module_id")
    private String moduleId;
    @TableField("en_code")
    private String enCode;
    @TableField("target")
    private String target;
    @TableField("create_by")
    private String createBy;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_by")
    private String updateBy;
    @TableField("update_time")
    private Date updateTime;
    @TableField("remark")
    private String remark;
    @TableField(exist = false)
    private List<AdminMenu> childs;

    @NotBlank(message = "菜单名称不能为空")
    @Size(min = 0, max = 50, message = "菜单名称长度不能超过50个字符")
    public String getMenuName()
    {
        return menuName;
    }

    @NotNull(message = "显示顺序不能为空")
    public Integer getOrderNum()
    {
        return orderNum;
    }

    @Size(min = 0, max = 200, message = "路由地址不能超过200个字符")
    public String getPath()
    {
        return path;
    }

    @NotBlank(message = "菜单类型不能为空")
    public String getMenuType()
    {
        return menuType;
    }

    @Size(min = 0, max = 100, message = "权限标识长度不能超过100个字符")
    public String getPerms()
    {
        return perms;
    }
}
