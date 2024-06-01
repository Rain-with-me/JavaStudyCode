package dataStructure.二叉树;



/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/23 11:05
 */

public class TreeNode<E>{
    private E data;
    private TreeNode<E> leftNode;
    private TreeNode<E> rightNode;

    public TreeNode(E data, TreeNode<E> leftNode, TreeNode<E> rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
