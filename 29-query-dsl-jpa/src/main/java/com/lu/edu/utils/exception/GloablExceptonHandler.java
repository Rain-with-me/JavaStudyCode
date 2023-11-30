package com.lu.edu.utils.exception;


import com.lu.edu.utils.result.CommonResult;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GloablExceptonHandler {
  //指定出现什么异常执行这个方法 【默认】
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


//  参数校验异常

    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public CommonResult handleValidatedException(Exception e) {
        CommonResult<String> resp = null;


        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            resp = CommonResult.failed(HttpStatus.BAD_REQUEST.value(),
                    ex.getBindingResult().getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            ConstraintViolationException ex = (ConstraintViolationException) e;
            resp = CommonResult.failed(HttpStatus.BAD_REQUEST.value(),
                    ex.getConstraintViolations().stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof BindException) {
            // BeanValidation GET object param
            BindException ex = (BindException) e;
            resp = CommonResult.failed(HttpStatus.BAD_REQUEST.value(),
                    ex.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining())
            );
        }

        log.error("参数校验异常:{}",resp.getMessage());
        return resp;
    }

}
