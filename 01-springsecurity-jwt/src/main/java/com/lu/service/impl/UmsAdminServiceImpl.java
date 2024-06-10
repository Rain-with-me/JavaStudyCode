package com.lu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lu.common.utils.JwtTokenUtil;
import com.lu.dao.entity.UmsAdmin;
import com.lu.dao.entity.UmsPermission;
import com.lu.mapper.UmsAdminMapper;
import com.lu.mapper.UmsPermissionMapper;
import com.lu.service.UmsAdminService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.Date;
import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/9/4 16:04
 **/
@Service
@Slf4j
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsPermissionMapper umsPermissionMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UmsAdmin getAdminByUsername(String username) {
        LambdaQueryWrapper<UmsAdmin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UmsAdmin::getUsername,username);
        UmsAdmin umsAdmin = umsAdminMapper.selectOne(wrapper);
        return umsAdmin;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long id) {
        QueryWrapper<UmsPermission> wrapper = new QueryWrapper<UmsPermission>().eq("id", id);
        List<UmsPermission> list = umsPermissionMapper.selectList(wrapper);
        return list;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        System.out.println(userDetails.getUsername()+"==============>"+userDetails.getPassword());
        System.out.println(userDetails.getAuthorities()+"--------");
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        System.out.println("====================>"+authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        token = jwtTokenUtil.generateToken(userDetails);

        return token;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        String username = umsAdminParam.getUsername();
        UmsAdmin adminByUsername = getAdminByUsername(username);
        if (adminByUsername!=null){
            throw new BadCredentialsException("用户名已存在");
        }
        umsAdminParam.setStatus(1);
        umsAdminParam.setCreateTime(new Date());
        umsAdminParam.setLoginTime(new Date());
        umsAdminParam.setPassword(passwordEncoder.encode(umsAdminParam.getPassword()));
        umsAdminMapper.insert(umsAdminParam);
        System.out.println("----------"+umsAdminParam);
        return umsAdminParam;
    }

}
