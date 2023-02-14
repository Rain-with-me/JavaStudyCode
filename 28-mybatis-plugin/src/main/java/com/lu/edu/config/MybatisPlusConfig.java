package com.lu.edu.config;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/10/13 12:42
 **/
@Configuration
@MapperScan("com.lu.edu.mapper")
// 开启事务
@EnableTransactionManagement
public class MybatisPlusConfig {

    /** 
     * @Description: 将mybatis组件注入到ioc
     * @Author: 雨同我
     * @DateTime: 2023/2/14 20:17
    */
    @Bean
    public Interceptor plugin() {
        return new MyInterceptor();
    }
}
