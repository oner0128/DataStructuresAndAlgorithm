package introduction;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by hrong on 2016/10/21.
 */
public class E15_Rectangle {
    private int width;

    private int length;

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public E15_Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }


    public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) {
        int maxTemp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cmp.compare(arr[i], arr[maxTemp]) > 0)
                maxTemp = i;
        }
        return arr[maxTemp];
    }

    public static void main(String[] args) {
        Random random = new Random(49);
        E15_Rectangle[] rectangles = new E15_Rectangle[5];
        for (int i = 0; i < 5; i++) {
            E15_Rectangle temp=new E15_Rectangle(random.nextInt(10), random.nextInt(10));
            rectangles[i] = temp;
            System.out.println(temp+" L :"+temp.getLength()+" W :"+temp.getWidth());
        }
        E15_Rectangle maxAreaR=findMax(rectangles, new FindAreaMax());
        E15_Rectangle maxPerimeterR=findMax(rectangles, new FindPerimeterMax());
        System.out.println(maxAreaR.getLength()+"   "+maxAreaR.getWidth());
        System.out.println(maxPerimeterR.getLength()+"   "+maxPerimeterR.getWidth());
    }



}
