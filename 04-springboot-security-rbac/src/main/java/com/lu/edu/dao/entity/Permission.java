package com.lu.edu.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-08-15
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("sec_permission")
@ApiModel(value="Permission对象", description="权限表")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "主键")
        private Long id;

      @ApiModelProperty(value = "权限名")
      private String name;

      @ApiModelProperty(value = "类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址")
      private String url;

      @ApiModelProperty(value = "权限类型，页面-1，按钮-2")
      private Integer type;

      @ApiModelProperty(value = "权限表达式")
      private String permission;

      @ApiModelProperty(value = "后端接口访问方式")
      private String method;

      @ApiModelProperty(value = "排序")
      private Integer sort;

      @ApiModelProperty(value = "父级id")
      private Long parentId;


}
