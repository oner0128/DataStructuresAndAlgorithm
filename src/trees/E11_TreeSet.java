package trees;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by hrong on 2016/11/17.
 */
class MyTreeSet<AnyType extends Comparable<? super AnyType>> {
    private BinaryNode<AnyType> root;
    int modCount = 0;

    private static class BinaryNode<AnyType> {
        BinaryNode<AnyType> left, right, parent;
        AnyType element;

        public BinaryNode(AnyType element) {
            this(null, null, null, element);
        }

        public BinaryNode(BinaryNode<AnyType> left, BinaryNode<AnyType> right, BinaryNode<AnyType> parent, AnyType element) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.element = element;
        }
    }

    public MyTreeSet() {
        root = null;
    }

    public void makeEmpty() {
        modCount++;
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) return false;
        int comResult = x.compareTo(t.element);
        if (comResult < 0) {
            return contains(x, t.left);
        } else if (comResult > 0) {
            return contains(x, t.right);
        } else return true;
    }

    public BinaryNode<AnyType> insert(AnyType x) {
        return root=insert(x, root, null);
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t, BinaryNode<AnyType> pt) {
        if (t == null) {
            modCount++;
            return new BinaryNode<AnyType>(null, null, pt, x);
        }
        int comResult = x.compareTo(t.element);
        if (comResult < 0) {
            t.left = insert(x, t.left, t);
        } else if (comResult > 0) {
            t.right = insert(x, t.right, t);
        } else ;
        return t;
    }

    public boolean remove(AnyType x) {
        return remove(x, root) != null;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) return null;
        int comResult = x.compareTo(t.element);
        if (comResult < 0) {
            t.left = remove(x, t.left);
        } else if (comResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            modCount++;
            BinaryNode<AnyType> oneChid;
            oneChid = (t.left != null) ? t.left : t.right;
            oneChid.parent = t.parent;
            t = oneChid;
        }
        return t;
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) return null;
        else if (t.left == null) return t;
        return findMin(t.left);
    }

    public AnyType findMin() throws Exception {
        if (isEmpty()) throw new Exception();
        return findMin(root).element;
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null) while (t.right != null) t = t.right;
        return t;
    }

    public AnyType findMax() throws Exception {
        if (isEmpty()) throw new Exception();
        return findMax(root).element;
    }

    public void printTree() {
        if (isEmpty()) System.out.println("Empty Tree");
        else printTree(root);
    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    public Iterator<AnyType> iterator() {
        return new MyTreeSetIterator();
    }

    private class MyTreeSetIterator implements Iterator<AnyType> {
        private BinaryNode<AnyType> current=findMin(root);
        private BinaryNode<AnyType> previous;
        private int expectModCount=modCount;
        private boolean okToRemove=false;
        private boolean atEnd=false;
        @Override
        public boolean hasNext() {
            return !atEnd;
        }

        @Override
        public AnyType next() {
            if (expectModCount!=modCount)throw new ConcurrentModificationException();
            if (!hasNext())throw new NoSuchElementException();
            AnyType nextItem=current.element;
            previous=current;
            // if there is a right child, next node is min in right subtree
            if (current.right!=null){
                current=findMin(current.right);
            }
            else {// else, find ancestor that it is left of
                BinaryNode<AnyType> child=current;
                current=current.parent;
                while (current!=null&&current.left!=child){
                    child=current;
                    current=current.parent;
                }
                if (current==null)atEnd=true;
            }
            okToRemove=true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (expectModCount!=modCount)throw new ConcurrentModificationException();
            if (!okToRemove)throw new IllegalStateException();
            MyTreeSet.this.remove(current.element);
            okToRemove=false;
        }
    }
}

public class E11_TreeSet {
    public static void main(String[] args) {
        MyTreeSet<Integer> integerMyTreeSet=new MyTreeSet<>();
        for (int i = 10; i > 0; i--) {
            integerMyTreeSet.insert(i);
        }
        Iterator<Integer> integerIterator=integerMyTreeSet.iterator();
        while (integerIterator.hasNext()) System.out.print(integerIterator.next()+"-");
        System.out.print("\n");
        integerMyTreeSet.printTree();
    }
}
