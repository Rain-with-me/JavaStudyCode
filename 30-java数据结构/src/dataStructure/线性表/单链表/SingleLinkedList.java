package dataStructure.线性表.单链表;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/20 9:19
 */

public class SingleLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        SingleMethod<Integer> method = new SingleMethod<>();
        for (int i=0;i<3;i++){
            method.add(i);
        }
        method.list();
    }
}
/**
   * @description:  单链表的实现：
   * 1.设置头结点啊，用一个变量统计链表长度
   * 2.添加方法，增加，。。。。。
   *  * @param null
   * @return:
   * @author: 鲁子哥的每一天
   * @time: 2022/3/20 9:24
 */
class SingleMethod<E>{
    int size;
    SingleNode head;

    public SingleMethod() {
        size=0;
        head=null;
    }
    //添加方法
    public void add(E item){
        if (head==null){
            head=new SingleNode<E>(item,null);
        }else {
            SingleNode<E> current = head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=new SingleNode<E>(item,null);
        }
        size++;
    }

    //显示链表

    public void list(){
        SingleNode current=head;
        while (current!=null){
            System.out.println(current.value);
            current=current.next;
        }
    }

}

class SingleNode<E>{
    E value;
    SingleNode next;

    public SingleNode(E value, SingleNode next) {
        this.value = value;
        this.next = next;
    }
}
