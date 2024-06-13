package com.posin.blog.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.posin.blog.pojo.AdminUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zkP
 * @date 2024/2/19 22:27
 * @func
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements UserDetails, Serializable {

    private AdminUser adminUser;

    /**
     * 权限集合
     */
    private List<String> authorityList;


    @Override
    public String getPassword() {
        return adminUser.getPassword();
    }

    @Override
    public String getUsername() {
        return adminUser.getUsername();
    }

    /**
     * 账户是否过期
     **/
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 是否禁用
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否过期
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否启用
     */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        authorityList.forEach((authorityStr) -> {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authorityStr);
            grantedAuthorities.add(simpleGrantedAuthority);
        });
        return grantedAuthorities;
    }
}
