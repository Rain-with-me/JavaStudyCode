package dataStructure.线性表.数组线性表;

import dataStructure.线性表.数组线性表.LinarList;

import java.lang.reflect.Array;

@SuppressWarnings("all")
public class SeqList<E> implements LinarList<E> {

    private int maxSize;
    private E[] data;
    private int size;

    public SeqList(Class<E> type,int maxSize) {
        this.maxSize = maxSize;
//        this.data= (E[]) new Object[maxSize];
        data= (E[])Array.newInstance(type,maxSize);
        size=0;
    }

    @Override
    public boolean add(E item) {
        if (size<maxSize){
            data[size]=item;
            size++;
            return true;
        }else {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

//    插入
    @Override
    public boolean add(int i, E item) {
        if (i>size||i<0){
            throw new IndexOutOfBoundsException("数组越界");
        }
        if (size<maxSize){
            for (int j=size;j>=i;j--){
                data[j+1]=data[j];
            }
            data[i]=item;
            size++;
            return true;
        }
        return false;
    }

//    打印
    @Override
    public void print() {
        System.out.println("数据打印");
        for (int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }
    }

}
