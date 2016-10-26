package ListsStacksAndQueues;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by hrong on 2016/10/26.
 */
public class E09_addAll<AnyType> extends MyArrayList<AnyType> {
    public void addAll(Iterable<? extends AnyType> items){
        for (AnyType data : items) {
            add(data);
        }
    }
    //答案--利用迭代器
    public void addAll2(Iterable<? extends AnyType> items){
        Iterator<? extends AnyType> iterator=items.iterator();
        while (iterator.hasNext()){
            add(iterator.next());
        }
    }
}
