package com.posin.manage.mapper;

import com.posin.blog.pojo.RolePOJO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zkP
 * @date 2024/4/2 23:20
 * @func
 * @description
 */
@Repository
public interface SysRoleMapper {
    @Select("SELECT * FROM blog_role WHERE id = #{id}")
    RolePOJO selectById(Integer id);
}
