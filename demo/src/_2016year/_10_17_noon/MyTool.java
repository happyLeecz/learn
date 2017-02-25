package _2016year._10_17_noon;

/**
 * Created by lcz on 2016/10/17.
 */
public class MyTool {
    public static boolean compare(char a,char b){
        if( a == '(')
            return false;
        return MyTool.getFirst(a) - MyTool.getFirst(b) >= 0;
    }
    public static int getFirst(char word){
        if(word == '+')
            return 0;
        if(word == '*')
            return 1;
        if(word == '(')
            return 2;
        return 0;
    }
}
