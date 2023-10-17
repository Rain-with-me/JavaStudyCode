package com.lu.edu.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-08-15
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("sec_user")
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "主键")
        private Long id;

      @ApiModelProperty(value = "用户名")
      private String username;

      @ApiModelProperty(value = "密码")
      private String password;

      @ApiModelProperty(value = "昵称")
      private String nickname;

      @ApiModelProperty(value = "手机")
      private String phone;

      @ApiModelProperty(value = "邮箱")
      private String email;

      @ApiModelProperty(value = "生日")
      private Long birthday;

      @ApiModelProperty(value = "性别，男-1，女-2")
      private Integer sex;

      @ApiModelProperty(value = "状态，启用-1，禁用-0")
      private Integer status;

      @ApiModelProperty(value = "权限role")
      private String roleId;

      @ApiModelProperty(value = "创建时间")
        @TableField(fill = FieldFill.INSERT)
      private Long createTime;

      @ApiModelProperty(value = "更新时间")
        @TableField(fill = FieldFill.INSERT_UPDATE)
      private Long updateTime;


}
