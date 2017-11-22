package _2017year.DataStructure;

import java.util.Arrays;

/**
 * Created by lcz on 2017/3/13.
 */
public class InsertSort {

    //正常插入排序
   public static void insertSort(Comparable[] a){
       for(int i = 1 ;i < a.length;i++){
           for(int j = i;j > 0 && less(a[j],a[j-1]);j--){
               exchange(a,j,j-1);
           }
       }
   }
    //插入排序优化
    public static void insertSort2(Comparable[] a){
        for(int i =1 ;i < a.length ;i++){
            Comparable temp = a[i];
            int j;
            for(j = i;j > 0 && less(temp,a[j-1]);j--){
                a[j] = a[j-1];
            }
           a[j] = temp;
        }
    }

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }


    public static void exchange(Comparable[] a , int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    public static void main(String[] args){
        Integer[] a = {1,23,43,5,24,4};
        insertSort2(a);
        System.out.println(Arrays.toString(a));

    }
}
