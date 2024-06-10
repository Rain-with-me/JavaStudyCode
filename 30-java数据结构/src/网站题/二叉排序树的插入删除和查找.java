package 网站题;

import java.util.Scanner;

public class 二叉排序树的插入删除和查找 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        int n=scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int temp=scanner.nextInt();
//            这里是关键
            binaryTree.head=binaryTree.createTree(binaryTree.head,new BinaryNode(temp));
        }
        while (scanner.hasNext()){
            String s=scanner.next();
            if (s.equals("exit")){
                break;
            }else if (s.equals("pre")){
                binaryTree.preOrder(binaryTree.head);
                System.out.println();
            }else if (s.equals("in")){
                binaryTree.inOrder(binaryTree.head);
                System.out.println();
            }else if (s.equals("post")) {
                binaryTree.backOrder(binaryTree.head);
                System.out.println();
            }else if (s.equals("delete")){
                int data=scanner.nextInt();
                boolean flag = binaryTree.remove(data, binaryTree.head);
                if (flag){
                    System.out.println("TURE");
                }else {
                    System.out.println("FALSE");
                }
            }else if (s.equals("search")){
                int data=scanner.nextInt();
                boolean search = binaryTree.search(data, binaryTree.head);
                if (search){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }else if (s.equals("insert")){
                int data=scanner.nextInt();
                binaryTree.createTree(binaryTree.head,new BinaryNode(data));
            }
        }
    }
}
class BinaryTree{
    BinaryNode head;

    //    根据权值大小进行创建
    public BinaryNode createTree(BinaryNode root,BinaryNode data){
        if (root==null){
            return new BinaryNode(data.value);
        }else if (root.value>data.value){
            root.left=createTree(root.left,data);
        }else {
            root.right=createTree(root.right,data);
        }
        return root;
    }

    //    删除
    public boolean remove(int data,BinaryNode root){
        if (root==null){
            return false;
        }else if (root.left!=null&&root.left.value==data){
            if (root.left.left!=null){
                root.left=root.left.left;
                return true;
            }else {
                root.left=null;
            }
            return true;
        }else if (root.right!=null&&root.right.value==data){
            if (root.right.right!=null){
                root.right=root.right.right;
                return true;
            }else {
                root.right=null;
            }
            return true;
        }else if (data>root.value){
            return remove(data,root.right);
        }else if (data<root.value){
            return remove(data,root.left);
        }
        return false;
    }

    //    查找
    public boolean search(int data,BinaryNode root){
        if (root==null){
            return false;
        }else if (data>root.value){
            return search(data,root.right);
        }else if (data<root.value){
            return search(data,root.left);
        }else if (data==root.value){
            return true;
        }
        return false;
    }

    //    遍历 先中后序
    public void preOrder(BinaryNode root){
        if (root==null){
            return;
        }
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(BinaryNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);
    }
    public void backOrder(BinaryNode root){
        if (root==null){
            return;
        }
        backOrder(root.left);
        backOrder(root.right);
        System.out.print(root.value+" ");
    }


}


class BinaryNode{
    int value;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int value) {
        this.value = value;
    }
}
