package com.lu.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lu.edu.entity.ScyTeacher;
import com.lu.edu.service.ScyTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-02-13
 */
@RestController
@RequestMapping("/edu/scy-teacher")
public class ScyTeacherController {
    @Autowired
    private ScyTeacherService scyTeacherService;


    @GetMapping("/mybatisPlugin")
    public void test(){
        ScyTeacher scyTeacher = new ScyTeacher();
        scyTeacher.setUsername("ok");
        int insert = scyTeacherService.getBaseMapper().insert(scyTeacher);
    }
}

