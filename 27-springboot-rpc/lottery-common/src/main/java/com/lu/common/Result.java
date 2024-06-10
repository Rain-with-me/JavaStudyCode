package com.lu.common;

import java.io.Serializable;

/**
 * 通用结果类
 * <p>
 * 统一返回对象中，Code码、Info描述
 *
 * @author yedean
 * @date 2023/2/2
 */
public class Result implements Serializable {


    private final String code;

    private final String info;

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public static Result buildResult(String code, String info) {
        return new Result(code, info);
    }
    
    
    public static Result buildSuccessResult(){
        return new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

    public static Result buildErrorResult() {
        return new Result(Constants.ResponseCode.UN_ERROR.getCode(), Constants.ResponseCode.UN_ERROR.getInfo());
    }

}
