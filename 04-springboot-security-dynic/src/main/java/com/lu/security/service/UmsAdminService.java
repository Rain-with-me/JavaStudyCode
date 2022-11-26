package com.lu.security.service;

import com.lu.security.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lu.security.entity.UmsPermission;
import com.lu.security.entity.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-17
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    UmsAdmin getAdminUsername(String username);

    List<UmsPermission> getPermissionList(Long id);

    String login(String username, String password);

    UmsAdmin register(UmsAdmin umsAdminParam);
    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    List<UmsRole> getRoleList(Long adminId);
}
