package introduction;

/**
 * Created by hrong on 2016/10/21.
 */
public class E05_Ones {
    public static int getBinaryNumber(int n) {
        if (n  <2) return n;
       return n%2+getBinaryNumber(n/2);
    }

    public static void main(String[] args) {
        System.out.println("The number of 1 is :"+getBinaryNumber(1023));
    }
}

