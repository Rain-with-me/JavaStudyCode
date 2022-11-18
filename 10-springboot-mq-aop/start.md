# rabbitmq整合springboot发送邮件

## 学习参考
- [邮件发送](https://www.cnblogs.com/rain-me/p/16774779.html)

## 盲区
### @EnableRabbit的使用
- 顾名思义，开启mq,@EnableRabbit注解来启用@RabbitListener
- 更多作用自己研究官网： [@EnableRabbit的使用](https://docs.spring.io/spring-amqp/docs/current/reference/html/)

## 注意点
### 发送模板邮件
问题：无法找到模板
解决办法： yml里面添加他的位置

### mq的确认方式
- 手动确认(yml里面配置)
- 为什么要收到确认，只要是怕他数据丢失


# Mq+Aop实现日志
- 参考链接[博客](https://blog.csdn.net/weixin_43841630/article/details/113757891)
- [aop的深入理解](https://mrbird.cc/%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Spring-AOP%E5%8E%9F%E7%90%86.html)
- 这个案例和参考博客有点不一样，没有他的全部资料