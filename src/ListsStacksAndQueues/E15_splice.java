package ListsStacksAndQueues;

import java.util.Iterator;

/**
 * Created by hrong on 2016/10/26.
 */
public class E15_splice<AnyType> extends MyLinkedList<AnyType> {
    public void splice(Iterator<AnyType> itr, MyLinkedList<AnyType> lst) {
        AnyType currentItem = itr.next();
        int currentNodeIndex = getNodeIndex(currentItem);
        for (AnyType data : lst)
            E15_splice.this.add(currentNodeIndex, data);
        lst.clear();
    }
}
