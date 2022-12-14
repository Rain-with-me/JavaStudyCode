package com.lu.observer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: éšćæ
 * @Description:
 * @DateTime: 2022/11/5 10:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotifyEvent {
    private String mobileNo;

    private String emailNo;

    private String imNo;
}
