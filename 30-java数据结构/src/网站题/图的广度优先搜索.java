package 网站题;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/5/5 11:37
 */


import java.io.BufferedInputStream;
import java.util.*;

/**
 * @description:  vis 判断他是否输出，map是矩阵
 * @author: 鲁子哥的每一天
 * @time: 2022/5/2 20:04
 */

import java.util.*;


public class 图的广度优先搜索 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        String s=scanner.next();
        int[][] a=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j]=scanner.nextInt();
            }
        }
        char target=scanner.next().charAt(0);
        QueueOperate list =new QueueOperate();
        list.offer(target);
        int in=0;
        boolean[] vis=new boolean[n];
        while (!list.isEmpty()){
            char[] ch=new char[26];
            Character poll = list.poll();
            System.out.print(poll+" ");
            vis[s.indexOf(poll)]=true;
            int index=s.indexOf(poll);
            for (int i = 0; i < n; i++) {
                if (a[index][i]>0){
                    ch[s.charAt(i)-'A']=s.charAt(i);
                }
            }
            for (int i = 0; i < 26; i++) {
                if (ch[i]>0&&vis[s.indexOf(ch[i])]==false&&!list.contains(ch[i])){
                    list.offer(ch[i]);
                }
            }
        }
    }
}
class QueueNode{
    char value;
    QueueNode next;

    public QueueNode(char value) {
        this.value = value;
    }
}
class QueueOperate{
    QueueNode head;
    public void offer(char data){
        if (head==null){
            head=new QueueNode(data);
        }else {
            QueueNode current=head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=new QueueNode(data);
        }
    }
    public char poll(){
        QueueNode temp=head;
        if (head.next!=null) {
            head = head.next;
        }else {
            head=null;
        }
        return temp.value;
    }
    public boolean isEmpty(){
        if(head!=null) {
            return false;
        }
        return true;
    }
    public boolean contains(char target){
        QueueNode current=head;
        while (current!=null){
            if (current.value==target){
                return true;
            }
            current=current.next;
        }
        return false;
    }
}