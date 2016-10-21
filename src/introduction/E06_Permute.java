package introduction;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by hrong on 2016/10/21.
 * 非重复字符的全排列算法
 * 输入：abc
 * 输出：abb abb bab bba bba bab
 */
public class E06_Permute {
    public void permete(String str) {
        System.out.println("origin string : " + str);
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(str.length());
        char[] newString = new char[str.length()];
        for (int i = 0; i < stringBuilder.length(); i++) {
            newString[i] = stringBuilder.charAt(i);
        }
        System.out.println("origin char[] : " + Arrays.toString(newString));
        permete(newString, 0, newString.length - 1);
    }

    private void permete(char[] str, int low, int high) {
        if (high - low == 0) System.out.print(new String(str) + " ");
        else {
            char tmp;
            for (int i = low; i <= high; i++) {
                tmp = str[low];
                str[low] = str[i];
                str[i] = tmp;
                permete(str, low + 1, high);
                tmp = str[low];
                str[low] = str[i];
                str[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        E06_Permute e06_permute = new E06_Permute();
        e06_permute.permete("abc");
    }
}
