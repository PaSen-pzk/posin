package com.posin.manage.mapper;

import com.posin.blog.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zkP
 * @date 2024/2/19 22:58
 * @func
 * @description
 */
@Repository
public interface SysUserMapper {

    @Select("SELECT * from blog_user where user_name=#{username}")
    AdminUser queryByUserName(@Param("username") String username);

    @Select("SELECT user_id id, user_name username, password, status FROM blog_user WHERE is_deleted = 0 and user_name = #{name}")
    AdminUser selectByName(@Param("name") String name);
}
