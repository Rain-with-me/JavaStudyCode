package com.lu.security.service;

import com.lu.security.entity.UmsResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 后台资源表 服务类
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-21
 */
public interface UmsResourceService extends IService<UmsResource> {

    List<UmsResource> listAll();
    List<UmsResource> getResourceList(Long id);
}
