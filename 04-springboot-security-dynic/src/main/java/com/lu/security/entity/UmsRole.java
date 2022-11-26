package com.lu.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台用户角色表
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="UmsRole对象", description="后台用户角色表")
public class UmsRole implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "名称")
      private String name;

      @ApiModelProperty(value = "描述")
      private String description;

      @ApiModelProperty(value = "后台用户数量")
      private Integer adminCount;

      @ApiModelProperty(value = "创建时间")
      private Date createTime;

      @ApiModelProperty(value = "启用状态：0->禁用；1->启用")
      private Integer status;

    private Integer sort;


}
