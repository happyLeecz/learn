package _2016year._10_17_noon;

/**
 * Created by lcz on 2016/10/17.
 * 中缀表达式转换为后缀,P62
 */
public class InfixToSuffix {
    public static void main(String[] args){
    // String s ="a+b*c+(d*e+f)*g";
        String s = "a*b+c+d";
     StringBuilder stringBuilder = new StringBuilder();
     MyStack myStack = new MyStack(s.length());
     for(int i = 0 ; i<s.length();i++){
         char word = s.charAt(i);
         if(word == '+' || word == '*'||word =='(') {
             while (myStack.getTopOfTheStack() != -1) {
                 char top = myStack.getTopWord();
                 if (MyTool.compare(top, word)) {
                     stringBuilder.append(myStack.pop());
                     if (myStack.getTopOfTheStack() != -1)
                         continue;
                     break;
                 }
                 break;
             }
             myStack.push(word);
         }
         else if(word == ')'){
             while(myStack.getTopWord()!='(') {
                 stringBuilder.append(myStack.pop());
             }
             myStack.pop();
         }
         else
         stringBuilder.append(word);
     }
        while(myStack.getTopOfTheStack()!=-1){
            stringBuilder.append(myStack.pop());
        }
        System.out.println(stringBuilder);

    }
}
