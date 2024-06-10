package dataStructure;

class BinaryTree{
    public Node_Tree root=null;
    BinaryTree(int value){
        root=new Node_Tree(value);
        root.rightNode=null;
        root.leftNode=null;
    }

    /*
    * 查找数据
    * */

    public Node_Tree findKey(int value){
        Node_Tree current=root;
        while (true){
            if (value==current.value){
                return current;
            }else if (value< current.value){
                current= current.leftNode;
            }else if (value>current.value){
                current= current.rightNode;
            }
            if (current==null){
                return null;
            }
        }
    }

    /*
    * */
}

//创建一个结点
class Node_Tree{
    int value;
    Node_Tree rightNode;
    Node_Tree leftNode;

    public Node_Tree(int value) {
        this.value = value;
    }

    public void display(){
        System.out.println(this.value + "\t");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}