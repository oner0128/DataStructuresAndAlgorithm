package ListsStacksAndQueues;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by hrong on 2016/10/27.
 */
public class E18_MyLinkedList<T> {
    int theSize=0;
    int modCount=0;
    private static class Node<T>{
        Node<T> prev,next;
        T data;

        public Node(Node<T> prev, Node<T> next, T data) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    public E18_MyLinkedList() {
        doClear();
    }

    private void doClear() {
        theSize=0;
        modCount=0;
    }
    public void clear(){
        doClear();
    }
    public void add(T newItem){
        Node<T> newNode=new Node<>(null,null,newItem);
    }
}
