package 设计模式.创建型模式.抽象工厂.impl;

import 设计模式.创建型模式.抽象工厂.Color;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 10:54
 **/
public class RedColorImpl implements Color {
    @Override
    public void fill() {
        System.out.println("red");
    }
}
