package com.lu.edu.aspect;

import com.github.houbb.log.integration.core.LogFactory;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.lu.edu.entity.vo.OpLogVO;
import com.lu.edu.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

// OpLogAspect.java 已做简化
@Aspect
@Component
@Slf4j
public class OpLogAspect {

    /** 
     * @Description: instanceof判断左边是否是它的子类或者实现类
     * @Author: 雨同我
     * @DateTime: 2022/11/18 10:58
    */

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${mq.config.log-key}")
    private String logRouter;
    @Value("${mq.config.exchange}")
    private String logExchange;

    private volatile JoinPoint joinPoint;
    private long startTime;
    private OpLogVO opLogVO;
    
    @Pointcut(value = "@annotation(com.lu.edu.aspect.OpLog)")
    public void opLogPointCut() {
    }
    
    // 在before时通过attributes 、signature等对象获取接口信息保存到opLogVO中
    @Before(value = "opLogPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        try {
            this.joinPoint = joinPoint;
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();

            opLogVO = new OpLogVO();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String startTime = format.format(date);

            opLogVO.setOpStartTime(new DateTime(startTime));

            Signature signature = joinPoint.getSignature();
            if (signature instanceof MethodSignature) {
                String apiName = ((MethodSignature) signature).getMethod().getAnnotation(OpLog.class).apiName();
                opLogVO.setOpApiName(apiName);
//                setMethodAndPath(joinPoint, (MethodSignature) signature);
//                setMethodArgs(joinPoint, (MethodSignature) signature);
            }
            opLogVO.setOpMethodSignature(signature.toString());
            if (attributes instanceof ServletRequestAttributes) {
                HttpServletRequest servletRequest = ((ServletRequestAttributes) attributes).getRequest();
                opLogVO.setOpHttpUrl(servletRequest.getRequestURL().toString());
//                TODO 获取IP地址
                opLogVO.setOpCallerIp(IpUtils.getRealIp(servletRequest));
            }
        } catch (Exception e) {
            log.error("切面处理操作日志异常！logBefore-", e);
        }
    }
    
    // AfterReturning表示接口正常返回，将保存了信息的OpLogVO对象发送到MQ队列
    @AfterReturning(value = "opLogPointCut()", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
        if (this.joinPoint.equals(joinPoint)) {
            try {
                long executeDuration = System.currentTimeMillis() - startTime;
                opLogVO.setOpExecuteDuration(executeDuration);
                opLogVO.setOpResultFlag("1");

                rabbitTemplate.convertAndSend(logExchange,logRouter, opLogVO);
            } catch (Exception e) {
                log.error("切面处理操作日志异常！logAfterReturning-", e);
            }
        }
    }
    
    // AfterThrowing表示接口出现异常，将异常堆栈保存到OpLogVO对象发送到MQ队列
    @AfterThrowing(value = "opLogPointCut()", throwing = "throwValue")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable throwValue) {
        if (this.joinPoint.equals(joinPoint)) {
            try {
                long executeDuration = System.currentTimeMillis() - startTime;
                opLogVO.setOpExecuteDuration(executeDuration);
                opLogVO.setOpResultFlag("0");
                // import cn.hutool.core.exceptions.ExceptionUtil;
                String stacktrace = ExceptionUtil.stacktraceToString(throwValue);
                opLogVO.setOpResultThrow(StrUtil.sub(stacktrace, 0, 450));

                rabbitTemplate.convertAndSend(logExchange,logRouter, opLogVO);
            } catch (Exception e) {
                log.error("切面处理操作日志异常！logAfterThrowing-", e);
            }
        }
    }
}