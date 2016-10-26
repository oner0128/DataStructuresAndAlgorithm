package algorithmAnalysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hrong on 2016/10/21.
 */
public class E07_runtimes {

    public static long frist(int N) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("frist :" + (endTime - startTime));
        return endTime - startTime;
    }

    public static long second(int N) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("second :" + (endTime - startTime));
        return endTime - startTime;
    }

    public static long third(int N) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * N; j++) {
                sum++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("third :" + (endTime - startTime));
        return endTime - startTime;
    }

    public static long forth(int N) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("forth :" + (endTime - startTime));
        return endTime - startTime;
    }

    public static long fifth(int N) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i * i; j++) {
                for (int k = 0; k < j; k++) {
                    sum++;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("fifth :" + (endTime - startTime));
        return endTime - startTime;
    }

    public static long sixth(int N) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i * i; j++) {
                if (j % i == 0)
                    for (int k = 0; k < j; k++) {
                        sum++;
                    }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("sixth :" + (endTime - startTime));
        return endTime - startTime;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\hrong\\Desktop\\test.txt");
        if (!file.exists()) try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            int n = 10000000;
            int i = 4000;
//            for (int i = 10000; i < n; i++) {
            bufferedWriter.write(i + " frist :" + frist(i) + "\n");
            bufferedWriter.write(i + " sencond :" + second(i) + "\n");
            bufferedWriter.write(i + " third :" + third(i) + "\n");
            bufferedWriter.write(i + " forth :" + forth(i) + "\n");
            bufferedWriter.write(i + " fifth :" + fifth(i) + "\n");
            bufferedWriter.write(i + " sixth :" + sixth(i) + "\n");
//            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e + "111");
        }


    }
}
