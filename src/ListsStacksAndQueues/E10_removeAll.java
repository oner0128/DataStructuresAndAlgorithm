package ListsStacksAndQueues;

import java.util.Iterator;

/**
 * Created by hrong on 2016/10/26.
 */
public class E10_removeAll<AnyType> extends MyLinkedList<AnyType> {
    public void removeAll(Iterable<? extends AnyType> items){
        Iterator<? extends AnyType> iterator=items.iterator();
        while (iterator.hasNext()){
            int idx= getNodeIndex(iterator.next());
            if (idx!=-1)remove(idx);
        }
    }
    //答案 利用迭代器  O(MN),M is the size of items
    public void removeAll2(Iterable<? extends AnyType> items){
        Iterator<? extends AnyType> iterator=items.iterator();
        AnyType item,element;
        while (iterator.hasNext()){
            item=iterator.next();
            Iterator<? extends AnyType> listIter=iterator();
            while (listIter.hasNext()){
                element=listIter.next();
                if (element.equals(item))listIter.remove();
            }
        }
    }
}
