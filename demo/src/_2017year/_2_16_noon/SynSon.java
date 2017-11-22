package _2017year._2_16_noon;



/**
 * Created by lcz on 2017/2/27.
 */
  class SynSon extends SynFather{
    public void doSomething(String s) {
        synchronized (this) {

            System.out.println("this is SynSon" + this);
            //invokespecial字节码指令需要将this引用给到被调用的方法的局部变量表上的0 Slot位置，如果有参数还需要其他的参数也传递过去
            //invokevirtual也是一样的道理
            //invokestatic则不需要传递this引用因为是调用的类方法
            super.doSomething(s);
        }
    }
}
