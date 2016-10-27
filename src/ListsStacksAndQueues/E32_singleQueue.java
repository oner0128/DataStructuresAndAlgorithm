package ListsStacksAndQueues;

import java.util.LinkedList;

/**
 * Created by hrong on 2016/10/27.
 */
public class E32_singleQueue<AnyType> {
    private Node<AnyType> front,rear;
    private class Node<AnyType>{
        Node<AnyType> next;
        AnyType data;

        public Node(Node<AnyType> next, AnyType data) {
            this.next = next;
            this.data = data;
        }
    }

    public E32_singleQueue(AnyType anyType) {
        enQueue(anyType);
    }

    public E32_singleQueue() {
        front=null;
        rear=null;
    }
    public void enQueue(AnyType anyType){
        Node<AnyType> node=new Node<>(null,anyType);
        if (rear!=null){
            rear=rear.next=node;
        }else {
            front=rear=node;
        }
    }
    public AnyType deQueue(){
        AnyType data=front.data;
        if (front.next==null)front=rear=null;//only 1 node
        else front=front.next;
        return data;
    }
}
