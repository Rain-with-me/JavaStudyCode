package com.lu.edu.violate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/13 15:29
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface Roles {
    Role[] rolesName();
}
