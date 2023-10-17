# 快速启动

- 直接启动，访问http://localhost:8080/

# 测试

```java
添加请求头，判断是否有权限访问，这里没有使用session
Authorization
Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDcyODA2Mzc3NjYxMDA5OTIwIiwic3ViIjoiYWRtaW4iLCJpYXQiOjE2OTIxNzI3MzQsInJvbGVzIjpbIueuoeeQhuWRmCJdLCJhdXRob3JpdGllcyI6W10sImV4cCI6MTY5Mjc3NzUzNH0.bziw0YjyGvYv59z4W2GkdYY4P163nUGQitcI5Fqe-G4
```

# 盲区



1. Spel表达式

2. ```
   @EnableConfigurationProperties就是将ConfigurationProperties这个注解生效
   ```

3. ```
    private Collection<? extends GrantedAuthority> authorities;
    这个里面是权限
    例如：使用 @PreAuthorize("hasRole('ADMIN')")，
    这个需要查看他的源码,可以看到他的默认前缀ROLE_
    自定义不需要前缀查看配置类,不知道为什么不生效，解决不了
    
    ```
[权限参考](https://docs.spring.io/spring-security/site/docs/4.0.1.RELEASE/reference/htmlsingle/#el-common-built-in)





