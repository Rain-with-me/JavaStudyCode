## Mybatis 拦截器

基本使用：

[自定义实现拦截器插件Interceptor](https://cloud.tencent.com/developer/article/1734409)

深入了解：

[深入理解Mybatis插件开发 - 风一样的码农 - 博客园](https://www.cnblogs.com/chenpi/p/10498921.html)





#### 基本使用



:cactus: mybatis插件

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







## Mybatis-plus 的一些配置

全部参考：[个人博客页面](https://blog.csdn.net/qq_40688338/article/details/83380953)

官网参考： [官网](https://baomidou.com/pages/56bac0/#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE)



configLocation

```yamL
类型 string
默认值 null
MyBatis 配置文件位置，如果您有单独的 MyBatis 配置，请将其路径配置到 configLocation 中
```

```yamL
mybatis-plus:
  mapper-locations: classpath*:mybatis/*.xml
```



typeAliasesPackage

```yaml
类型 string
默认值 null
MyBaits 别名包扫描路径，通过该属性可以给包中的类注册别名，注册后在 Mapper 对应的 XML 文件中可以直接使用类名，而不用使用全限定的类名（即 XML 中调用的时候不用包含包名）。
```

```yaml
mybatis-plus:
  type-aliases-package: com.baomidou.mybatisplus.samples.quickstart.entity
```





<font color='#7bed9f'>typeAliasesSuperType</font>

    类型 string
    默认值 null
    该配置请和 typeAliasesPackage 一起使用，如果配置了该属性，则仅仅会扫描路径下以该类作为父类的域对象 。

```yaml
mybatis-plus:
  type-aliases-package: com.baomidou.mybatisplus.samples.quickstart.entity
  type-aliases-super-type: java.lang.Object
```



<font color='#7bed9f'>checkConfigLocation</font>

- 类型 boolean
- 默认值 false
   启动时是否检查 MyBatis XML 文件的存在，默认不检查。

```yaml
mybatis-plus:
  check-config-location: false
```



<font color='orange'>map-underscore-to-camel-case</font>

- 驼峰命名规范

```yaml
mybatis-plus:
 mapper-locations: classpath:mapper/*.xml
 type-aliases-package: com.example.entity
 configuration:
  map-underscore-to-camel-case: true
```





## 连表查询





### <font color='orange'>参数解析</font>

`result`

```xml
<!--手动指定字段与实体属性的映射关系
            column: 数据表的字段名称
            property：实体的属性名称
        -->
<result property="id" column="sid"/>
```

`collection`

```xml
private List<Order> orderList

<!--配置集合信息
        property:集合名称
        ofType：当前集合中的数据类型
    -->
    <collection property="orderList" ofType="order">
        <!--封装order的数据-->
        <id column="oid" property="id"></id>
        <result column="ordertime" property="ordertime"></result>
        <result column="total" property="total"></result>
    </collection>
```

`association`

```xml
<!--
        property: 当前实体(order)中的属性名称(private User user)
        javaType: 当前实体(order)中的属性的类型(User)
    -->
    <association property="user" javaType="com.lu.User">
        <id column="uid" property="id"></id>
        <result column="username" property="username"></result>
        <result column="password" property="password"></result>
        <result column="birthday" property="birthday"></result>
    </association>
```





### 一对多



- 实体类

```java
# 一个老师对应多个学生

@Data
public class Student {
    private int id;
    private String name;
    private int tid;
}

@Data
public class Teacher {
    private int id;
    private String name;
    //一个老师拥有多个学生
    private List<Student> students;
}
```



```java
Teacher getTeacher2(@Param("tid") int id);
```



```xml
	<!--    按结果嵌套查询-->
    <select id="getTeacher" resultMap="TeacherStudent">
        select s.id sid,s.student_name sname,t.teacher_name tname,t.id tid
        from student s,teacher t
        where s.tid=t.id and t.id=#{tid}
    </select>
    <resultMap id="TeacherStudent" type="pojo.Teacher">
        <result property="id" column="tid"/>
        <result property="name" column="tname"/>
        <!--        复杂的属性需要单独处理 是对象就使用association，是集合就使用collection
        javaType="" 指定的属性类型
        集合中的泛型信息，使用ofType获取-->
        <collection property="students" ofType="pojo.Student">
            <result property="id" column="sid"/>
            <result property="name" column="sname"/>
            <result property="tid" column="tid"/>
        </collection>
    </resultMap>

```







### 多对一



- 实体类

```java
@Data
public class Teacher {
    private int id;
    private String name;
}

@Data
public class Student {
    private int id;
    private String name;
    //学生需要关联一个老师
    private Teacher teacher;
}
```



- 完整代码

```java
//按照结果嵌套查询
public List<Student> getStudent2();
```



```xml
<!--    按照结果嵌套处理-->
    <select id="getStudent2" resultMap="StudentTeacher2">
    select s.id sid,s.student_name sname,t.teacher_name tname
    from student s,teacher t
    where s.tid=t.id
    </select>
    <resultMap id="StudentTeacher2" type="pojo.Student">
        <result property="id" column="sid"/>
        <result property="name" column="sname"/>
        <association property="teacher" javaType="pojo.Teacher">
            <result property="name" column="tname"/>
        </association>
    </resultMap>
```



