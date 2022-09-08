package com.lu.service;

import com.lu.dao.entity.UmsAdmin;
import com.lu.dao.entity.UmsPermission;

import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/9/4 16:04
 **/
public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);

    List<UmsPermission> getPermissionList(Long id);

    String login(String username, String password);

    UmsAdmin register(UmsAdmin umsAdminParam);
}
