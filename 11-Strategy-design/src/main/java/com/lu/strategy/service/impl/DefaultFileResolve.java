package com.lu.strategy.service.impl;

import com.lu.strategy.service.IFileStrategy;
import com.lu.strategy.utils.FileTypeResolve;
import com.lu.strategy.utils.FileTypeResolveEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DefaultFileResolve implements IFileStrategy {

    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_DEFAULT_RESOLVE;
    }

    @Override
    public void resolve(Object objectparam) {
      log.info("默认类型解析文件，参数：{}",objectparam);
      //默认类型解析具体逻辑
        FileTypeResolve.MAN.getSexCode();
    }
}