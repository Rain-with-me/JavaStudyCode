package com.lu.edu.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class CustomIdGenerator implements IdentifierGenerator {

    /** 
     * @Description: // 使用Hutool生成雪花算法ID
     * @Author: 雨同我
     * @DateTime: 2023/11/22 15:54
     * @param: null: 
     * @return: 
    */
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        return IdUtil.fastSimpleUUID();
        Snowflake snowflake = IdUtil.getSnowflake();
        return snowflake.nextIdStr();
    }
}
