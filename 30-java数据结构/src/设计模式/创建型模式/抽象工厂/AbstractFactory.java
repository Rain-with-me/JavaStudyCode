package 设计模式.创建型模式.抽象工厂;

public abstract class AbstractFactory {
   public abstract Color getColor(String type);
   public abstract Shape getShape(String type);
}