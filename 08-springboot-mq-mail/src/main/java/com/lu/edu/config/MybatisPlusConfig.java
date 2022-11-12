package com.lu.edu.config;

import org.mybatis.spring.annotation.MapperScan;
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
}
