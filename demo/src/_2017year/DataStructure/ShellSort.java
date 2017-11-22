package _2017year.DataStructure;

/**
 * Created by lcz on 2017/3/14.
 */
public class ShellSort {

    //希尔排序
    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h <= N / 3)
            h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exchange(a, j, j - h);

            }
            h=h/3;

        }
    }
    public static void exchange(Comparable[] a , int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }

}
