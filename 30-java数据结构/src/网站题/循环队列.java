package 网站题;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/5/6 15:20
 */
public class 循环队列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        CirQueue<Integer> queue = new CirQueue<>(Integer.class, n);
        int m=scanner.nextInt();
        while (m-->0){
            String s=scanner.next();
            if (s.equals("in")){
                int t=scanner.nextInt();
                queue.offer(t);
            }else {
                queue.poll();
            }
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }
    public static class CirQueue<E>{
        int maxSize;
        E[] data;
        int front;
        int rear;
        public CirQueue(Class<E> type,int size){
            front=rear=0;
            maxSize=size;
            data=(E[])Array.newInstance(type,size);
        }
        public boolean offer(E value){
            if (!isFull()){
                rear=(rear+1)%maxSize;
                data[rear]=value;
                return true;
            }
            return false;
        }
        public E poll(){
            if (!isEmpty()){
                front=(front+1)%maxSize;
                return data[front];
            }else {
                return null;
            }
        }
        public boolean isEmpty(){
            return rear==front;
        }
        public boolean isFull(){
            return (rear+1)%maxSize==front;
        }
    }
}
