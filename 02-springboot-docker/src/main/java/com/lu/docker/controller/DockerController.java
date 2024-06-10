package com.lu.docker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/9/6 9:20
 **/
@RestController
public class DockerController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
