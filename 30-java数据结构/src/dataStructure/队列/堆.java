package dataStructure.队列;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2024/2/23 15:38
 **/
public class 堆 {
    public static void main(String[] args) {
        minHeap();
    }
    public static void minHeap(){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Insert elements into the MinHeap
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(1);
        minHeap.add(6);
        System.out.println(minHeap.peek());
        System.out.println(minHeap);
    }
}
