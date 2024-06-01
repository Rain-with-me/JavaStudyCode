package 设计模式.创建型模式.单例模式;

public class 饿汉式 {
//    浪费空间
    private 饿汉式(){

    }
    private static 饿汉式 param=new 饿汉式();

    public static 饿汉式 getInstance(){
        return param;
    }
}
