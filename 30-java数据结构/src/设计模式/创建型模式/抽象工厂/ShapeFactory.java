package 设计模式.创建型模式.抽象工厂;

import 设计模式.创建型模式.抽象工厂.impl.CircleImpl;
import 设计模式.创建型模式.抽象工厂.impl.GreenColorImpl;
import 设计模式.创建型模式.抽象工厂.impl.RedColorImpl;
import 设计模式.创建型模式.抽象工厂.impl.Squareimpl;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 10:12
 **/
public class ShapeFactory extends AbstractFactory{
    private String SQUARE="SQUARE";
    private String CIRCLE="CIRCLE";

    @Override
    public Color getColor(String type) {
        return null;
    }

    @Override
    public Shape getShape(String type){
        if (type.equalsIgnoreCase(SQUARE)){
            return new Squareimpl();
        }else if (type.equalsIgnoreCase(CIRCLE)){
            return new CircleImpl();
        }
        return null;
    }
}
