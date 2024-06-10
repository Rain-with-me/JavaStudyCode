package com.lu.design.责任链模式;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/2 15:25
 **/

@RestController
public class TestController {
    @Autowired
    private ChainPatternDemo chainPatternDemo;

    @GetMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response){
        chainPatternDemo.exec(request,response);
    }
}
