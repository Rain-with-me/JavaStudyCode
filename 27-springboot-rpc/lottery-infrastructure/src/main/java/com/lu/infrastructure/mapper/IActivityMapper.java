package com.lu.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lu.infrastructure.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author yedean
 * @date 2023/2/2
 */

@Repository
public interface IActivityMapper extends BaseMapper<Activity> {
    
}