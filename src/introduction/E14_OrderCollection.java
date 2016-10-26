package introduction;

import sun.security.util.Length;

import java.util.Comparator;

/**
 * Created by hrong on 2016/10/21.
 */
public class E14_OrderCollection<T extends Comparator<T>> {
    private Comparable[] comparables;
    private T[] ts;
    private int length;

    public E14_OrderCollection(Comparable<T>[] comparables) {
        this.comparables = comparables;
        length = comparables.length;
    }

    public boolean isEmpty() {
        if (comparables.length == 0) return true;
        else return false;
    }

    public void makeEmpty() {
        for (int i = 0; i < length; i++) {
            comparables[i] = null;
        }
    }

    public void insert(Comparable comparable, int index) {
        Comparable<T>[] newComparables = new Comparable[length + 1];
        System.arraycopy(comparables, 0, newComparables, 0, index);
        newComparables[index] = comparable;
        System.arraycopy(comparables, index, newComparables, index + 1, length - index);
    }

    public void remove(int index) {
        Comparable<T>[] newComparables = new Comparable[length - 1];
        System.arraycopy(comparables, 0, newComparables, 0, index);
        System.arraycopy(comparables, index + 1, newComparables, index, length - index - 1);
    }

    public Comparable<T> findMin() {
        if (length == 0) return null;
        int MinComparable = 0;
        for (int i = 0; i < length; i++) {
            if (comparables[MinComparable].compareTo(comparables[i]) < 0)
                MinComparable = i;
        }
        return comparables[MinComparable];
    }

    public Comparable<T> findMax() {
        if (length == 0) return null;
        int MaxComparable = 0;
        for (int i = 0; i < length; i++) {
            if (comparables[MaxComparable].compareTo(comparables[i]) > 0)
                MaxComparable = i;
        }
        return comparables[MaxComparable];
    }
}
