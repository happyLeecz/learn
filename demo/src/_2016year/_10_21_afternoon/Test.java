package _2016year._10_21_afternoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzx on 2016/10/22.
 */
public class Test {
    public static List<String> listread(String filefullpath){
        FileReader file=null;
        BufferedReader br=null;
        FileWriter fw=null;
        BufferedWriter bw=null;
        List<String> list=null;
        int i;
        String path=null;

        try{
            file=new FileReader(filefullpath);
            br=new BufferedReader(file);
            list=new ArrayList<String>();
            String read=null;
            while ((read = br.readLine())!= null) {
                list.add(read);
            }
            for(i=0;i<list.size();i++){
                    System.out.println(list.get(i));
                    String s[]=list.get(i).split("\t");
                    path=s[0];
                    fw=new FileWriter("f:\\Test\\"+path+".txt");
                    bw=new BufferedWriter(fw);
                   bw.write(s[1]);
                   Thread.currentThread().sleep(1000);
            }
            }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(br!=null){
                    br.close();
                }
                if(file!=null){
                    file.close();
                }
                if(bw!=null){
                    bw.close();
                }
                if(fw!=null){
                    fw.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return list;

    }
    public static  void main(String args[]) {
        Test.listread("f:\\Test\\test.txt");

    }
}
