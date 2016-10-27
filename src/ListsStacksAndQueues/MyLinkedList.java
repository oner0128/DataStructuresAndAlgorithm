package ListsStacksAndQueues;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by hrong on 2016/10/24.
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    Node<AnyType> begin, end;
    int theSize = 0;
    int modCount = 0;


    protected static class Node<AnyType> {
        AnyType data;
        Node next;
        Node prev;

        public Node(AnyType data, Node<AnyType> pre, Node<AnyType> next) {
            this.prev = pre;
            this.data = data;
            this.next = next;
        }
    }

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        modCount = 0;
        begin = new Node<>(null, null, end);
        end = new Node<>(null, begin, null);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    protected Node<AnyType> getNode(int index) {
        return getNode(index, 0, theSize - 1);
    }

    protected Node<AnyType> getNode(int index, int lower, int upper) {
        if (lower < 0 || upper > theSize) throw new IndexOutOfBoundsException();
        Node<AnyType> node;
        if (index < theSize / 2) {
            node = begin.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            node = end;
            for (int i = theSize; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    protected int getNodeIndex(AnyType anyType) {
        Node<AnyType> node = begin.next;
        for (int i = 0; i < theSize; i++) {
            if (anyType.equals(node.data)) return i;
            node = node.next;
        }
        return -1;
    }
    protected int getNodeIndex(Node<AnyType> newNode) {
        Node<AnyType> node = begin.next;
        for (int i = 0; i < theSize; i++) {
            if (newNode.equals(node)) return i;
            node = node.next;
        }
        return -1;
    }

    public AnyType get(int index) {
        return getNode(index).data;
    }

    public boolean add(AnyType data) {
        add(theSize, data);
        return true;
    }

    public boolean add(int index, AnyType data) {
        if (index == 0) {
            addBefore(data);
        } else if (index == theSize) {
            addEnd(data);
        } else {
            Node<AnyType> node = getNode(index);
            Node<AnyType> newNode = new Node<>(data, node.prev, node);
            node.prev.next = newNode;
            node.prev = newNode;
        }
        modCount++;
        theSize++;
        return true;
    }
    public boolean addFirst(AnyType anyType){
        return add(0,anyType);
    }
    public boolean addLast(AnyType anyType){
        return add(anyType);
    }
    public AnyType removeFirst(){
        return remove(0);
    }
    public AnyType removeLast(){
        return remove(size()-1);
    }
    public AnyType getFirst(){
        return get(0);
    }
    public AnyType getLast(){
        return get(size()-1);
    }
    private void addEnd(AnyType data) {
        Node<AnyType> newNode = new Node<>(data, end.prev, end);
        end.prev.next = newNode;
        end.prev = newNode;
    }

    private void addBefore(AnyType data) {
        Node<AnyType> newNode = new Node<>(data, begin, begin.next);
        begin.next.prev = newNode;
        begin.next = newNode;
    }

    protected AnyType remove(Node<AnyType> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        modCount--;
        theSize--;
        return node.data;
    }

    public AnyType remove(int n) {
        Node<AnyType> node = getNode(n);
        return remove(node);
    }

    public AnyType set(int index, AnyType anyType) {
        Node<AnyType> node = getNode(index);
        AnyType oldValue = anyType;
        node.data = anyType;
        return oldValue;
    }

    public boolean contains(AnyType anyType) {
        int index = getNodeIndex(anyType);
        if (index >= 0) return true;
        return false;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }

    private class MyLinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> node = begin;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return node != end;
        }

        @Override
        public AnyType next() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            if (!hasNext()) throw new NoSuchElementException();
            node = node.next;
            okToRemove = true;
            return node.data;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
            if (!okToRemove) throw new IllegalStateException();
            MyLinkedList.this.remove(node);
            expectedModCount++;
            okToRemove = false;
        }
    }
}
