package com.lu.edu.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限关系表
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-08-15
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("sec_role_permission")
@ApiModel(value="RolePermission对象", description="角色权限关系表")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "角色主键")
        private Long roleId;

      @ApiModelProperty(value = "权限主键")
      private Long permissionId;


}
