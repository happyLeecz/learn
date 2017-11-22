package _2017year.DataStructure;

/**
 * Created by lcz on 2017/3/14.
 */
public class QuickSort {

    public static int partition(Comparable[] a,int lo,int hi){
        int i = lo , j=hi+1;//左右扫描指针
        Comparable flag = a[lo];
        while(true){
            while(less(a[++i],flag)) {
                if(i == hi)
                    break;
            }
            while(less(flag,a[--j])){
                if(j==lo)
                    break;
            }
            if(i>=j)
                break;
            exchange(a,i,j);
        }
        exchange(a,lo,j);
        return j;

    }
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b) < 0;
    }
    public static void exchange(Comparable[] a , int i , int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void quickSort2Parts(Comparable[] a,int lo,int hi){
        if(lo <= hi) return;
        int cutPoint = partition(a,lo,hi);
        quickSort2Parts(a,lo,cutPoint-1);
        quickSort2Parts(a,cutPoint+1,hi);
    }
    //算法P189
    public static void quickSort3Parts(Comparable[] a,int lo,int hi){
        if(lo >= hi) return;
        int equalBeginP = lo,gongingToCheckP = lo + 1,beforeGreaterP = hi;
        Comparable v = a[lo];
        while(gongingToCheckP <= beforeGreaterP){
            int result = a[gongingToCheckP].compareTo(v);
            if(result < 0) exchange(a,gongingToCheckP++,equalBeginP++);
            else if(result == 0) gongingToCheckP++;
            else exchange(a,gongingToCheckP,beforeGreaterP--);
        }
        quickSort3Parts(a,lo,equalBeginP-1);
        quickSort3Parts(a,beforeGreaterP+1,hi);
    }
}
