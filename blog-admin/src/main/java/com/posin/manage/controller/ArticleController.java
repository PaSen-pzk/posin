package com.posin.manage.controller;

import com.posin.blog.vo.ResultVo;
import com.posin.blog.vo.StdResultVo;
import com.posin.manage.model.ArticleSimple;
import com.posin.manage.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author zkP
 * @date 2024/5/29 20:09
 * @func
 * @description
 */
@RestController
@RequestMapping("/sys/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping("/save")
    public ResultVo save(@RequestBody ArticleSimple articleSimple) {
        articleSimple.setArticleId(UUID.randomUUID().toString().replace("-",""));
        boolean save = articleService.save(articleSimple);
        return ResultVo.success(save);
    }

}
