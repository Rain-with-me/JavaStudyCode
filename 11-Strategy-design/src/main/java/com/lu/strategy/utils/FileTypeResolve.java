package com.lu.strategy.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum FileTypeResolve {

    MAN("man","男"),
    WOMAN("woman","女");
    private String sexCode;
    private String sexName;
}
