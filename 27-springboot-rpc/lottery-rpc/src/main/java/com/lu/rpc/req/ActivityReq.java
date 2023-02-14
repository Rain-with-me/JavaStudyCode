package com.lu.rpc.req;

import java.io.Serializable;

/**
 * ActivityReq
 *
 * @author yedean
 * @date 2023/2/2
 */
public class ActivityReq implements Serializable {
    
    private Long activityId;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}
