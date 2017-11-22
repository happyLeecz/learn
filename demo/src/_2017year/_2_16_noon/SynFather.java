package _2017year._2_16_noon;

/**
* Created by lcz on 2017/2/27.
*/
class SynFather{
   public void doSomething(String s){
           synchronized (this) {
               System.out.println("this is SynFather" + "\t"+s);
           }
   }

    private void SFPrivateMethod(){
        System.out.println("this method is mine");
    }
}
