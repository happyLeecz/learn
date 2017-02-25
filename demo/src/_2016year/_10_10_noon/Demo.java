package _2016year._10_10_noon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcz on 2016/10/10.
 */
public class Demo {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(0,5);
        list.add(1,4);
        list.add(2,3);
        list.add(3,2);
        System.out.println(list.toString());
        list.add(1,6);//增添的位置及之后都进行后移
        System.out.println(list.toString());
        list.add(7);//在表的后端增加
        list.add(8);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());

    }
}
