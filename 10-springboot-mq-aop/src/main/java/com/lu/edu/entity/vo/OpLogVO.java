package com.lu.edu.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/18 10:53
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpLogVO {
    /**
     * 接口名称
     */
    private String opApiName;
    /**
     * 方法签名
     */
    private String opMethodSignature;
    /**
     * 方法入参
     */
    private String opMethodArgs;
    /**
     * http方法 POST/GET/HEAD/FETCH/DELETE等
     */
    private String opHttpMethod;
    /**
     * http路径, 从controller的requestMapping到方法的requestMapping
     */
    private String opHttpPath;
    /**
     * url
     */
    private String opHttpUrl;
    /**
     * 日志记录时间（接口被调用时间）
     */
    private Date opStartTime;
    /**
     * 接口执行总时长（毫秒ms）
     */
    private Long opExecuteDuration;
    /**
     * 接口调用方id
     */
    private String opCallerId;
    /**
     * 接口调用方名字
     */
    private String opCallerName;
    /**
     * 接口调用方token
     */
    private String opCallerToken;
    /**
     * 接口调用方手机号
     */
    private String opCallerPhone;
    /**
     * 接口调用方ip
     */
    private String opCallerIp;
    /**
     * 接口执行结果: 1-正常返回，0-抛出异常
     */
    private String opResultFlag;
    /**
     * 业务执行结果
     */
    private String opBusinessFlag;
    /**
     * 接口执行抛出异常时的堆栈信息
     */
    private String opResultThrow;
}
