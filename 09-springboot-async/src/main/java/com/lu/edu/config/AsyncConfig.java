package com.lu.edu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@ConfigurationProperties(prefix = "thread.pool")
public class AsyncConfig{
    //核心线程数量大小
    private   int corePoolSize = 4;
    //线程池最大容纳线程数
    private   int maxPoolSize =8;
    //阻塞队列
    private   int workQueue = 25;
    //线程空闲后的存活时长
    private   int keepAliveTime = 30;

    @Bean("asyncTaskExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //核心线程数
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        //最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        //等待队列
        threadPoolTaskExecutor.setQueueCapacity(workQueue);
        //线程前缀
        threadPoolTaskExecutor.setThreadNamePrefix("taskExecutor-");
        //线程池维护线程所允许的空闲时间,单位为秒
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveTime);
        // 线程池对拒绝任务(无线程可用)的处理策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}