package com.lu.edu.controller;

import com.lu.edu.utils.result.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/2/1 19:49
 **/
@RestController
@ApiOperation("redis")
public class TestController {

    @Resource
    private RedissonClient redissonClient;


    @GetMapping("redisson")
    public CommonResult redisson(){
//        这里直接储存在redis
        RList<Object> list = redissonClient.getList("listok");
        list.add("11111");
        return CommonResult.success("ok");
    }

    @GetMapping("redissonLock")
    public CommonResult redissonLock(){
//        这里直接储存在redis
        Date date = new Date();
        String t= "redisson:"+String.valueOf(date);
        System.out.println(t);

        RLock lock = redissonClient.getLock(t);
        lock.lock(); //加锁

        try {
            Thread.sleep(35000);
//            逻辑代码
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); //sf释放锁
        }
        return CommonResult.success("ok");
    }

    @GetMapping("ok")
    public String test(){
        return "ok";
    }

}
