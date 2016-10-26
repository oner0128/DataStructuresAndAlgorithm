package ListsStacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by hrong on 2016/10/26.
 */
public class E16_reverseIterator<AnyType> extends MyArrayList<AnyType>{
    public Iterator<AnyType> reverseIterator(){return new ArrayReverseIterator();}

    private class ArrayReverseIterator implements Iterator<AnyType> {
        AnyType[] theItems=E16_reverseIterator.this.theItems;
        int current=size()-1;
        @Override
        public boolean hasNext() {
            return current>0;
        }

        @Override
        public AnyType next() {   if (!hasNext())throw new NoSuchElementException();
            return theItems[current--];
        }

        @Override
        public void remove() {
            E16_reverseIterator.this.remove(--current);
        }
    }
}
