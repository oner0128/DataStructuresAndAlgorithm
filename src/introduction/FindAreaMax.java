package introduction;

import java.util.Comparator;

/**
 * Created by hrong on 2016/10/21.
 *///找面积最大
public class FindAreaMax implements Comparator<E15_Rectangle> {
    @Override
    public int compare(E15_Rectangle o1, E15_Rectangle o2) {
        if (o1.getLength() * o1.getWidth() > o2.getLength() * o2.getWidth()) return 1;
        else return -1;
    }
}