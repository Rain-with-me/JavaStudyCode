package com.lu.design.责任链模式.check;

import com.lu.design.责任链模式.AbstractHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Order(3) //校验顺序排第3
public class CheckBlackFilterObject extends AbstractHandler {

    @Override
    public void doFiler(HttpServletRequest request, HttpServletResponse response) {
        //invoke black list check
        System.out.println("校验黑名单");
    }
}