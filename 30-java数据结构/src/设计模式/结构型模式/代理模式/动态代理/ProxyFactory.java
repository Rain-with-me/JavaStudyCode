package 设计模式.结构型模式.代理模式.动态代理;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/4/22 20:23
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyFactory(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                ,target.getClass().getInterfaces(),(Object proxy, Method method, Object[] args)->{
                    System.out.println("动态代理开始--------->");
                    Object returnVal = method.invoke(target, args);  //反射机制调用目标对象的方法
                    System.out.println("动态代理结束--------->");
                    return returnVal;
                });
    }
}

