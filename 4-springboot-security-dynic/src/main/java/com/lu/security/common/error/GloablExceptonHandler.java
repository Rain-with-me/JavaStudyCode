package com.lu.security.common.error;

import com.lu.security.common.result.CommonResult;
import com.lu.security.common.result.ResultCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GloablExceptonHandler {
  //指定出现什么异常执行这个方法
   @ExceptionHandler(Exception.class)
   @ResponseBody
   public CommonResult error(Exception e){
      e.printStackTrace();
      return CommonResult.failed(ResultCode.FAILED);
   }


    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public CommonResult error(GuliException e){
        log.info("进入了全局异常处理");
        e.printStackTrace();
        log.error(e.getMessage());
        return CommonResult.failed(e.getMessage());
    }
}
