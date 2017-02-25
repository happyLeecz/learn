package _2016year._12_8_noon;

/**
 * Created by lcz on 2016/12/8.
 */
public class TestBind {

    public static void main(String[] args) {
       String s = "hello";
        //从索引4开始的位置或之后查找出现子字符串hell的第一个位置的索引这里找不到就返回-1
        System.out.println(s.indexOf("hell",4));
        String s1 ="1,18,13";
        System.out.println(s1.indexOf("1"));

    }
}
