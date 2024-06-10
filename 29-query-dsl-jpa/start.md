# Getting Started

### verssion
```
gradle 7.4
springboot 3.0
```

# spring-data-jpa learning

# spring-validation learning
参考： https://developer.aliyun.com/article/786719
```angular2html

常见的约束注解如下：

注解	功能
@AssertFalse	可以为null,如果不为null的话必须为false
@AssertTrue	可以为null,如果不为null的话必须为true
@DecimalMax	设置不能超过最大值
@DecimalMin	设置不能超过最小值
@Digits	设置必须是数字且数字整数的位数和小数的位数必须在指定范围内
@Future	日期必须在当前日期的未来
@Past	日期必须在当前日期的过去
@Max	最大不得超过此最大值
@Min	最大不得小于此最小值
@NotNull	不能为null，可以是空
@Null	必须为null
@Pattern	必须满足指定的正则表达式
@Size	集合、数组、map等的size()值必须在指定范围内
@Email	必须是email格式
@Length	长度必须在指定范围内
@NotBlank	字符串不能为null,字符串trim()后也不能等于“”
@NotEmpty	不能为null，集合、数组、map等size()不能为0；字符串trim()后可以等于“”
@Range	值必须在指定范围内
@URL	必须是一个URL
注：此表格只是简单的对注解功能的说明，并没有对每一个注解的属性进行说明；可详见源码。
```

```angular2html
 * 注意点： @Validated，单参数校验需要再controller进行添加
```



## data-jap
### 占位符
```angular2html

占位符：
位置参数（Positional Parameters）： 使用 ? 后跟参数位置的方式。在方法参数列表中的第一个参数用 ?1 表示，第二个用 ?2，以此类推。

命名参数（Named Parameters）： 使用 : 后跟参数名的方式。在这里，:username 表示一个命名参数，它需要在方法签名或注解上使用 @Param("username") 来关联方法参数。

@Query("select u from AdminEntity u where u.username = ?1")
List<AdminEntity> findByName(String username);

    //    @Query("select u from AdminEntity u where u.username = :username")
    //    List<AdminEntity> findByName(@Param("username") String username);
```

### 自定义crud
```angular2html
具体操作查看 DiyAdminController
nativeQuery=true 原生sql
进行insert和update时需要添加@Transactional
动态查询只能参考 https://www.baeldung.com/spring-data-jpa-query
```


## mapStruct
```angular2html
https://juejin.cn/post/7140149801991012365
```
