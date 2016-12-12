package sorting;

import com.sun.org.glassfish.gmbal.ParameterNames;

/**
 * Created by hrong on 2016/12/12.
 */
public class MergeSort {
    public static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] array) {
        AnyType[] tmpArray = (AnyType[]) new Comparable[array.length];
        mergeSort(array, tmpArray, 0, array.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] array, AnyType[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(array, tmpArray, left, center);
            mergeSort(array, tmpArray, center + 1, right);
            merge(array, tmpArray, left, center + 1, right);
        }
    }

    /*
      @ParameterNames leftPos:the left-most index of the subArray
      @ParameterNames rightPos:the index of the start of second half
      @ParameterNames rightEnd:the right-most index of the subArray
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void merge(AnyType[] array, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        //main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos].compareTo(array[rightEnd]) <= 0)tmpArray[tmpPos++]=array[leftPos++];
            else tmpArray[tmpPos++]=array[rightPos++];
        }
        //copy the rest of first half
        while (leftPos <= leftEnd){
            tmpArray[tmpPos++]=array[leftPos++];
        }
        //copy the rest of second half
        while (rightPos <= rightEnd){
            tmpArray[tmpPos++]=array[rightEnd++];
        }
        //copy tmpArray back
        for (int i = 0; i < numElements; i++) {
            array[i]=tmpArray[i];
        }
    }
}
