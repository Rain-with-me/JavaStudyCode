package com.lu.edu.controller;


import com.lu.edu.config.security.common.Status;
import com.lu.edu.dao.entity.User;
import com.lu.edu.mapper.UserMapper;
import com.lu.edu.utils.exception.DiyException;
import com.lu.edu.utils.exception.SecurityException;
import com.lu.edu.utils.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-08-15
 */
@RestController
@RequestMapping("/user")
public class RoleController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/select_user")
    public CommonResult selectAllUser() {
        List<User> users = userMapper.selectList(null);
        return CommonResult.success(users);
    }
    @GetMapping("/select_user")
    public CommonResult selectAllUsers() {
        List<User> users = userMapper.selectList(null);
        return CommonResult.success(users);
    }

    @GetMapping("/t")
    public CommonResult t() {
        throw new SecurityException(Status.UNAUTHORIZED);
    }

    /** 
     * @Description: 里面包含一个前缀，可以参考源码
     * @Author: 雨同我
     * @DateTime: 2023/8/18 10:22
     * @param: null: 
     * @return: 
    */
    @PostMapping("/test_role")
    @PreAuthorize("hasRole('btn_admin')")
    public CommonResult test_role() {
        return CommonResult.success("okok====>role");
    }

    @PostMapping("/test_authority")
    @PreAuthorize("hasAuthority('admin')")
    public CommonResult test_authority() {
        return CommonResult.success("okok====>authority");
    }
}

