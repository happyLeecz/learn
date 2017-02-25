package _2016year._10_2_nightXX;

import java.util.Date;

/**
 * Created by lcz on 2016/10/2.
 */
public class Test1 {
    public static void main(String[] args){
        B1 b1 = new B1();
        b1.m1(new Date());
       // b1.m1(new Object());//这里确实是重写不是重载,如果是重载这两个方法都可以调用的
        A1<Date> a1 = new B1();
        a1.m1(new Date());
        //a1.m1(new Object());//如果说编译器为我们创造了桥方法来解决冲突，为什么不能调用这个桥方法呢
        //可能是在class文件里才有那个方法，编译的时候加的，在我没有自己写代码的时候并不能引用
    }
}
