package _2016year._10_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lcz on 2016/9/20.
 */
public class Sort_1 {
    public static void main(String []args){
        int[] arrs  =new int[6];
        Scanner in = new Scanner(System.in);
        for (int i=0;i<arrs.length;i++){
            arrs[i] = in.nextInt();
        }
        quickSort(arrs,0,arrs.length-1);
        System.out.println(Arrays.toString(arrs));
    }
//插入排序
    public static  void insertSort(int[] arr){
        int i,j,flag;
        for(i=1 ; i < arr.length ; i++){
                flag = arr[i];
            //这里的-1和下面的--j其实是一种情况就是说上来我就已经在前一个位置判断了，那就分为两种情况，
            //1)j在要判断的分序列的倒数第二个
            //1.1)arr[j]<arr[j+1]，那么就不用后移了，arr[j+1]=flag
            //1.2)arr[j]>arr[j+1]，后移一位，j就再往前去一位，就变成下面2)的情况
            //2)j在要判断的分序列倒数第二个的前面的位置
            //2.1)arr[j]<arr[j+1],不用后移，而且后面的肯定是后移了得，直接在前一位把flag的值插入，arr[j+1]=flag
            //2.2）arr[j]>arr[j+1]，后移一位，j再往前去一位，继续走2)
            //在1)和2)中可能出现临界的情况也就是j=0的情况，在这种情况下，
            // 有可能是j是1.1)的情况：考虑一下还是成立
            //有可能是j是1.2)的情况：这时候进入循环--j，出来不会再进入循环，j就变为-1，arr[j+1]=flag，flag还是插入了正确的位置
            //有可能是j是2.1)的情况：考虑一下还是成立
            //有可能是j是2.2)的情况：这时候进入循环--j，出来不会再进入循环，j就变为-1，arr[j+1]=flag，flag还是插入了正确的位置
            //所以说--j很重要
            //这是分情况的细致分析，其实只要考虑跳出while循环的条件及就行了，跳出必然是j<0,或者arr[j]<flag,两者不能同时发生，因为当j<0时，
            //数组就越界了
            // 当j<0说明就到了最前面了，这时j为-1，flag就放到了arr[0],也就是第一位
            //当arr[j]<flag，也就是说当前位置比要插入的小，插入的应该放入后位置上，则arr[j+1]=flag,正确插入
                j=i-1;
                while (j >= 0 && flag < arr[j] ){//判断的顺序不能错，不然因为短路效应可能出现j<0的情况
                     arr[j+1] = arr[j];
                      --j;//这个的存在很重要，只要交换了那么j的值就会减一
            }
             arr[j+1] = flag;
        }
    }
    public static void quickSort(int []arr,int low,int high) {
        if (low < high) {
            int key = arr[low];
            int l = low, h = high;
            while (l < h) {
                while (l < h && arr[h] >= key) {
                    --h;
                }
                arr[l] = arr[h];
                while (l < h && arr[l] <= key) {
                    ++l;
                }
                arr[h]=arr[l];
            }
            arr[l] = key;
            quickSort(arr,low,l-1 );
            quickSort(arr,l+1,high );

        }
        return;
    }

}
