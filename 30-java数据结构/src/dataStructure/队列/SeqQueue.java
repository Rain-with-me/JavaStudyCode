package dataStructure.队列;

import java.lang.reflect.Array;

public class SeqQueue {
    public static void main(String[] args) {
        int N=5;
        SeqQueueDemo<Integer> queue = new SeqQueueDemo<>(Integer.class, N);
        for (int i=1;i<9;i++){
            queue.enQueue(i);
        }
        for (int i=0;i<N;i++){
            System.out.println(queue.deQueue());
        }
    }
}
class SeqQueueDemo<E>{
    private int maxSize;
    private int front;
    private int rear;
    private E[] data;

    public SeqQueueDemo(Class<E> type,int size) {
        this.maxSize=size;
        data= (E[]) Array.newInstance(type,size);
        front=-1;
        rear=-1;
    }
    public boolean isFull(){
        return (rear+1)%maxSize==front||front==-1&&rear==maxSize-1;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public boolean enQueue(E item){
        if (isFull()){
            return false;
        }
        rear=(rear+1)%maxSize;
        data[rear]=item;
        System.out.println("debug---加入数据--"+data[rear]);
        return true;
    }
    public E deQueue(){
        if (isEmpty()){
            return null;
        }
        front=(front+1)%maxSize;
        return data[front];
    }
}
