package ListsStacksAndQueues;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by hrong on 2016/10/26.
 */
public class E14_addLIstIteratorToLinkedList<AnyTylpe> extends MyLinkedList<AnyTylpe> {
    public ListIterator<AnyTylpe> listIterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements ListIterator<AnyTylpe> {
        private E14_addLIstIteratorToLinkedList.Node<AnyTylpe> currentNode = begin;
        private int theSize = E14_addLIstIteratorToLinkedList.this.theSize;
        ;
        private int expectedModCount = modCount;
        ;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return currentNode != end;
        }

        @Override
        public AnyTylpe next() {
            if (!hasNext()) throw new NoSuchElementException();
            if (expectedModCount != modCount) throw new IllegalStateException();
            AnyTylpe data = currentNode.data;
            currentNode = currentNode.next;
            okToRemove = true;

            return data;
        }

        @Override
        public boolean hasPrevious() {
            return currentNode != begin;
        }

        @Override
        public AnyTylpe previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if (expectedModCount != modCount) throw new IllegalStateException();
            currentNode = currentNode.prev;
            AnyTylpe data = currentNode.data;
            okToRemove = true;
            return data;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) throw new IllegalStateException();
            if (!okToRemove) throw new IllegalStateException();
            E14_addLIstIteratorToLinkedList.this.remove(currentNode.prev);
            okToRemove = false;
        }

        @Override
        public void set(AnyTylpe anyTylpe) {
            if (expectedModCount != modCount) throw new IllegalStateException();
            E14_addLIstIteratorToLinkedList.this.set(getNodeIndex(currentNode), anyTylpe);
        }

        @Override
        public void add(AnyTylpe anyTylpe) {
            if (expectedModCount != modCount) throw new IllegalStateException();
            E14_addLIstIteratorToLinkedList.this.add(getNodeIndex(currentNode.next), anyTylpe);
        }
    }
}
