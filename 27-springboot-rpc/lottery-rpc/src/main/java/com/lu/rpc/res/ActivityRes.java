package com.lu.rpc.res;



import com.lu.common.Result;
import com.lu.rpc.dto.ActivityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ActivityRes
 *
 * @author yedean
 * @date 2023/2/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRes implements Serializable {
    
    private ActivityDto activity;

    private Result result;
}
