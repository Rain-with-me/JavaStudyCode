package com.lu.strategy.service;

import com.lu.strategy.utils.FileTypeResolveEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * @Author: 雨同我
 * @Description: 如何使用呢？我们借助spring的生命周期，
 * 使用ApplicationContextAware接口，
 * 把对用的策略，初始化到map里面。然后对外提供resolveFile方法即可。
 **/
@Component
public class StrategyUseService implements ApplicationContextAware {

    private Map<FileTypeResolveEnum,IFileStrategy> map=new ConcurrentHashMap();

//    把不同的策略放入map
//    com.lu.strategy.service.impl.DefaultFileResolve@4b4dd216----File_DEFAULT_RESOLVE
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IFileStrategy> tempMap = applicationContext.getBeansOfType(IFileStrategy.class);
//        tempMap.values().forEach(o->{
//            System.out.println(o+"----"+o.gainFileType());
//        });
        tempMap.values().forEach(o->{
            map.put(o.gainFileType(),o);
        });
    }

    /**
     * @Description:  对外处理的接口
    */
    public void resolveFile(FileTypeResolveEnum fileTypeResolveEnum, Object objectParam) {
        IFileStrategy iFileStrategy = map.get(fileTypeResolveEnum);
        if (iFileStrategy != null) {
            iFileStrategy.resolve(objectParam);
        }
    }
}
