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
 * 后台资源表
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-21
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="UmsResource对象", description="后台资源表")
public class UmsResource implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "创建时间")
      private Date createTime;

      @ApiModelProperty(value = "资源名称")
      private String name;

      @ApiModelProperty(value = "资源URL")
      private String url;

      @ApiModelProperty(value = "描述")
      private String description;

      @ApiModelProperty(value = "资源分类ID")
      private Long categoryId;


}
