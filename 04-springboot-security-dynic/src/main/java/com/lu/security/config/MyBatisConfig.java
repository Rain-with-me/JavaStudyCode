package com.lu.security.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** 
 * @Description: @EnableTransactionManagement开启事务
 * 然后在访问数据库的Service方法上添加注解 @Transactional 便可。
 * @Author: 雨同我
 * @DateTime: 2022/9/22 10:16
 */

@Configuration
@EnableTransactionManagement
@MapperScan("com.lu.security.mapper")
public class MyBatisConfig {
    //    分页
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

}
