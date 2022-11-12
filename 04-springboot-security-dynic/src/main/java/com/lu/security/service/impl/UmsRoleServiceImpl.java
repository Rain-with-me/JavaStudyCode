package com.lu.security.service.impl;

import com.lu.security.entity.UmsMenu;
import com.lu.security.entity.UmsRole;
import com.lu.security.mapper.UmsRoleMapper;
import com.lu.security.service.UmsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 服务实现类
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-22
 */
@Service
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements UmsRoleService {
    @Autowired
    private UmsRoleMapper umsRoleMapper;

    @Override
    public List<UmsMenu> getMenuList(@Param("adminId") Long adminId) {
        return umsRoleMapper.getMenuList(adminId);
    }
}
