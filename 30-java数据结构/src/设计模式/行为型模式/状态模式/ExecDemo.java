package 设计模式.行为型模式.状态模式;

import 设计模式.行为型模式.状态模式.impl.StartState;
import 设计模式.行为型模式.状态模式.impl.StopState;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/5/13 20:29
 **/
public class ExecDemo {
    public static void main(String[] args) {
        Context<String> start = new Context<String>("start");
        Context<String> end = new Context<String>("end");
        StateTemplate<String> startState = new StartState();
        StateTemplate<String> stopState = new StopState();
        startState.doAction(start);
        stopState.doAction(end);

    }
}
