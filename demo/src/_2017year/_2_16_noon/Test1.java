package _2017year._2_16_noon;

/**
 * Created by lcz on 2017/2/16.
 */
public class Test1 {

    public static void main(String[] args) {
        Comparable [] a = new Comparable[2];
        Comparable [] b = new Integer[2];
        System.out.println(a + "\n" + b);
        //测试下改动
        

}
    //参数顺序其实也是在方法特征签名里的，java的方法特征签名只包括了方法名称，参数顺序，参数类型
    //而字节码的特征签名还包括了方法返回值以及受查异常表
//    public void functionA(String a,int b){
//        System.out.println(a+b);
//    }
//    public void functionA(int a,String b){
//        System.out.println(a + b);
//
//    }
//
//    public static void main (String[] args){
//        Test1 a = new Test1();
//        a.functionA("sad",2);
//        a.functionA(2,"sad");
//    }
}
