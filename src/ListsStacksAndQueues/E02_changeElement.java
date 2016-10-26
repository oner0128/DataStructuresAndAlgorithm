package ListsStacksAndQueues;

/**
 * Created by hrong on 2016/10/24.
 */
public class E02_changeElement {
    private static class Node<AnyType>{
        AnyType data;
        Node next;
        Node prev;

        public Node(Node pre, AnyType data, Node next) {
            this.prev = pre;
            this.data = data;
            this.next = next;
        }
    }
    //改变单链表结构交换两个节点数据
    public static void singleLinkedList(Node beforep){
        Node p,afterP;
        //按原先顺序链接   //beforeP---p---afterP
        p=beforep.next;
        afterP=p.next;
        //p和afterP交换       beforeP---afterP---p
        p.next=afterP.next;
        beforep.next=afterP;
        afterP.next=p;
    }
    //改变双链表结构交换两个节点数据
    public static void doubleLinkedList(Node p){
        Node afterP;
        //按原先顺序链接   //beforeP---p---afterP
        afterP=p.next;
        //p和afterP交换     beforeP---afterP---p
        p.next=afterP.next;
        afterP.prev =p.prev;
        //beforeP.next=afterP
        p.prev.next=afterP;
        //将P.pre从before换成after
        p.prev =afterP;
        afterP.next=p;
        //将afterP后一节点的pre从after换成p
        p.next.prev =p;
    }
}
