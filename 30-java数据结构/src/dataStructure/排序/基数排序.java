package dataStructure.排序;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:       为什么要开10个结点空间？
 *                     为什么后面data数组迭代时需要用链表一直往后迭代
 *                     解答在后面
 * @author: HaHa
 * @time: 2022/4/20 10:19
 */

public class 基数排序 {
    public static void main(String[] args) {
        long t1=System.currentTimeMillis();
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int[] a={13,444,789,24,11};
        int[] sort = radixSort(a);
        System.out.println(Arrays.toString(sort));
        System.out.println(System.currentTimeMillis()-t1);
    }

    private static int[] radixSort(int[] data) {
        RadixNode[] head=new RadixNode[10];
        RadixNode current,nextNode;
        int max=0,length=0;
        for (int temp : data) {
            max=Math.max(temp,max);
        }
        length=String.valueOf(max).length();
        int power=0;
        for (int i = 0; i < length; i++) {
            if (i==0){
                power=1;
            }else {
                power*=10;
            }
            for (int j = 0; j < 10; j++) {
                head[j]=new RadixNode();
            }
            for (int j = 0; j < data.length; j++) {
                int radix=data[j]/power-(data[j]/(power*10))*10;
                current=new RadixNode();
                current.data=data[j];
                current.next=null;
                nextNode=head[radix].next;
                if (nextNode==null){
                    head[radix].next=current;
                }else {
                    while (nextNode.next!=null){
                        nextNode=nextNode.next;
                    }
                    nextNode.next=current;
                }
                int l=0;
                for (int k = 0; k < 10; k++) {
                    nextNode=head[k].next;
                    while (nextNode!=null){
                        data[l]=nextNode.data;
//                        System.out.print(data[l]+" ");
                        l++;
                        nextNode=nextNode.next;
                    }
                }
//                System.out.println();
            }
        }
        return data;
    }


    public static class RadixNode{
        int data;
        RadixNode next;
    }
}
