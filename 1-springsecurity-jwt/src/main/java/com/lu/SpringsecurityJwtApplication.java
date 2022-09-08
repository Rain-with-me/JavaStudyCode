package com.lu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.lu.mapper")
@EnableWebMvc
public class SpringsecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityJwtApplication.class, args);
    }

}
