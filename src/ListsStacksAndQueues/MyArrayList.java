package ListsStacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by hrong on 2016/10/26.
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {
    AnyType[] theItems;
    int theSize;
    public static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity<theSize)return;
        AnyType[] oldItems = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < theSize; i++) {
            theItems[i] = oldItems[i];
        }
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public AnyType get(int idx) {
        if (idx<0||idx>=theSize)throw new IndexOutOfBoundsException();
        return theItems[idx];
    }
    public void set(int idx,AnyType data){
        if (idx<0||idx>=theSize)throw new IndexOutOfBoundsException();
        theItems[idx]=data;
    }

    private void trimSize() {
        ensureCapacity(theSize);
    }

    public boolean add(AnyType data) {
        add(theSize, data);
        return true;
    }

    public void add(int idx, AnyType data) {
        if (idx<0||idx>theSize)throw new IndexOutOfBoundsException();
        if (theItems.length == theSize) ensureCapacity(idx * 2 + 1);
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = data;
        theSize++;
    }

    public void addAll(Iterable<? extends AnyType> items) {
        for (AnyType data : items) {
            add(theSize, data);
        }
    }
    public AnyType remove(int idx){
        if (idx<0||idx>=theSize)throw new IndexOutOfBoundsException();
        AnyType oldData=theItems[idx];
        for (int i = idx; i < theSize; i++) {
            theItems[i]=theItems[i+1];
        }
        return oldData;
    }


    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator<AnyType>{
        AnyType[] theItems2=theItems;
        int current=0;
        @Override
        public boolean hasNext() {
            return (current<size());
        }

        @Override
        public AnyType next() {
            if (!hasNext())throw new NoSuchElementException();
            return theItems2[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
