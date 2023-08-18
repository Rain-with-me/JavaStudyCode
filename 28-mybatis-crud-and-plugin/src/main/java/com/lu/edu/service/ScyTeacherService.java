package com.lu.edu.service;

import com.lu.edu.entity.ScyTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-02-13
 */
public interface ScyTeacherService extends IService<ScyTeacher> {
    public List<ScyTeacher> selectAll(String scy_teacher);
}
