package sorting;

/**
 * Created by hrong on 2016/12/5.
 */
public class InsertionSorting {
    public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            AnyType tmp = arr[i];
            for (j = i; j >= 1 && tmp.compareTo(arr[j - 1]) < 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {23, 235, 57, 34, 4, 123, 87};
        for (int i : a) {
            System.out.print(i + " ");
        }
        insertionSort(a);
        System.out.println("after insetionSort");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
