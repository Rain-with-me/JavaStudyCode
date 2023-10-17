package com.lu.edu.controller;


import com.lu.edu.config.security.common.Status;
import com.lu.edu.config.security.jwt.JwtUtil;
import com.lu.edu.dao.dto.LoginRequest;
import com.lu.edu.dao.entity.User;
import com.lu.edu.mapper.UserMapper;
import com.lu.edu.utils.exception.DiyException;
import com.lu.edu.utils.exception.SecurityException;
import com.lu.edu.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-08-15
 */
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     */
    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmailOrPhone(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.createJWT(authentication, loginRequest.getRememberMe());
        return CommonResult.success(jwt);
    }

    @PostMapping("/logout")
    public CommonResult logout(HttpServletRequest request) {
        try {
            // 设置JWT过期
            jwtUtil.invalidateJWT(request);
        } catch (SecurityException e) {
            throw new SecurityException(Status.UNAUTHORIZED);
        }
        return CommonResult.success(Status.LOGOUT);
    }
}

