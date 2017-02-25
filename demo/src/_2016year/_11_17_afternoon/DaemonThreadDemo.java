package _2016year._11_17_afternoon;

/**
 * Created by lcz on 2016/11/17.
 */
class DaemonThread implements Runnable{
    @Override
    public void run() {
        System.out.println("进入守护线程"+ Thread.currentThread().getName());
        int count = 0;
        while(count < 999){
            System.out.println("这是" + count++);
        }
        System.out.println("退出守护线程"+ Thread.currentThread().getName());
    }

}
public class DaemonThreadDemo {

    public static void main(String[] args) {
        System.out.println("进入主线程"+ Thread.currentThread().getName());
        Thread thread = new Thread(new DaemonThread());
       thread.setDaemon(true);
        thread.start();
        System.out.println("退出主线程"+ Thread.currentThread().getName());


    }

}
