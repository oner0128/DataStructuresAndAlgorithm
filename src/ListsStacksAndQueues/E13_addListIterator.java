package ListsStacksAndQueues;

import java.util.Calendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by hrong on 2016/10/26.
 */
public class E13_addListIterator<AnyType> extends MyArrayList<AnyType> {
    public java.util.ListIterator<AnyType> listIterator(){
        return new ListIterator();
    }
    private class ListIterator implements java.util.ListIterator<AnyType> {
        int theSize = E13_addListIterator.this.theSize;
        AnyType[] theItems = E13_addListIterator.this.theItems;
        int current = 0;
        boolean backwards=false;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()) throw new NoSuchElementException();
            backwards=false;
            return theItems[current++];
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public AnyType previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            backwards=true;
            return theItems[--current];
        }

        @Override
        public int nextIndex() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override
        public void remove() {
            if (backwards)E13_addListIterator.this.remove(current--);
            else E13_addListIterator.this.remove(--current);
        }

        @Override
        public void set(AnyType anyType) {
            E13_addListIterator.this.set(current,anyType);
        }

        @Override
        public void add(AnyType anyType) {
            E13_addListIterator.this.add(current,anyType);
        }
    }
}
