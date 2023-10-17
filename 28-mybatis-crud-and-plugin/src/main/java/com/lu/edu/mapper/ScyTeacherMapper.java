package com.lu.edu.mapper;

import com.lu.edu.entity.ScyTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mybatis自动生成
 * @since 2023-02-13
 */
@Repository
public interface ScyTeacherMapper extends BaseMapper<ScyTeacher> {
    List<ScyTeacher> selectALl(@Param("scy_teacher") String scy_teacher);
}
