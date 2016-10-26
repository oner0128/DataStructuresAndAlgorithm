package ListsStacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by hrong on 2016/10/26.
 */
public class E11_singleLikedList<AnyType> implements Iterable<AnyType> {
    Node header;
    int theSize;

    public E11_singleLikedList() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        header.data = null;
        header.next = null;
    }

    public int size() {
        return theSize;
    }

    public void printList() {
        Iterator<AnyType> iterator = iterator();
        while (iterator.hasNext()) {
            AnyType data = iterator.next();
            System.out.println(data);
        }
    }

    public boolean contain(AnyType xdata) {
        Node<AnyType> node = header.next;
        for (int i = 0; i < theSize; i++) {
            if (node.data.equals(xdata)) return true;
        }
        return false;
    }

    public void containAndAdd(AnyType xdata) {
        Node<AnyType> node = header.next;
        for (int i = 0; i < theSize; i++) {
            if (node.data.equals(xdata)) {
               return;
            }
            node=node.next;
        }
        Node<AnyType> newNode = new Node<>(xdata, null);
        node.next = newNode;
    }
    public AnyType containAndRemove(AnyType xData){
        Node<AnyType> node = header.next;
        for (int i = 0; i < theSize; i++) {
            if (node.data.equals(xData)) {
                return remove(i);
            }
        }
        return null;
    }
    public AnyType remove(int idx){
        Node<AnyType> node = header;
        for (int i = 0; i < idx; i++) {
            node = node.next;
        }
        Node<AnyType> removeNode=node.next;
        AnyType data=removeNode.data;
        node.next=removeNode.next;
        return data;
    }

    public void add(AnyType x) {
        Node<AnyType> node = header.next;
        for (int i = 0; i < theSize; i++) {
            node = node.next;
        }
        Node<AnyType> newNode = new Node<>(x, null);
        node.next = newNode;
    }

    private Node<AnyType> getNode(int idx) {
        if (idx < 0 || idx >= theSize) throw new IndexOutOfBoundsException();
        Node<AnyType> node = header.next;
        for (int i = 0; i <= idx; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<AnyType> {
        AnyType data;
        Node next;

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }

    private class MyListIterator implements Iterator<AnyType> {
        int size = theSize;
        Node<AnyType> node = header;
        boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public AnyType next() {
            if (!hasNext()) throw new NoSuchElementException();
            AnyType data = node.data;
            node = node.next;
            okToRemove = true;
            return data;
        }

        @Override
        public void remove() {
            if (!okToRemove) throw new IllegalStateException();
            node.next=node.next.next;
            okToRemove=false;
        }
    }
}
