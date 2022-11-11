package com.lu.design.责任链模式.check;

import com.lu.design.责任链模式.AbstractHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  规则拦截对象
 */
@Component
@Order(4) //校验顺序排第4
public class CheckRuleFilterObject extends AbstractHandler {

    @Override
    public void doFiler(HttpServletRequest request, HttpServletResponse response) {
        //check rule
        System.out.println("check rule");
    }
}
