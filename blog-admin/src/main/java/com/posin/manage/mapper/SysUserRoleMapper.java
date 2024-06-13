package com.posin.manage.mapper;

import com.posin.blog.pojo.UserRolePOJO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zkP
 * @date 2024/4/2 23:21
 * @func
 * @description
 */
@Repository
public interface SysUserRoleMapper {
    @Select("SELECT * FROM blog_user_role WHERE user_id = #{userId}")
    List<UserRolePOJO> listByUserId(Integer userId);
}
