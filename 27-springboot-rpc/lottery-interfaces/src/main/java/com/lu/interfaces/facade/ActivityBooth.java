package com.lu.interfaces.facade;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lu.common.Result;
import com.lu.infrastructure.mapper.IActivityMapper;
import com.lu.infrastructure.pojo.Activity;
import com.lu.rpc.IActivityBooth;
import com.lu.rpc.dto.ActivityDto;
import com.lu.rpc.req.ActivityReq;
import com.lu.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * ActivityBooth
 *
 * @author yedean
 * @date 2023/2/2
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityMapper activityMapper;


    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        //根据活动ID查询活动信息
        Activity activity = activityMapper.selectOne(new LambdaQueryWrapper<Activity>().eq(Activity::getActivityId,req.getActivityId()));
        //封装
        ActivityDto dto = new ActivityDto();
        //copy需要属性
        BeanUtils.copyProperties(activity, dto);
        //封装返回类
        return new ActivityRes(dto,Result.buildSuccessResult());
    }
}
