package introduction;

/**
 * Created by hrong on 2016/10/21.
 */
public class E01_runtimes {
    public static void main(String[] args) {

        long  k, N = 999999999999999999L;
        long startTime = System.nanoTime();
        k = N / 2;
        long endTime = System.nanoTime();
        System.out.println(k + " : " + (endTime - startTime));
    }
}
