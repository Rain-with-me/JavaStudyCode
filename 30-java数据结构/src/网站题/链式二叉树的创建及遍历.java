package 网站题;



/**
 * (第 6 题)题目描述：

 * 链式二叉树的创建及遍历
 * 描述：
 * 树的遍历有先序遍历、中序遍历和后序遍历。先序遍历的操作定义是先访问根结点，然后访问左子树，最后访问右子树。中序遍历的操作定义是先访问左子树，然后访问根，最后访问右子树。后序遍历的操作定义是先访问左子树，然后访问右子树，最后访问根。对于采用链式存储结构的二叉树操作中，创建二叉树通常采用先序次序方式输入二叉树中的结点的值，空格表示空树。对于如下的二叉树，我们可以通过如下输入“AE-F--H--”得到（ ‘-’表示空子树）。
 *
 *
 * 试根据输入创建对应的链式二叉树，并输入其先序、中序和后序遍历结果。
 * 输入：
 * 输入第一行为一个自然数n，表示用例个数
 * 接下来为n行字符串，每行用先序方式输入的要求创建的二叉树结点，’-’表示前一结点的子树为空子树。
 * 输出：
 * 对每个测试用例，分别用三行依次输出其先序、中序和后序遍历结果。
 * 样例输入：
 * 1
 * abdh---e-i--cf-j--gk---
 * 样例输出：
 * abdheicfjgk
 * hdbeiafjckg
 * hdiebjfkgca
 * @author: 鲁子哥的每一天
 * @time: 2022/5/2 20:04
 */

import java.util.Scanner;

public class 链式二叉树的创建及遍历 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        while (n-->0){
            String s=scanner.next();
            BinaryOrder binaryOrder = new BinaryOrder(s);
            BinaryPreNode head = binaryOrder.createBinary();
            binaryOrder.pre(head);
        }
    }
}

class BinaryOrder{
    char[] ch;
    int index=0;
    public BinaryOrder(String s) {
        this.ch = s.toCharArray();
    }

    public BinaryPreNode createBinary(){
        char t=ch[index++];
        BinaryPreNode binaryNode = new BinaryPreNode();
        if (t=='-'){
            binaryNode=null;
        }else {
            binaryNode.value=t;
            binaryNode.left=createBinary();
            binaryNode.right=createBinary();
        }
        return binaryNode;
    }

    public void pre(BinaryPreNode root){
        if (root==null){
            return;
        }else {
            System.out.print(root.value+" ");
            pre(root.left);
            pre(root.right);
        }
    }
}

class BinaryPreNode{
    char value;
    BinaryPreNode left;
    BinaryPreNode right;
}