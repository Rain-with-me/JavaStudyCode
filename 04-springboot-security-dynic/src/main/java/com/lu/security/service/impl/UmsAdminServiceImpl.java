package com.lu.security.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lu.security.common.error.GuliException;
import com.lu.security.common.utils.JwtTokenUtil;
import com.lu.security.config.security.AdminUserDetails;
import com.lu.security.entity.UmsAdmin;
import com.lu.security.entity.UmsPermission;
import com.lu.security.entity.UmsResource;
import com.lu.security.entity.UmsRole;
import com.lu.security.mapper.UmsAdminMapper;
import com.lu.security.mapper.UmsAdminRoleRelationMapper;
import com.lu.security.mapper.UmsPermissionMapper;
import com.lu.security.service.UmsAdminRoleRelationService;
import com.lu.security.service.UmsAdminService;
import com.lu.security.service.UmsResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-17
 */
@Service
@Slf4j
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;
    @Autowired
    private UmsResourceService umsResourceService;
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
    public UmsAdmin getAdminUsername(String username) {
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
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new GuliException(500,"密码错误");
            }
            if(!userDetails.isEnabled()){
                throw new GuliException(403,"用户被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);

        } catch (AuthenticationException e) {
            log.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        String username = umsAdminParam.getUsername();
        UmsAdmin adminByUsername = getAdminUsername(username);
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

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        UmsAdmin admin = getAdminUsername(username);
        if (admin != null) {
            List<UmsResource> resourceList = umsResourceService.getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

//    TODO
    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return umsAdminRoleRelationMapper.getRoleList(adminId);
    }
}
