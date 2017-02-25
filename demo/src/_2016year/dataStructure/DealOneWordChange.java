package _2016year.dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lcz on 2016/10/15.
 * 用TreeMap来处理统计对于一个范围地单词里只改变一个字母相同的单词是多少
 */
public class DealOneWordChange {
    //对89000个单词的词典运行16秒
    public static Map<String,List<String>> computeAdjacentWords(List<String> theWords){
        Map<String,List<String>> adjWords = new TreeMap<>();
        Map<Integer,List<String>> wordsByLength = new TreeMap<>();

        for(String w : theWords){
            update(wordsByLength,w.length(),w);
        }
        for(List<String> groupWords : wordsByLength.values()){
            String[] words = new String[groupWords.size()];
            groupWords.toArray(words);
            for(int i =0;i<words.length;i++)
                for(int j = i+1;j<words.length;j++)
                    if(oneCharOff(words[i],words[j])){
                        update(adjWords,words[i],words[j]);
                        update(adjWords,words[j],words[i]);
                    }

        }
        return adjWords;
    }
    //自己手写跟书上有差别，具体见P110
    public static Map<String,List<String>> computeAdjacentWords_faster(List<String> theWords){
        Map<String,List<String>> adjWords = new TreeMap<>();
        Map<Integer,List<String>> wordsByLength = new TreeMap<>();
        for(String w : theWords){
            update(wordsByLength,w.length(),w);
        }
        for(Map.Entry<Integer,List<String>> entry : wordsByLength.entrySet()){
            Map<String,List<String>> deleteOneWord = new TreeMap<>();
            int groupNum = entry.getKey();
            List<String> groupWords = entry.getValue();
            //书上俩for循环颠倒的
           for(String  s : groupWords){
               //书上Map是建立在这里的
              // Map<String,List<String>> deleteOneWord = new TreeMap<>();
               for(int i = 0;i < groupNum;i++){
                   String temp = s.substring(0,i)+s.substring(i+1);
                   update(deleteOneWord,temp,s);
               }
           }
            for(List<String> search : deleteOneWord.values())
               if(search.size() >= 2)
                for(String one : search)
                    for(String oneAgain : search)
                        if(one != oneAgain)
                            update(adjWords,one,oneAgain);
        }
        return adjWords;


    }
    public static boolean oneCharOff(String w1,String w2){
        int count = 0;
        for (int i =0;i< w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i)){
                if(++count>1)
                    return false;
            }
        }
        return count == 1;
    }
    public static <keyType> void update(Map<keyType,List<String>> map,keyType key,String value){
        List<String> lst = map.get(key);
        if(lst==null){
            lst = new ArrayList<>();
            map.put(key,lst);
        }
        lst.add(value);
    }

}
