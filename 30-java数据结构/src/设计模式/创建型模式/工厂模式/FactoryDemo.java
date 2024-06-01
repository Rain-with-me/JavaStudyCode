package 设计模式.创建型模式.工厂模式;

import 设计模式.创建型模式.工厂模式.impl.SquareFactoryImpl;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 10:16
 **/
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new SquareFactoryImpl();
        Shape shape = factory.createShape();
        shape.draw();
    }
}
