package 设计模式.行为型模式.状态模式;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/5/13 20:28
 **/
@Setter
@Getter
public class Context<T> {
    T state;

    public Context(T state) {
        this.state = null;
    }
}
