package com.lu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/15 11:41
 **/
@Service
public class TestService {
    @Autowired
    private Executor asyncTaskExecutor;

    public void testAsync(){
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1====洗水壶"+ Thread.currentThread().getName());
            return "水壶";
        },asyncTaskExecutor).thenApplyAsync(param -> {
            System.out.println("上一个步骤的参数-->" + param + "====");
            System.out.println("热水");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "热水";
        },asyncTaskExecutor);
        //洗水壶->洗水杯->拿茶叶
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("2=======洗茶壶");
            return "茶壶";
        },asyncTaskExecutor).thenApplyAsync(e->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("洗水杯");
            return "水杯";
        },asyncTaskExecutor).thenApplyAsync(param->{
            System.out.println("拿茶叶");
            return "茶叶";
        },asyncTaskExecutor);

        CompletableFuture.allOf(task1,task2).join();
    }

}
