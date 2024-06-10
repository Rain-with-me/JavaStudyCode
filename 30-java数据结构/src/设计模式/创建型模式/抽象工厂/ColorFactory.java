package 设计模式.创建型模式.抽象工厂;

import 设计模式.创建型模式.抽象工厂.impl.GreenColorImpl;
import 设计模式.创建型模式.抽象工厂.impl.RedColorImpl;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 10:55
 **/
public class ColorFactory extends AbstractFactory{
    private String RED="RED";
    private String GREEN="GREEN";
    @Override
    public Color getColor(String type){
        if (type.equalsIgnoreCase(RED)){
            return new RedColorImpl();
        }else if (type.equalsIgnoreCase(GREEN)){
            return new GreenColorImpl();
        }
        return null;
    }

    @Override
    public Shape getShape(String type) {
        return null;
    }
}
