package 设计模式.结构型模式.装饰器模式.impl;

import 设计模式.结构型模式.装饰器模式.INoodles;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/4/1 17:10
 **/
public class Noodles implements INoodles {
    @Override
    public void cook() {
        System.out.println("的面条");
    }

}
