package 网站题;

import java.util.Scanner;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/5/7 9:49
 */
public class 链式线性表的插入 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Linked list = new Linked();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int m=scanner.nextInt();
        if (m>=1&&m<=n) {
            list.remove(m);
        }
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        if (x>=1&&x<=n){
            list.insert(x,y);
        }
        list.print();
    }
}
class Linked{
    LinkedNode head;
    int size=0;
    public void add(int data){
        if (head==null){
            head=new LinkedNode(data,null);
            size++;
        }else {
            LinkedNode current=head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=new LinkedNode(data,null);
            size++;
        }
    }

    public void insert(int index,int data){
        int count=0;
        if (index==1){
            LinkedNode temp = new LinkedNode(data, null);
            temp.next=head;
            head=temp;
            return;
        }
        LinkedNode current = head;
        while (current.next != null) {
            count++;
            if (count == index - 1) {
                LinkedNode temp = new LinkedNode(data, null);
                temp.next = current.next;
                current.next = temp;
                break;
            }
            current = current.next;
        }

    }

    public void remove(int index){
        LinkedNode current=head;
        if (index==1){
            head=current.next;
        }else {
            int count = 0;
            while (current.next != null) {
                count++;
                if (count == index - 1) {
                    break;
                }
                current = current.next;
            }
            current.next=current.next.next;
        }
    }

    public void print(){
        LinkedNode current=head;
        while (current!=null){
            if (current.next!=null) {
                System.out.print(current.value + " ");
            }else {
                System.out.print(current.value);
            }
            current=current.next;
        }
    }
}

class LinkedNode{
    int value;
    LinkedNode next;
    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }
}
