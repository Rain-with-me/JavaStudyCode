package com.lu.observer.component;

import com.google.common.eventbus.Subscribe;
import com.lu.observer.entity.NotifyEvent;



public class EventListener {

    //加了订阅，这里标记这个方法是事件处理方法
    @Subscribe
    public void handle(NotifyEvent notifyEvent) {
        System.out.println("发送IM消息" + notifyEvent.getImNo());
        System.out.println("发送短信消息" + notifyEvent.getMobileNo());
        System.out.println("发送Email消息" + notifyEvent.getEmailNo());
    }
}
