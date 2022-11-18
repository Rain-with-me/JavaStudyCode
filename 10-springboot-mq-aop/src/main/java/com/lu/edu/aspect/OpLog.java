package com.lu.edu.aspect;

import java.lang.annotation.*;

// OpLog.java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLog {
    String apiName();
}