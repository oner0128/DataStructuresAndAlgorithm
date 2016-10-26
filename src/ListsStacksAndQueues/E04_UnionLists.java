package ListsStacksAndQueues;

import java.util.*;

/**
 * Created by hrong on 2016/10/24.
 */
public class E04_UnionLists {
    public static <AnyType extends Comparable<? super AnyType>> void unionList(List<AnyType> list1, List<AnyType> list2) {
        Iterator<AnyType> iterator1 = list1.iterator();
        Iterator<AnyType> iterator2 = list2.iterator();
        List<AnyType> insertList=new ArrayList<>();
        AnyType tmp1=null, tmp2=null;
        if (iterator1.hasNext()&&iterator2.hasNext()){
        tmp1 = iterator1.next();
        tmp2 = iterator2.next();}
        while (tmp1!=null && tmp2!=null) {
            switch (tmp1.compareTo(tmp2)) {
                case 0: {
                    insertList.add(tmp1);
                    tmp1 = iterator1.hasNext()?iterator1.next():null;
                    tmp2 = iterator2.hasNext()?iterator2.next():null;
                }
                break;
                case 1: {
                    tmp2 = iterator2.hasNext()?iterator2.next():null;
                }
                break;
                case -1: {
                    tmp1 = iterator1.hasNext()?iterator1.next():null;
                }
                break;
            }
        }
        System.out.println(insertList);
    }


    public static void main(String[] args) {
        Integer[] n1 = {1, 2, 3, 4, 5,6,10};
        Integer[] n2 = {3, 4, 5, 6, 7,8,9};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(n1));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(n2));
        unionList(list1, list2);
    }
}
