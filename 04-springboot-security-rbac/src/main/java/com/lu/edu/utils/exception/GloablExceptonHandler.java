package com.lu.edu.utils.exception;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.lu.edu.config.security.common.Status;
import com.lu.edu.utils.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class GloablExceptonHandler {
  //指定出现什么异常执行这个方法
//   @ExceptionHandler(Exception.class)
//   @ResponseBody
//   public CommonResult error(Exception e){
//      e.printStackTrace();
//      return CommonResult.failed(e.getMessage());
//   }

//    @ExceptionHandler(value = DiyException.class)
//    @ResponseBody
//    public CommonResult error(DiyException e){
//        log.info("进入了全局异常处理");
//        log.error(e.getMsg());
//        return CommonResult.failed(e.getCode(),e.getMessage());
//    }


    @ExceptionHandler(value = DiyException.class)
    @ResponseBody
    public CommonResult handlerException(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            log.error("【全局异常拦截】NoHandlerFoundException: 请求方法 {}, 请求路径 {}", ((NoHandlerFoundException) e).getRequestURL(), ((NoHandlerFoundException) e).getHttpMethod());
            return CommonResult.failed(Status.REQUEST_NOT_FOUND);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            log.error("【全局异常拦截】HttpRequestMethodNotSupportedException: 当前请求方式 {}, 支持请求方式 {}", ((HttpRequestMethodNotSupportedException) e).getMethod(), JSONUtil.toJsonStr(((HttpRequestMethodNotSupportedException) e).getSupportedHttpMethods()));
            return CommonResult.failed(Status.HTTP_BAD_METHOD);
        } else if (e instanceof MethodArgumentNotValidException) {
            log.error("【全局异常拦截】MethodArgumentNotValidException", e);
            return CommonResult.failed(Status.BAD_REQUEST.getCode(), ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage());
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            log.error("【全局异常拦截】MethodArgumentTypeMismatchException: 参数名 {}, 异常信息 {}", ((MethodArgumentTypeMismatchException) e).getName(), ((MethodArgumentTypeMismatchException) e).getMessage());
            return CommonResult.failed(Status.PARAM_NOT_MATCH);
        } else if (e instanceof HttpMessageNotReadableException) {
            log.error("【全局异常拦截】HttpMessageNotReadableException: 错误信息 {}", ((HttpMessageNotReadableException) e).getMessage());
            return CommonResult.failed(Status.PARAM_NOT_NULL);
        } else if (e instanceof BadCredentialsException) {
            log.error("【全局异常拦截】BadCredentialsException: 错误信息 {}", e.getMessage());
            return CommonResult.failed(Status.USERNAME_PASSWORD_ERROR);
        } else if (e instanceof DisabledException) {
            log.error("【全局异常拦截】BadCredentialsException: 错误信息 {}", e.getMessage());
            return CommonResult.failed(Status.USER_DISABLED);
        } else if (e instanceof SecurityException) {
            log.error("【全局异常拦截】BadCredentialsException: 错误信息 {}", e.getMessage());
            return CommonResult.failed(Status.REQUEST_NOT_FOUND);
        } else if (e instanceof DiyException) {
            log.error("【全局异常拦截】DataManagerException: 状态码 {}, 异常信息 {}", ((DiyException) e).getCode(), e.getMessage());
            return CommonResult.failed(e.getMessage());
        }

        log.error("【全局异常拦截】: 异常信息 {} ", e.getMessage());
        return CommonResult.failed(Status.ERROR);
    }


}
