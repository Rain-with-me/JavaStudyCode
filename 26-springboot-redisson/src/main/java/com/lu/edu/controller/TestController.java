package com.lu.edu.controller;

import com.lu.edu.utils.exception.DiyException;
import com.lu.edu.utils.result.CommonResult;
import com.lu.edu.utils.webUtil.RedisCache;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.redisson.RedissonLock;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

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
    @Autowired
    private RedisCache redisCache;


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


    /**
     * @Description: 互斥锁的使用
     * @Author: 雨同我
     * @DateTime: 2023/12/18 16:26
     * @param: null:
     * @return:
    */

    @GetMapping("/lock")
    public CommonResult MutuallyExclusiveLock(@RequestParam String id) {
        ReentrantLock reentrantLock = new ReentrantLock();
//        取缓存
        String cache=redisCache.getCacheObject(id);

        if (StringUtils.isBlank(cache)){
            if (reentrantLock.tryLock()){
//                查询数据
                try {
                    String database="ok";
                    if (StringUtils.isBlank(database)){
                        throw new DiyException(500,"数据为空");
                    }
                    redisCache.setCacheObject(id,database);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }else {
            // 再次从缓存中取,双重判断
            String t=redisCache.getCacheObject(id);
            if (StringUtils.isBlank(t)){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return MutuallyExclusiveLock(id);
        }
        return CommonResult.success(cache);
    }









}
