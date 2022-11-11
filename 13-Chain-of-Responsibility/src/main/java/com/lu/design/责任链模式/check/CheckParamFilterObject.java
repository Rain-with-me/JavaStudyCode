package com.lu.design.责任链模式.check;

import com.lu.design.责任链模式.AbstractHandler;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 参数校验对象
 **/
@Component
@Order(1) //顺序排第1，最先校验
public class CheckParamFilterObject extends AbstractHandler {

    @Override
    protected void doFiler(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("非空参数检查");
    }
}
