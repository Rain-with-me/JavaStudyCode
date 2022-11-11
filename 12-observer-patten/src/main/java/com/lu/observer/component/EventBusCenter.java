package com.lu.observer.component;

import com.google.common.eventbus.EventBus;


/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/5 10:27
 **/

public class EventBusCenter {
    private static EventBus eventBus=new EventBus();

    public static EventBus getInstance(){
        return eventBus;
    }
    //添加观察者
    public static void register(Object obj){
        eventBus.register(obj);
    }
    //移除观察者
    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }
    //把消息推给观察者
    public static void post(Object obj) {
        eventBus.post(obj);
    }
}
