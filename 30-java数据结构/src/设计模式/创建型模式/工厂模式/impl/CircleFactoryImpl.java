package 设计模式.创建型模式.工厂模式.impl;

import 设计模式.创建型模式.工厂模式.Shape;
import 设计模式.创建型模式.工厂模式.ShapeFactory;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 10:16
 **/
public class CircleFactoryImpl implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new CircleImpl();
    }
}
