package sorting;

/**
 * Created by hrong on 2016/12/5.
 */
public class ShellSort {
    public static <AnyType extends Comparable<? super AnyType>> void shellsort(AnyType[] arr){
        int j;
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                AnyType tmp=arr[i];
                for (j = i; j >=gap&&arr[j].compareTo(arr[j-gap])<0 ; j-=gap) {
                    arr[j]=arr[j-gap];
                }
                arr[j]=tmp;
            }
        }
//        int[] gaps={7,3,1};
//        for (int gap :gaps) {
//            for (int i = gap; i < arr.length; i++) {
//                AnyType tmp=arr[i];
//                for (j = i; j >=gap&&tmp.compareTo(arr[j-gap])<0 ; j-=gap) {
//                    arr[j]=arr[j-gap];
//                }
//                arr[j]=tmp;
//            }
//        }
    }

    public static void main(String[] args) {
        Integer[] a = {23, 235, 57, 34, 42, 123, 89,11};
        for (int i : a) {
            System.out.print(i + " ");
        }
        shellsort(a);
        System.out.println("after shellSort");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
