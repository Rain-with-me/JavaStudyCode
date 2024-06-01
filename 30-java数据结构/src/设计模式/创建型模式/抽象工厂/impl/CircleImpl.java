package 设计模式.创建型模式.抽象工厂.impl;

import 设计模式.创建型模式.抽象工厂.Shape;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 10:11
 **/
public class CircleImpl implements Shape {
    @Override
    public void draw() {
        System.out.println("circle");
    }
}
