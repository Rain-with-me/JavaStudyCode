package dataStructure;

/*
创建单链表和遍历
*
*/

public class demo1_单链表 {
    public static void main(String[] args) {
        Node node1 = new Node(2, "宋江", "及时雨");
        Node node2 = new Node(3, "李奎", "heixu");
        Node node3 = new Node(4, "李白", "凤求凰");
        SingleLinkedList l = new SingleLinkedList();
        SingleLinkedList l2 = new SingleLinkedList();
        SingleLinkedList l3 = new SingleLinkedList();
//        普通添加
        l.add(node1);
        l.add(node2);
        l.add(node3);
        l.list();
        l3=l;
//        l3.list();
//        l.add(node3);

//      实现排序

//        l.addOrd(node3);
//        l.addOrd(node1);
//        l.addOrd(node2);
//        l.list();

//        修改结点
//        l.list();
//        l.update(new Node(2,"王八蛋","怎么这么坑"));
//        System.out.println("修改后");
//        l.list();
    }
}

class SingleLinkedList{
//    创建头结点,不能动，不存放具体数据

    private Node head=new Node(0,"","");
    public void add(Node node){
        Node temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }

    /*
    * 按照顺序实现排序，用temp去查找，
    */

    public void addOrd(Node node){
        Node temp=head;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.id>node.id){
                break;
            }else if (temp.next.id==node.id){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag==true){
            System.out.println("已经存在这个结点");
        }else {
            node.next=temp.next;
            temp.next=node;
        }

    }

//    修改结点

    public void update(Node new_1){
        if (head.next==null){
            System.out.println("当前为空链表");
            return;
        }
        Node temp=head;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.id==new_1.id){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag==true){
            temp.name= new_1.name;
            temp.nickname= new_1.nickname;
        }else {
            System.out.println("该结点不存在");
        }
    }



//    显示数组

    public void list(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node temp=head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }
}

class Node{
    public int id;
    public String name;
    public String nickname;
    public Node next;

    public Node(int id,String name,String nickname){
        this.id=id;
        this.name=name;
        this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
