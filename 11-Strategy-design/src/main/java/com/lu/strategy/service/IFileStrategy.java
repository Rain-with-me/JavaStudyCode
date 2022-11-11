package com.lu.strategy.service;

import com.lu.strategy.utils.FileTypeResolveEnum;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/4 9:12
 **/
public interface IFileStrategy {

//    获取文件类型
    FileTypeResolveEnum gainFileType();

//    封装公共的算法
    void resolve(Object objectParam);
}
