package 设计模式.结构型模式.装饰器模式.decorator;

import 设计模式.结构型模式.装饰器模式.INoodles;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/4/1 17:21
 **/
public class EggDecorator extends NoodlesDecorator{
    public EggDecorator(INoodles iNoodles) {
        super(iNoodles);
    }

    @Override
    public void cook() {
        System.out.println("加荷包蛋");
        super.cook();
    }
}
