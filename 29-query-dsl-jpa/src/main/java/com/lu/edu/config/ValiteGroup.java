package com.lu.edu.config;

import jakarta.validation.groups.Default;

/**
 * @Author: 雨同我
 * @Description:  这里需要继承Default，
 * 当然如果你的ValidGroup没有继承Default分组，那在代码属性上就需要加上@Validated(value = {ValidGroup.Crud.Create.class, Default.class}才能让email字段的校验生效。
 * @DateTime: 2023/11/27 11:11
 **/
public interface ValiteGroup extends Default {
    interface Crud extends ValiteGroup{
        interface Create extends Crud{

        }

        interface Update extends Crud{

        }

        interface Query extends Crud{

        }

        interface Delete extends Crud{

        }
    }
}
