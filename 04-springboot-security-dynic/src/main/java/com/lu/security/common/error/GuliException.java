package com.lu.security.common.error;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "自定义异常类")
public class GuliException extends RuntimeException{

   @ApiModelProperty(value = "状态码")
   private Integer code; //状态码
   private String message;//异常信息
}
