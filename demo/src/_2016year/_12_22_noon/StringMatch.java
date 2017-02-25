package _2016year._12_22_noon;

import java.util.Scanner;

/**
 * Created by lcz on 2017/1/3.
 */
public class StringMatch {

    public static void main(String[] args) {
        System.out.println("please input mainstring:");
        Scanner in = new Scanner(System.in);
        String mainString = in.nextLine();
        System.out.println("please input matchstring");
        String matchString = in.nextLine();
        matchIndex(mainString,matchString);
    }

    public static void matchIndex(String mainString,String matchString){
        int index = 0;
        int mainStringLength = mainString.length();
        int matchStringLength = matchString.length();
        int i = 0,j =0;
        if(mainStringLength < matchStringLength){
            System.out.println("errro");
            return;
        }
        while(i< mainStringLength && j < matchStringLength){
            if(mainString.charAt(i) == matchString.charAt(j)) {
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
          }
        if(j == matchStringLength){
            index = i - j;
            System.out.println("匹配成功 index= " + index);
        }else{
            System.out.println("匹配失败");
        }

        }

    }

