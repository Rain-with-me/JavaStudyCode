package com.lu.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-02-13
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="ScyTeacher对象", description="")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScyTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      @ApiModelProperty(value = "人员名字")
      private String username;

      @ApiModelProperty(value = "培训座位号")
      private String seat;

      @ApiModelProperty(value = "创建时间")
        @TableField(fill = FieldFill.INSERT)
      private Date gmtCreate;

      @ApiModelProperty(value = "修改时间")
        @TableField(fill = FieldFill.INSERT_UPDATE)
      private Date gmtModified;


}
