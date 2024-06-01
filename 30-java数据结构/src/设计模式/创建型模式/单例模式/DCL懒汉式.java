package 设计模式.创建型模式.单例模式;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DCL懒汉式 {

    private DCL懒汉式(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }
    private static volatile DCL懒汉式 param;

    private static DCL懒汉式 getInstance(){
        if (param==null) {
            synchronized (DCL懒汉式.class) {
                if (param == null) {
                    param = new DCL懒汉式();
                }
            }
        }
        return param;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        DCL懒汉式 instance = DCL懒汉式.getInstance();
        Constructor<DCL懒汉式> d = DCL懒汉式.class.getDeclaredConstructor(null);
        d.setAccessible(true);
        DCL懒汉式 dd = d.newInstance();

        DCL懒汉式 d1 = DCL懒汉式.class.newInstance();
        System.out.println(dd);
        System.out.println(instance);
        System.out.println(d1);
    }
}
