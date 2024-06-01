package dataStructure.二叉树.构建二叉树;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * @Author: 雨同我
 * @Description:
 * @DateTime: 2023/12/14 15:05
 **/
public class BuildTreeMain {
    public static void main(String[] args) {

    }

    /**
     * @Description: 中序遍历
     * @Author: 雨同我
     * @DateTime: 2023/12/14 15:10
     * @param: null:
     * @return:
    */

    public static <E> List<E> Mid_order_traversal(NormalTreeNode<E> node){
        Stack<NormalTreeNode<E>> stack=new Stack<>();
        List<E> list = new LinkedList<>();
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.add(node);
                node=node.getLeft();
            }
            NormalTreeNode<E> poll = stack.pop();
            list.add(poll.getValue());
            node=node.getRight();
        }
        return list;
    }

}


@Data
@AllArgsConstructor
class NormalTreeNode<E>{
    private E value;
    private NormalTreeNode<E> left;
    private NormalTreeNode<E> right;
}
