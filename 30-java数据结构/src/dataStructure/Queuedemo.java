package dataStructure;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Queuedemo {
    @Test
    public void test1(){
        Queue<Integer> queue = new LinkedList<>();
//        添加元素
        queue.offer(2);
        queue.offer(1);
        queue.offer(6);
        for (int q:queue){
            System.out.print(q+" ");
        }
        System.out.println("====");
        /*取出第一个元素*/
        System.out.println("poll="+queue.poll());
        for (int q:queue){
            System.out.print(q+" ");
        }
        System.out.println("===");
        /*检索但不删除此队列的头部。 此方法与peek不同之处仅在于，如果此队列为空，它会引发异常*/
        System.out.println("element="+queue.element());
        for (int q:queue){
            System.out.print(q+" ");
        }
        /*检索但不删除此队列的头部，如果此队列为空，则返回null */
        System.out.println("peek="+queue.peek());
    }
}
