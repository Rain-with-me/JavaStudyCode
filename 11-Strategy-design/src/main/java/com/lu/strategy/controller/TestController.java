package com.lu.strategy.controller;

import com.lu.strategy.service.StrategyUseService;
import com.lu.strategy.utils.FileTypeResolveEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/10 11:01
 **/

@RestController
public class TestController {

    @Autowired
    private StrategyUseService service;

    /**
     * @Description: 参数解释：1是文件类型，2是传参的参数
    */
    @GetMapping("/test")
    public void test(){
        Object param="文件类型";
        service.resolveFile(FileTypeResolveEnum.File_A_RESOLVE,param);
    }
}
