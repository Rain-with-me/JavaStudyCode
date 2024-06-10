package dataStructure.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/23 11:21
 */
@SuppressWarnings("all")
public class LinkBiTree<E> implements IBiTree<E>{

    private TreeNode<E> head;

//    构造二叉树
    @Override
    public TreeNode<E> create(E val, TreeNode<E> l, TreeNode<E> r) {
        TreeNode<E> temp = new TreeNode<>(val, l, r);
        head=temp;
        return temp;
    }

//    设置val为p的左子树
    @Override
    public void insertL(E val, TreeNode<E> p) {
        TreeNode<E> temp = new TreeNode<>(val, null, null);
        temp.setLeftNode(p.getLeftNode());
        p.setLeftNode(temp);
    }

//    设置val为p的右子树
    @Override
    public void insertR(E val, TreeNode<E> p) {
        TreeNode<E> temp = new TreeNode<>(val, null, null);
        temp.setRightNode(p.getRightNode());
        p.setRightNode(temp);
    }

    @Override
    public TreeNode<E> deleteL(TreeNode<E> p) {
        p.setLeftNode(null);
        return p;
    }

    @Override
    public TreeNode<E> deleteR(TreeNode<E> p) {
        p.setRightNode(null);
        return p;
    }
/**
   * @description:  这里是使用递归去寻找，开始我还没有想到，本来想用栈去找的
   *  * @param root
    * @param value
   * @return: dataStructure.二叉树.TreeNode<E>
   * @author: 鲁子哥的每一天
   * @time: 2022/3/23 11:35
 */

    @Override
    public Boolean search(TreeNode<E> root, E value) {
        TreeNode temp=root;
        if (temp==null){
           return false;
        }
        if (temp.getData().equals(value)){
            return true;
        }
        if (temp.getLeftNode()!=null){
            return search(temp.getLeftNode(),value);
        }
        if (temp.getRightNode()!=null){
            return search(temp.getRightNode(),value);
        }
        return false;
    }

    @Override
    public void traverse(TreeNode<E> root) {
        // 根结点为空
        if (root == null) {
            return;
        }
        // 设置一个队列保存层序遍历的结点
        Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
        // 根结点入队
        q.offer(root);
        // 队列非空，结点没有处理完
        while (!q.isEmpty()) {
            // 结点出队
            TreeNode<E> tmp = q.poll();
            // 处理当前结点
            System.out.print(tmp.getData() + " ");
            // 将当前结点的左孩子结点入队
            if (tmp.getLeftNode() != null) {
                q.offer(tmp.getLeftNode());
            }
            if (tmp.getRightNode() != null) {
                // 将当前结点的右孩子结点入队
                q.offer(tmp.getRightNode());
            }
        }
    }
}
