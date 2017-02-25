package _2016year._12_22_noon;

import java.util.Arrays;

/**
 * Created by lcz on 2016/12/23.
 */

public class BinaryHeap<T extends Comparable<? super T>> {
    private final static int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;


    public BinaryHeap(T[] items){
        currentSize = items.length;
        array = (T[])new Comparable[(currentSize + 2) * 11/10];
        int i = 1;
        //刚开始都是随意添加元素的并不符合最小堆的性质
        for(T item : items){
            array[i++] = item;
        }
        //真正开始创建堆
        builtHeap();
    }

    public void insert(T newItem) {
        //为什么是-1因为数组中的第一个元素array[0]是不存放真实数据的
        if (currentSize == array.length - 1) {
            //扩容
        }

        int hole = ++currentSize;
        //真正的数据是从1开始的，array[0]只是临时存放下数据
        for (array[0] = newItem; newItem.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = newItem;
    }

    public T findMin() {
        return array[1];
    }

    public T deleteMin() {
        if (isEmpty()) {

        }
        T minItem = findMin();
        //把当前最后的最小元给赋值到根上
        array[1] = array[currentSize--];
        //下滤
        percolateDown(1);

        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0 ? true : false;
    }

    public void makeEmpty(){
        this.currentSize = 0;
        this.array = null;
    }

    private void builtHeap(){
        //从最后一个父节点开始下滤
        for(int i =currentSize/2; i>0;i--){
            percolateDown(i);
        }
    }
    //下滤
    private void percolateDown(int hole){
        int child;
        T tmp = array[hole];

        for(;hole * 2 <= currentSize;hole = child){
            child = hole * 2;
            if(child != currentSize &&
                    array[child].compareTo(array[child+1]) > 0)
                ++child;
            if(tmp.compareTo(array[child]) > 0){
                array[hole] = array[child];
            }else{
                break;
            }
        }
        array[hole] =tmp;


    }

    private void enlargeArray(int newSize){
        if(newSize > array.length) {
            T[] newArray = (T[]) new Comparable[newSize + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }else{
            return;
        }
    }
    public static void main(String[] args){
        Integer[] a = {1,2,3,4,5};
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(a);
        System.out.println(Arrays.toString(binaryHeap.array));
        System.out.println((binaryHeap.array));
        System.out.println(binaryHeap.array.length);
        //这里直接运行会出错，
        // Exception in thread "main" java.lang.ClassCastException:
        // [Ljava.lang.Comparable; cannot be cast to [Ljava.lang.Integer;
        //因为由于类型擦出编译器在这里加了一些代码，差不多是((Integer[])binary.array).length这样的以达到泛型的目的
        //这里的array实际上是Comparable[]类型的，正常情况下是可以转换成功的，因为一般array是Comparable[]类型指向T[]类型的
        //然后强转是可以转换成功的（如L129,L130,L131的代码是可以成功的），但是问题就出在L18上，这里虽然有个强转T[]，但是
        //由于类型擦除这个array还是指向Comparable[]类型的数组对象，所以到这就会出现这个异常（如L128,L130,L131这种情况）
        //这里是以实际类型为强转依据的因为Comparable是Integer的接口所以不能将Comparable[]转换成Integer[]型的
        //System.out.println(binaryHeap.array.length);


        //这个才是达到目的的正确的写法
        System.out.println(((Comparable[])binaryHeap.array).length);
        binaryHeap.enlargeArray(8);
        System.out.println(Arrays.toString(binaryHeap.array));
       // System.out.println(binaryHeap.array.length);
        System.out.println(((Comparable[])binaryHeap.array).length);

//        Comparable[] A =  new Comparable[2];
//        Comparable[] A = new Integer[2];
//        Integer[] B = (Integer[]) A;
//        System.out.println("Success");

    }





}