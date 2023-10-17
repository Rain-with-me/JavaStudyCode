package com.lu.edu.config.security.domain;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lu.edu.config.security.domain.vo.UserPrincipal;
import com.lu.edu.dao.entity.*;
import com.lu.edu.mapper.PermissionMapper;
import com.lu.edu.mapper.RoleMapper;
import com.lu.edu.mapper.RolePermissionMapper;
import com.lu.edu.mapper.UserMapper;
import com.lu.edu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 自定义UserDetails查询
 * </p>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        List<RolePermission> roles = rolePermissionMapper.selectList(new LambdaQueryWrapper<RolePermission>().eq(RolePermission::getRoleId, user.getRoleId()));
        List<Long> collect = roles.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        List<Permission> permissions = permissionMapper.selectBatchIds(collect);
        List<Role> list = new LinkedList<Role>(){{
//            Role role = new Role();
//            role.setName("ADMIN");
//            add(role);
        }};
        return UserPrincipal.create(user,list,permissions);
    }
}
