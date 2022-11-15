package com.lu.edu.controller;

import com.lu.edu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/15 15:44
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public void test(){
        testService.testAsync();
    }
}
