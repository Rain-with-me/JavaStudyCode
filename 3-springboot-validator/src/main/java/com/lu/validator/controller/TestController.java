package com.lu.validator.controller;

import com.lu.validator.dto.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/9/17 9:17
 **/
@RestController
@Validated
public class TestController {

    @PostMapping("/valid")
    public String validator(@NotBlank(message = "{required}") String name,
                            @Email(message = "{invalid}") String email){
        return "success--->成功";
    }

    @PostMapping("test2")
    public String test2(@Valid User user) {
        return "success";
    }
}
