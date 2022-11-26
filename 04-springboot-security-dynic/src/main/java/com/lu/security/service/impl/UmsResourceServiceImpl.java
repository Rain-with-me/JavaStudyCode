package com.lu.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lu.security.entity.UmsResource;
import com.lu.security.mapper.UmsAdminRoleRelationMapper;
import com.lu.security.mapper.UmsResourceMapper;
import com.lu.security.service.UmsResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-21
 */
@Service
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceMapper, UmsResource> implements UmsResourceService {

    @Autowired
    private UmsResourceMapper umsResourceMapper;
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    @Override
    public List<UmsResource> listAll() {
        return umsResourceMapper.selectList(null);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = umsAdminRoleRelationMapper.getResourceList(adminId);
        return resourceList;
    }
}
