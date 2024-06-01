package 设计模式.行为型模式.状态模式;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/5/13 20:27
 **/
public interface StateTemplate<T> {
    void doAction(Context<T> context);
}
