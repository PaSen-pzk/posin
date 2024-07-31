package com.posin.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.posin.common.core.utils.StringUtils;
import com.posin.manage.dao.ArticleSimpleMapper;
import com.posin.manage.model.ArticleSimple;
import com.posin.manage.service.IArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zkP
 * @date 2024/5/29 20:12
 * @func
 * @description
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleSimpleMapper, ArticleSimple> implements IArticleService {

    @Override
    public List<ArticleSimple> list(ArticleSimple articleSimple) {
        QueryWrapper queryWrapper = new QueryWrapper<ArticleSimple>();
        if(StringUtils.isNotEmpty(articleSimple.getTitle()))
            queryWrapper.like("title", articleSimple.getTitle());
        if(articleSimple.getIfFlag() != null)
            queryWrapper.eq("if_flag", articleSimple.getIfFlag());
        if(articleSimple.getIfPublic() != null)
            queryWrapper.eq("if_public", articleSimple.getIfPublic());
        queryWrapper.orderByDesc("update_time");
        queryWrapper.eq("is_deleted", 0);
        return list(queryWrapper);
    }
}
