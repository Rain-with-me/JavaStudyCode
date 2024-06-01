package 网站题;

import java.util.Scanner;

public class 括号匹配 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s=scanner.next();
            System.out.println(dfs(s));
        }
    }

    private static boolean dfs(String s) {
        CustomStack<Character> queue = new CustomStack<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            System.out.println("==="+t);
            if (s.charAt(i) == '[' || s.charAt(i) == '(') {
                queue.add(s.charAt(i));
            } else if (t == ')') {
                if (queue.isEmpty()){
                    return false;
                }
                char poll = queue.pop();
                System.out.println(poll+"----");
                if (poll != '(') {
                    return false;
                }
            } else if (t == ']') {
                if (queue.isEmpty()){
                    return false;
                }
                char poll = queue.pop();
                System.out.println(poll+"----");
                if (poll != '[') {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }
}
class CustomStack<E>{
    SNode head;
    public void add(E data){
        SNode<E> node = new SNode<E>(data);
        if (!isEmpty()){
            node.next=head;
        }
        head=node;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public E pop(){
        E t=null;
        if (!isEmpty()){
            t= (E) head.data;
            head=head.next;
        }
        return t;
    }
}
class SNode<E>{
    E data;
    SNode next;

    public SNode(E data) {
        this.data = data;
    }
}