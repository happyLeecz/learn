package _2017year._5_14_morning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lcz on 2017/5/17.
 */
public class realDo implements InvocationHandler{

    private TargetClass targetClass;

    public realDo(TargetClass targetClass){
        this.targetClass = targetClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("this is a before");
        result = method.invoke(targetClass,args);
        System.out.println("this is a after");
        return result;
    }
    public static void main(String[] args){
        realDo real = new realDo(new TargetClass());

        TargetInterface target = (TargetInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),TargetClass.class.getInterfaces(),real);
        target.function();
    }
}
