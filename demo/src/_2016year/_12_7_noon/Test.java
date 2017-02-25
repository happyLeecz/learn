package _2016year._12_7_noon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by lcz on 2016/12/7.
 */
public class Test {
    public class GrandFather {
        public void thinking() {
            System.out.println("I am a grandfather");
        }
    }

    public class Father extends GrandFather {
        public void thinking() {
            System.out.println("I am a father");
        }
    }

    public class Son extends Father {

        public void thinking(Test t) {

            try {
                //这里super.getClass()得到的实当前类的Class对象，为什么呢，虽然super指向其父类引用
                //但是getClass方法来自Object类，它返回对象在运行时的类型。因为在运行时的对象类型是Son，所以this.getClass()和super.getClass()都是返回Son
                //getClass()在Object类中定义成了final，子类不能覆盖该方法
                Constructor c = super.getClass().getSuperclass().getSuperclass().getConstructor(Test.class);
                GrandFather grandFather = (GrandFather) c.newInstance(t);
                (super.getClass().getSuperclass().getSuperclass().getMethod("thinking")).invoke(grandFather);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            System.out.println("success");
            System.out.println(super.getClass().getName());


        }
    }

    public static void main(String[] args) {

//        try {
        //这个不能构造内部类的实例，因为内部类的构造参数有一个对外部类的引用，如果用默认的无参数的构造器的话就找不到这个构造器
//            Son.class.getMethod("thinking").invoke(Son.class.newInstance());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//    }
        //---------------------------------------------------------------------------------------------------
//        try {
//            Constructor c = Son.class.getConstructor(Test.class);
//            Son son = (Son)c.newInstance(new Test());
//            son.thinking();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
        //this关键字不能再main方法中使用，而main是个静态方法，静态方法只能调用静态成员变量和静态方法
        //不能使用this关键字
       Test t = new Test();
        t.new Son().thinking(t);


    }
}
