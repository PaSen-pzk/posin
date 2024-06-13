package com.posin.blog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.UUID;

/**
 * @author zkP
 * @date 2024/5/29 20:36
 * @func
 * @description
 */
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "uuid", String.class, UUID.randomUUID().toString().replace("-", ""));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 根据需要实现
    }
}
