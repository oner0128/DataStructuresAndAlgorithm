package priorityQueues;

import java.util.NoSuchElementException;

/**
 * Created by hrong on 2016/12/6.
 */
public class BinaryHeap<AnyTpye extends Comparable<? super AnyTpye>> {
    private AnyTpye[] array;
    private int currentSize;
    private static int DEFAULT_CAPACITY = 10;

    public BinaryHeap(int capacity) {
        DEFAULT_CAPACITY = capacity;
        currentSize = capacity;
    }
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(AnyTpye[] items) {
        currentSize = items.length;
        array= (AnyTpye[]) new Comparable[(currentSize+2)*11/10];
        int i=1;
        for (AnyTpye item:items){
            array[i++]=item;
        }
        builtHeap();
    }

    private void builtHeap() {
        for (int i = currentSize/2; i >0; i--) {
            percolateDown(i);
        }
    }

    public void insert(AnyTpye x) {
        if (currentSize == array.length - 1) {
            enLargeArray(array.length * 2 - 1);
        }
        //上滤percolate up
        int hole = ++currentSize;
        for (; hole > 0 && x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public AnyTpye findMin() {
        return array[1];
    }

    public AnyTpye deleteMin() {
        if (isEmpty()) throw new NoSuchElementException();
        AnyTpye tmp = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return tmp;
    }

    private void percolateDown(int hole) {
        AnyTpye tmp = array[hole];
        //下滤percolate down
        for (int child; hole <= array.length; hole *= 2) {
            child = hole * 2;
            if (child != currentSize && array[child].compareTo(array[child + 1]) > 0)
                child++;
            if (tmp.compareTo(array[child]) > 0)
                array[hole] = array[hole * 2];
            else break;
        }
        array[hole] = tmp;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    private void enLargeArray(int newSize) {
        AnyTpye[] old = array;
        array = (AnyTpye[]) new Object[newSize];
        for (int i = 0; i < currentSize; i++) {
            array[i] = old[i];
        }
    }

}
