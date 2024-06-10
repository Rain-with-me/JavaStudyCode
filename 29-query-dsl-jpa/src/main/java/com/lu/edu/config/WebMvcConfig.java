package com.lu.edu.config;


import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.querydsl.jpa.impl.JPAQueryFactory;

/** 
 * @Description: 方式1
 * @Author: 雨同我
 * @DateTime: 2023/11/10 10:21
 * @param: null: 
 * @return: 
*/

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {    
    @Bean
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}

   /* */
/**
     * 方式二。在Dao类中初始化
     *//*
    // 实体管理
    @Autowired
    private EntityManager entityManager;
    // 查询工厂
    private JPAQueryFactory queryFactory;

    // 初始化JPA查询工厂
    @PostConstruct		// Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
    public void init(){
        queryFactory = new JPAQueryFactory(entityManager);
    }
*/