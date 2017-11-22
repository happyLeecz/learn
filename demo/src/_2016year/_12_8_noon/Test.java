package _2016year._12_8_noon;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by lcz on 2016/12/8.
 */
public class Test {

    class GrandFather{
        void thinking(){
            System.out.println("I am a granfather");
            System.out.println(this.toString());
        }
    }

    class Father extends GrandFather{
        @Override
        void thinking() {
            System.out.println("I am a father");
            System.out.println(this.toString());
        }
    }

    class Son extends Father{
        @Override
        void thinking() {
            try{
                MethodType mt = MethodType.methodType(void.class);
                MethodHandles.Lookup lookup = MethodHandles.lookup();
                //最后一个参数如果跟当前类不一致就直接抛异
                MethodHandle mh = lookup.findSpecial(GrandFather.class,"thinking",mt,getClass());
                mh.invoke(this);
                System.out.println(this.toString());
            }catch (Throwable e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new Test().new Son()).thinking();

    }
}
