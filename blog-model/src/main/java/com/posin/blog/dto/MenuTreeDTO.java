package com.posin.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zkP
 * @date 2024/1/31 23:29
 * @func
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTreeDTO {

    private String id;
    private String label;
    private String parentId;
    private Integer orderNum;
    private List<MenuTreeDTO> children;
    private String moduleId;
    private String path;
    private String type;
    private Integer ifFrame;
    private Integer visible;
    private Integer status;
    private String perms;
    private String enCode;
    private String icon;
    private String target;

}
