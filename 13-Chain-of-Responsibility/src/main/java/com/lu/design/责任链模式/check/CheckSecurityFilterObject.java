package com.lu.design.责任链模式.check;

import com.lu.design.责任链模式.AbstractHandler;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  安全校验对象
 */
@Component
@Order(2) //校验顺序排第2
public class CheckSecurityFilterObject extends AbstractHandler {

    @Override
    protected void doFiler(HttpServletRequest request, HttpServletResponse response) {
        //invoke Security check
        System.out.println("安全调用校验");
    }
}
