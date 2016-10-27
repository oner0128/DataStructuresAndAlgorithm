package ListsStacksAndQueues;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.regex.Matcher;

/**
 * Created by hrong on 2016/10/27.
 */
public class E33_singleQueueArray<AnyType> {
    private int front, rear;
    private int maxSize;
    private ArrayList<AnyType> elements;

    public E33_singleQueueArray(int s) {
        maxSize = s;
        front = rear = 0;
        elements = new ArrayList<>(s);
    }

    public E33_singleQueueArray() {
        this(101);
    }

    public void enQueue(AnyType anyType) {
        if (!full()) {
            if (elements.size() < maxSize)
                elements.add(anyType);
            else elements.set(rear, anyType);
        }
        rear = (rear + 1) % maxSize;
    }

    public AnyType deQueue() {
        AnyType anyType = null;
        if (!empty()) {
            anyType=elements.get(front);
            front=(front+1)%maxSize;
        }
        return anyType;
    }

    private boolean full() {
        return (rear + 1) % maxSize == front;
    }

    private boolean empty() {
        return front == rear;
    }
}
