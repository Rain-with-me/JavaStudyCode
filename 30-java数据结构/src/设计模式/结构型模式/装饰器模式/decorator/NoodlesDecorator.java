package 设计模式.结构型模式.装饰器模式.decorator;

import 设计模式.结构型模式.装饰器模式.INoodles;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/4/1 17:17
 **/
public abstract class NoodlesDecorator implements INoodles{
    INoodles iNoodles;

    public NoodlesDecorator(INoodles iNoodles) {
        this.iNoodles = iNoodles;
    }

    @Override
    public void cook() {
        if (iNoodles!=null){
            iNoodles.cook();
        }
    }
}
