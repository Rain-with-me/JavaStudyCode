package com.lu.security.mapper;

import com.lu.security.entity.UmsAdminRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lu.security.entity.UmsResource;
import com.lu.security.entity.UmsRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-22
 */
@Repository
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {

    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    List<UmsResource> getResourceList(Long adminId);
}
