package ListsStacksAndQueues;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hrong on 2016/10/24.
 */
public class E01_printLots {
    public static <AnyType> void printLots(List<AnyType> l, List<Integer> p) {
        Iterator<AnyType> anyTypeIterator = l.iterator();
        Iterator<Integer> integerIterator = p.iterator();
        int start = 0;
        int tmp = 0;
        while (anyTypeIterator.hasNext() && integerIterator.hasNext()) {
            tmp = integerIterator.next();
            while (start < tmp && anyTypeIterator.hasNext()) {
                start++;
                System.out.println(tmp + " th is " + anyTypeIterator.next());
            }
        }
    }
}
