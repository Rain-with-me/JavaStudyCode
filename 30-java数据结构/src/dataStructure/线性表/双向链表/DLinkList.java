package dataStructure.线性表.双向链表;

/**
 * @description:
 * @author: HaHa
 * @time: 2022/4/13 11:28
 */
public class DLinkList {
    public static void main(String[] args) {
        DlList<Integer> list = new DlList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.listAll();
    }
}

class DlList<E>{
    int size;
    DLNode head;

    public DlList() {
        head=null;
    }

    public boolean add(E data){
        DLNode<E> newNode = new DLNode<E>(data, null, null);
        if (isEmpty()){
            head=newNode;
            size++;
            return true;
        }
        DLNode current=head;
        while (current.next!=null){
            current=current.next;
        }
        current.next=newNode;
        newNode.prev=current;
        newNode.next=null;
        size++;
        return true;
    }

    public boolean remove(int index){
        if (isEmpty()||index<0||index>=size){
            return false;
        }
        DLNode current=head;
        if (index==0){
            head=current.next;
            size--;
            return true;
        }else {
            int i=0;
            while (i<index-1){
                current=current.next;
                i++;
            }
            current.next=current.next.next;
            current.next.next.prev=current;
            return true;
        }
    }

    public void listAll(){
        DLNode current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
        System.out.println("size--->"+size);
    }

    public boolean isEmpty(){
        return size==0||head==null;
    }
}
class DLNode<E>{
    E data;
    DLNode prev;
    DLNode next;

    public DLNode(E data, DLNode prev, DLNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}