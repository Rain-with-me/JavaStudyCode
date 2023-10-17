package com.lu.edu.utils.exception;

import com.lu.edu.config.security.common.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Api(tags = "自定义异常类")
public class DiyException extends RuntimeException{

   @ApiModelProperty(value = "状态码")
   private Integer code; //状态码
   private String msg;//异常信息

   public DiyException(Status status) {
      this.code = status.getCode();
      this.msg = status.getMessage();
   }


   public DiyException(Integer code, String message) {
      this.code = code;
      this.msg = message;
   }
}
