package com.lu.security.config.security;

import com.lu.security.entity.UmsAdmin;
import com.lu.security.entity.UmsPermission;
import com.lu.security.entity.UmsResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/9/17 20:32
 **/

@AllArgsConstructor
public class AdminUserDetails implements UserDetails {
    private UmsAdmin umsAdmin;
    private List<UmsResource> list;

    /**
     * @Description: 取出权限值
     * @Author: 雨同我
     * @DateTime: 2022/9/17 21:39
    */
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//         return list.stream()
//                .filter(permission -> permission.getValue()!=null)
//                .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
//                .collect(Collectors.toList());
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的角色
        return list.stream()
                .map(role ->new SimpleGrantedAuthority(role.getId()+":"+role.getName()))
                .collect(Collectors.toList());
    }


    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
