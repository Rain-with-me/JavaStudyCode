package com.lu.observer;

import com.lu.observer.component.EventBusCenter;
import com.lu.observer.component.EventListener;
import com.lu.observer.entity.NotifyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObserverPattenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObserverPattenApplication.class, args);
        //观察者
        EventListener eventListener = new EventListener();
        EventBusCenter.register(eventListener);
        EventBusCenter.post(new NotifyEvent("13372817283", "123@qq.com", "注册成功"));
    }
}
