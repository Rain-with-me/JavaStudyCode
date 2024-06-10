package dataStructure.二叉树;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/3/23 11:45
 */
public class IBMain {
    public static void main(String[] args) {
        LinkBiTree<String> biTree = new LinkBiTree<>();
        TreeNode<String> right = new TreeNode<String>("B",null,null);
        TreeNode<String> left = new TreeNode<String>("C",null,null);
        TreeNode<String> node = biTree.create("A", right, left);
        biTree.insertL("B",node);

        System.out.println("-----------------------------");
        System.out.println("判断是否含有这个结点");
        Boolean b = biTree.search(node, "B");
        System.out.println(b);

        System.out.println("-----------------------------");
        System.out.println("层序遍历");
        biTree.traverse(node);
    }
}
