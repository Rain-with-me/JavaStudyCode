package com.lu.strategy.service.impl;

import com.lu.strategy.service.IFileStrategy;
import com.lu.strategy.utils.FileTypeResolveEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2022/11/4 9:20
 **/
@Component
@Slf4j
public class BFileResolve implements IFileStrategy {
    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_B_RESOLVE;
    }

    @Override
    public void resolve(Object objectParam) {
        log.info("B策略模式----文件------"+objectParam);
    }
}
