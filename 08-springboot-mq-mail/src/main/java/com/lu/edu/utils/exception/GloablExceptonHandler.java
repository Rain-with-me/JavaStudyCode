package com.lu.edu.utils.exception;


import com.lu.edu.utils.result.CommonResult;
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
      return CommonResult.failed(e.getMessage());
   }


    @ExceptionHandler(DiyException.class)
    @ResponseBody
    public CommonResult error(DiyException e){
        log.info("进入了全局异常处理");
        e.printStackTrace();
        log.error(e.getMsg());
        return CommonResult.failed(e.getCode(),e.getMessage());
    }
}
