package 设计模式.创建型模式.抽象工厂.impl;

import 设计模式.创建型模式.抽象工厂.Color;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 10:55
 **/
public class GreenColorImpl implements Color {
    @Override
    public void fill() {
        System.out.println("green");
    }
}
