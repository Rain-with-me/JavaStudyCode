package com.lu.edu.config.security;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


import com.lu.edu.config.security.common.Consts;
import com.lu.edu.config.security.common.Status;
import com.lu.edu.config.security.domain.vo.UserPrincipal;
import com.lu.edu.dao.entity.Permission;
import com.lu.edu.dao.entity.Role;
import com.lu.edu.dao.entity.RolePermission;
import com.lu.edu.dao.entity.User;
import com.lu.edu.mapper.PermissionMapper;
import com.lu.edu.mapper.RoleMapper;
import com.lu.edu.mapper.RolePermissionMapper;
import com.lu.edu.mapper.UserMapper;

import com.lu.edu.utils.ResponseUtil;
import com.lu.edu.utils.exception.DiyException;
import com.lu.edu.utils.exception.SecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 动态路由认证
 * </p>
 *
 */
@Service
public class RbacAuthorityService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private RequestMappingHandlerMapping mapping;

    /**
     * @Description: 判断是否有权限
     * @Author: 雨同我
     * @DateTime: 2023/8/15 17:03
     * @param: null:
     * @return:
    */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
//        1.判断请求是否合法
//        2.判断用户是否含有权限 【构造请求AntPathRequestMatcher和request进行判断】

        checkRequest(request);

//        TODO 里面查表的优化
        Object principal = authentication.getPrincipal();
        boolean permissionFlog=false;
        if (principal instanceof UserDetails){
            UserPrincipal userPrincipal = (UserPrincipal) principal;


            //获取资源，前后端分离，所以过滤页面权限，只保留按钮权限
            List<Permission> btnPerms = userPrincipal.getPermissions().stream()
                    // 过滤页面权限
                    .filter(permission -> Objects.equals(permission.getType(), Consts.BUTTON))
                    // 过滤 URL 为空
                    .filter(permission -> StrUtil.isNotBlank(permission.getUrl()))
                    // 过滤 METHOD 为空
                    .filter(permission -> StrUtil.isNotBlank(permission.getMethod()))
                    .collect(Collectors.toList());

            for (Permission btnPerm : btnPerms) {
                AntPathRequestMatcher antPathMatcher = new AntPathRequestMatcher(btnPerm.getUrl(), btnPerm.getMethod());
                if (antPathMatcher.matches(request)) {
                    permissionFlog = true;
                    break;
                }
            }
            return permissionFlog;
        }else {
            return false;
        }
    }

    /**
     * 校验请求是否存在
     *
     * 所有请求url/user/select_user GET
     * 所有请求url/user/select_user POST
     *
     * @param request 请求
     */
    private void checkRequest(HttpServletRequest request) {
        // 获取当前 request 的方法
        String currentMethod = request.getMethod();
        Multimap<String, String> urlMapping = allUrlMapping();


        for (String uri : urlMapping.keySet()) {
            // 通过 AntPathRequestMatcher 匹配 url
            // 可以通过 2 种方式创建 AntPathRequestMatcher
            // 1：new AntPathRequestMatcher(uri,method) 这种方式可以直接判断方法是否匹配，因为这里我们把 方法不匹配 自定义抛出，所以，我们使用第2种方式创建
            // 2：new AntPathRequestMatcher(uri) 这种方式不校验请求方法，只校验请求路径
            AntPathRequestMatcher antPathMatcher = new AntPathRequestMatcher(uri);
            if (antPathMatcher.matches(request)) {
                if (!urlMapping.get(uri).contains(currentMethod)) {
                    throw new SecurityException(Status.HTTP_BAD_METHOD);
                } else {
                    return;
                }
            }
        }
        throw new SecurityException(Status.REQUEST_NOT_FOUND);
    }

    /**
     * 获取 所有URL Mapping，返回格式为{"/test":["GET","POST"],"/sys":["GET","DELETE"]}
     *
     * @return {@link ArrayListMultimap} 格式的 URL Mapping
     */
    private Multimap<String, String> allUrlMapping() {
        Multimap<String, String> urlMapping = ArrayListMultimap.create();

        // 获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();

        handlerMethods.forEach((k, v) -> {
            // 获取当前 key 下的获取所有URL
            Set<String> url = k.getPatternsCondition().getPatterns();
            RequestMethodsRequestCondition method = k.getMethodsCondition();

            // 为每个URL添加所有的请求方法
            url.forEach(s -> urlMapping.putAll(s, method.getMethods().stream().map(Enum::toString).collect(Collectors.toList())));
        });

        return urlMapping;
    }
}
