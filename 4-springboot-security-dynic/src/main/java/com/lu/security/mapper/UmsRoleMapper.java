package com.lu.security.mapper;

import com.lu.security.entity.UmsMenu;
import com.lu.security.entity.UmsRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 Mapper 接口
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-22
 */
@Repository
public interface UmsRoleMapper extends BaseMapper<UmsRole> {
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
}
