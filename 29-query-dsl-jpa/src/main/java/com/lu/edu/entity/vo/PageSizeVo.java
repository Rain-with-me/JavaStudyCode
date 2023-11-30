package com.lu.edu.entity.vo;

import com.lu.edu.violate.EnumString;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/11/10 16:04
 **/
@Data
@EnumString(value = {"F","M"},message = "必须为F或者M")
public class PageSizeVo {


    @Range(min = 0,max = Integer.MAX_VALUE,message = "分页必填项")
    private Integer pageNum;
    @Range(min=0,max = Integer.MAX_VALUE,message = "分页必填项")
    private Integer pageSize;

    @EnumString(message = "必须为F或者M",value = {"F","M"})
    private String sex;
}
