## Mybatis 拦截器

基本使用：

[自定义实现拦截器插件Interceptor](https://cloud.tencent.com/developer/article/1734409)

深入了解：

[深入理解Mybatis插件开发 - 风一样的码农 - 博客园](https://www.cnblogs.com/chenpi/p/10498921.html)





#### 基本使用



:cactus: mybatis插件

```java
import com.lu.edu.utils.ReflectUtil;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Date;
import java.util.Properties;

/**
 * @Description: mybatis拦截器
 * @Author: 雨同我
 * @DateTime: 2023/2/14 19:54
*/
@Intercepts(value = {@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class MyInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        Object obj = boundSql.getParameterObject();
        String sql = boundSql.getSql();
        if (sql.trim().toUpperCase().startsWith("SELECT")) {
//            ReflectUtil.setFieldValue(obj, "rev", 0);
            ReflectUtil.setFieldValue(obj, "gmt_create", new Date());
            ReflectUtil.setFieldValue(obj, "gmt_modified", new Date());
//            ReflectUtil.setFieldValue(boundSql,"parameterObject", obj);

        } else if (sql.trim().toUpperCase().startsWith("UPDATE")) {
            sql = sql.replaceAll(" set ", " SET ")
                    .replaceAll(" Set ", " SET ")
                    .replaceAll(" SET ", " SET rev = rev+1, operate_time = NOW(), ");
            ReflectUtil.setFieldValue(boundSql,"sql", sql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
```

上面涉及的工具类

```java
public class ReflectUtil {

    private ReflectUtil() {}

    /**
     * 利用反射获取指定对象的指定属性
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException e) {
                //这里不用做处理，子类没有该字段，可能父类有，都没有就返回null
            }
        }
        return field;
    }

    /**
     * 利用反射设置指定对象的指定属性为指定的值
     * @param obj 目标对象
     * @param fieldName 目标属性
     * @param fieldValue 目标值
     */
    public static void setFieldValue(Object obj, String fieldName, Object fieldValue) throws IllegalAccessException {
        Field field = getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            field.set(obj, fieldValue);
            field.setAccessible(false);
        }
    }
}
```





:cactus:注入到 IOC 容器的 2 种方式

1. 使用 Bean 的方式注入

```java
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
```



2. xml 方式注入

- mybatis-config

```javascript
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>    
	<plugins>
        <plugin interceptor="com.qxy.mybatis.interceptor.MyInterceptor"/>
    </plugins>

</configuration>
```



- application.yml 特别重要的一点，一定将mybatis-config中的对象注入到Sprint[容器](https://cloud.tencent.com/product/tke?from=10680)中，否则不会生效。

```xml
...//省略其他配置
mybatis:
  config-location: classpath:/mybatis-config.xml
```

