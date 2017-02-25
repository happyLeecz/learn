package _2016year._10_17_noon;

/**
 * Created by lcz on 2016/10/17.
 */
public class MyStack {
    private char[] stack;
    private int topOfTheStack = -1;
    public MyStack(int length){
        stack = new char[length];
    }
    public  void push(char word){

        stack[++topOfTheStack] = word;
    }
    public char pop(){
        char top = getTopWord();
        --topOfTheStack;
        return top;

    }

    public int getTopOfTheStack() {
        return topOfTheStack;
    }
    public char getTopWord(){
        return stack[topOfTheStack];
    }
}
