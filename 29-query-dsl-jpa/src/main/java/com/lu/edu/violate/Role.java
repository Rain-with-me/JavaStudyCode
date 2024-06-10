package com.lu.edu.violate;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/13 15:29
 **/
public @interface Role {
    String roleName() default "user";
}
