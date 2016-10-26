package algorithmAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by hrong on 2016/10/22.
 */
public class E08_randomArray {
    static Random random = new Random(47);
    public static void randInt1(int i, int j) {
        long startTime=System.nanoTime();
        int[] a = new int[j - i + 1];
        int tmp = 0;
        boolean isEqual = false;
        for (int k = 0; k < a.length; k++) {
            do {
                tmp = random.nextInt(j+1);
                isEqual=false;
                for (int l = 0; l < k; l++) {
                    if (a[l] == tmp) {
                        isEqual = true;
                        break;
                    }
                }
            }
            while (tmp < i || isEqual);
            a[k] = tmp;
        }
        long endTime=System.nanoTime();
        System.out.println(j+" ---1--- "+(endTime-startTime));
        System.out.println(Arrays.toString(a));
    }

    public static void randInt2(int i, int j) {
        long startTime=System.nanoTime();
        int[] a = new int[j - i + 1];
        boolean[] used = new boolean[a.length];
        for (int k = 0; k < used.length; k++) {
            used[k]=false;
        }
        int tmp = 0;
        for (int k = 0; k < a.length; k++) {
            do {
                tmp = random.nextInt(j+1);
                if ((!used[tmp]) && (tmp >= i)) {
                    a[k] = tmp;
                    used[tmp] = true;break;
                }
            }
            while (tmp < i||used[tmp]);
        }
        long endTime=System.nanoTime();
        System.out.println(j+" ---2--- "+(endTime-startTime));
        System.out.println(Arrays.toString(a));    }

    private int[] a;

    public  void randInt3(int i, int j) {
        long startTime=System.nanoTime();
        int[] a = new int[j - i + 1];
        int tmp = 0;
        for (int k = 0; k < a.length; k++) a[k] = i++;
        this.a = a;
        for (int k = 1; k < a.length; k++) {
            swapReferences(k, random.nextInt(k+1));
        }
        long endTime=System.nanoTime();
        System.out.println(j+" ---3--- "+(endTime-startTime));
        System.out.println(Arrays.toString(a));    }

    public void swapReferences(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a1 = {10};
        for (int i : a1)
            randInt1(0, i);
        int[] a2 = {25000, 50000, 100000, 200000};
        for (int i : a1)
            randInt2(0, i);
        int[] a3 = {100000, 200000, 400000, 800000};
        for (int i : a1)
            new E08_randomArray().randInt3(0, i);
    }
}
