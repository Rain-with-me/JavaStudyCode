package 设计模式.创建型模式.工厂模式.impl;

import 设计模式.创建型模式.工厂模式.Shape;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 10:12
 **/
public class Squareimpl implements Shape {
    @Override
    public void draw() {
        System.out.println("square");
    }
}
