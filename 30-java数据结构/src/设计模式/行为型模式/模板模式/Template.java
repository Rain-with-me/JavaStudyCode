package 设计模式.行为型模式.模板模式;

/**
 * @Author: 雨同我
 * @Description: 定义一个操作中的算法的骨架，
 * 而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * @DateTime: 2023/10/30 16:57
 **/
public abstract class Template {
//    这是模板方法
    public final void TemplateTest(){
        exec1();
        exec2();
    }
    public abstract void exec1();
    public abstract void exec2();
}
