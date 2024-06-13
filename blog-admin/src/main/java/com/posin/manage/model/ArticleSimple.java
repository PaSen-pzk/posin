package com.posin.manage.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.annotation.Generated;

/**
 * @author zkP
 * @date 2024/5/29 20:11
 * @func
 * @description
 */
@Data
@TableName("blog_article")
public class ArticleSimple {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField(value = "article_id")
    private String articleId;
    @TableField("title")
    private String title;
    @TableField("content")
    private String content;
    @TableField("label")
    private String label;
    @TableField("link")
    private String link;
    @TableField("is_deleted")
    private Byte isDeleted;
    @TableField("if_flag")
    private Byte ifFlag;
    @TableField("if_public")
    private Byte ifPublic;
}
