package com.lu.template.controller;

import com.lu.template.service.AbstractMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/10 15:55
 **/
@RestController
public class TestController {

    @Autowired
    private AbstractMerchantService abstractMerchantService;

    @GetMapping("/test")
    public void test(){
        abstractMerchantService.handlerTempPlate();
    }
}
