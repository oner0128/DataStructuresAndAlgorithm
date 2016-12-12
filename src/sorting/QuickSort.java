package sorting;

/**
 * Created by hrong on 2016/12/12.
 */
public class QuickSort {
    private static final int CUTOFF = 3 ;

    public static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a, int left, int right) {
        if (left+CUTOFF<right){
            AnyType pivot = median3(a,left,right);
            //begin partitioning
            int i=left,j=right-1;
            for (;;){
                while (a[i++].compareTo(pivot)<0){}
                while (a[j--].compareTo(pivot)>0){}
                if (i<j)swaqReference(a,i,j);
                else break;
            }
            //Restore pivot
            swaqReference(a,i,right-1);
            //sort small elements
            quickSort(a,left,i-1);
            //sort large elements
            quickSort(a,i+1,right);
        }
        else InsertionSorting.insertionSort(a);
    }

    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] a, int left, int right) {
        int center=(left+right)/2;
        if (a[center].compareTo(a[left])<0)swaqReference(a,left,center);
        if (a[right].compareTo(a[center])<0)swaqReference(a,center,right);
        if (a[right].compareTo(a[left])<0)swaqReference(a,left,right);
        //place pivot at position right-1
        swaqReference(a,center,right-1);
        return a[right-1];
    }

    private static<AnyType extends Comparable<? super AnyType>> void swaqReference(AnyType[] a, int left, int right) {
        AnyType tmp=a[left];
        a[left]=a[right];
        a[right]=tmp;
    }
}
