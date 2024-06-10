package com.lu.rpc;


import com.lu.rpc.req.ActivityReq;
import com.lu.rpc.res.ActivityRes;

/**
 * @author yedean
 * @date 2023/2/2
 */
public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq activityReq);
}
