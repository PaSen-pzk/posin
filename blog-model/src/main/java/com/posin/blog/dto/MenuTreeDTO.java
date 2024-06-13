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
    private List<MenuTreeDTO> children;
    private String moduleId;
    private String parentId;
    private String enCode;
    private String icon;
    private String urlAddress;
    private String target;
    private Integer role;
    private Integer status;
}
