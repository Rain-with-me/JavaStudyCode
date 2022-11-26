package com.lu.security.service;

import com.lu.security.entity.UmsMenu;
import com.lu.security.entity.UmsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务类
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-22
 */
public interface UmsRoleService extends IService<UmsRole> {

    List<UmsMenu> getMenuList(Long adminId);
}
