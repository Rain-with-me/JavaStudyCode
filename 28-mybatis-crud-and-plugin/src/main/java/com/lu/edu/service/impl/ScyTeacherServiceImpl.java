package com.lu.edu.service.impl;

import com.lu.edu.entity.ScyTeacher;
import com.lu.edu.mapper.ScyTeacherMapper;
import com.lu.edu.service.ScyTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-02-13
 */
@Service
public class ScyTeacherServiceImpl extends ServiceImpl<ScyTeacherMapper, ScyTeacher> implements ScyTeacherService {

    @Autowired
    private ScyTeacherMapper scyTeacherMapper;

    @Override
    public List<ScyTeacher> selectAll(String scy_teacher) {
        List<ScyTeacher> scyTeachers = scyTeacherMapper.selectALl(scy_teacher);
        return scyTeachers;
    }
}
