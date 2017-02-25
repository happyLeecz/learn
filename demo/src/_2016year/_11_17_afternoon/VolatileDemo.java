package _2016year._11_17_afternoon;

/**
 * Created by lcz on 2016/11/17.
 */
public class VolatileDemo {
    private volatile int number = 0;
    public int getNumber(){
        return this.number;
    }

    public void increase(){
        this.number++;
    }

    public static void main(String[] args) {
        //这个地方的final很关键
      VolatileDemo volatileDemo = new VolatileDemo();
        for (int i = 0 ;i<500;i++){
            new Thread(new Runnable() {
                @Override
                public void run()  {

                    volatileDemo.increase();
                }
            }).start();
        }
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("number =" + volatileDemo.getNumber());
    }
}
