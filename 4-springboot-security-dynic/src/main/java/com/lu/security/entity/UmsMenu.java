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
 * 后台菜单表
 * </p>
 *
 * @author mybatis自动生成
 * @since 2022-09-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="UmsMenu对象", description="后台菜单表")
public class UmsMenu implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "父级ID")
      private Long parentId;

      @ApiModelProperty(value = "创建时间")
      private Date createTime;

      @ApiModelProperty(value = "菜单名称")
      private String title;

      @ApiModelProperty(value = "菜单级数")
      private Integer level;

      @ApiModelProperty(value = "菜单排序")
      private Integer sort;

      @ApiModelProperty(value = "前端名称")
      private String name;

      @ApiModelProperty(value = "前端图标")
      private String icon;

      @ApiModelProperty(value = "前端隐藏")
      private Integer hidden;


}
