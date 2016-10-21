package introduction;

import java.util.Comparator;

/**
 * Created by hrong on 2016/10/21.
 */
//找周长最大
public class FindPerimeterMax implements Comparator<E15_Rectangle> {
    @Override
    public int compare(E15_Rectangle o1, E15_Rectangle o2) {
        if ((o1.getLength() * 2 + o1.getWidth() * 2) > (o2.getLength() * 2 + o2.getWidth() * 2)) return 1;
        else return -1;
    }
}