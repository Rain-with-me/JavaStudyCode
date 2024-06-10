package 设计模式.创建型模式.抽象工厂;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/3/29 11:13
 **/
public class FactoryProducer {
    private static String COLOR="COLOR";
    private static String SHAPE="SHAPE";
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase(SHAPE)){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase(COLOR)){
            return new ColorFactory();
        }
        return null;
    }
}
