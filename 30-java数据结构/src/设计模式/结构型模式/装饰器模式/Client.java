package 设计模式.结构型模式.装饰器模式;

import 设计模式.结构型模式.装饰器模式.decorator.BeefDecorator;
import 设计模式.结构型模式.装饰器模式.decorator.EggDecorator;
import 设计模式.结构型模式.装饰器模式.impl.Noodles;

/**
 * Created on 2020/3/19
 * Package com.design_pattern.decorator
 *
 */
public class Client {

    public static void main(String[] args) {
        INoodles noodles = new Noodles();
        INoodles eggDecorator = new EggDecorator(noodles);
        INoodles beefDecorator = new BeefDecorator(eggDecorator);
        beefDecorator.cook();
        System.out.println("************分割线**************");
        //咱是程序员，咱加一个蛋就行了
        INoodles noodles1 = new Noodles();
        INoodles noodles1WithEgg = new EggDecorator(noodles1);
        noodles1WithEgg.cook();
    }
}

