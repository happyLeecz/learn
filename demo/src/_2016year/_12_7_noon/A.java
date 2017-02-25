package _2016year._12_7_noon;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by lcz on 2016/12/7.
 */
public class A {

    public void think(){


        System.out.println(new Object().toString());
        try {
             String s = (String) super.getClass().getSuperclass().getMethod("toString").invoke(Object.class.newInstance());
            System.out.println(s);
            String s1 = (String) super.getClass().getSuperclass().getMethod("toString").invoke(Object.class.newInstance());
            System.out.println(s1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
