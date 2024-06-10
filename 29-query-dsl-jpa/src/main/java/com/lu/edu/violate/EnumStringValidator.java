package com.lu.edu.violate;



import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/13 15:39
 **/
public class EnumStringValidator implements ConstraintValidator<EnumString,String> {
    private List<String> enumList;

    @Override
    public void initialize(EnumString constraintAnnotation) {
        enumList= Arrays.asList(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value==null){
            return true;
        }
        return enumList.contains(value);
    }
}
