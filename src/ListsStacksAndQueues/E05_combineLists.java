package ListsStacksAndQueues;

import java.util.*;

/**
 * Created by hrong on 2016/10/24.
 */
public class E05_combineLists {
    public static <AnyType extends Comparable<? super AnyType>> void combineList(List<AnyType> list1, List<AnyType> list2) {
        Iterator<AnyType> iterator1 = list1.iterator();
        Iterator<AnyType> iterator2 = list2.iterator();
        List<AnyType> resultList = new ArrayList<>();
        AnyType itemL1 = null, itemL2 = null;
        if (iterator1.hasNext() && iterator2.hasNext()) {
            itemL1 = iterator1.next();
            itemL2 = iterator2.next();
        }
        while (itemL1 != null && itemL2 != null) {
            switch (itemL1.compareTo(itemL2)) {
                case 0: {
                    resultList.add(itemL1);
                    itemL1 = iterator1.hasNext() ? iterator1.next() : null;
                    itemL2 = iterator2.hasNext() ? iterator2.next() : null;
                }
                break;
                case 1: {
                    resultList.add(itemL2);
                    itemL2 = iterator2.hasNext() ? iterator2.next() : null;
                }
                break;
                case -1: {
                    resultList.add(itemL1);
                    itemL1 = iterator1.hasNext() ? iterator1.next() : null;
                }
                break;
            }
        }
        if (itemL1 == null) {
            while ( itemL2 != null) {
                resultList.add(itemL2);
                itemL2 = iterator2.hasNext() ? iterator2.next() : null;
            }
        }
        else if (itemL2 == null) {
            while (itemL1 != null) {
                resultList.add(itemL1);
                itemL1 = iterator1.hasNext() ? iterator1.next() : null;
            }
        }
        System.out.println("Combine List : ");
        System.out.println(resultList);
    }


    public static void main(String[] args) {
        Integer[] n1 = {1, 2, 3, 4, 5};
        Integer[] n2 = {3, 4, 5, 6, 7};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(n1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(n2));
        combineList(list1, list2);
    }
}
