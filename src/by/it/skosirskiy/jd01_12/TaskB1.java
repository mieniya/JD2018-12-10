package by.it.skosirskiy.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class TaskB1 {
    private static Map<String, Integer> hashmap=new HashMap<String, Integer>();
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String str;
        System.out.println("do while");

        while((!(str= scanner.next()).equals("end"))){

           String strbuf = str.replaceAll("[*,-.—:;]", "");
           if (!(strbuf.isEmpty())) {
           if(hashmap.containsKey(strbuf)){
               hashmap.put(strbuf,hashmap.get(strbuf)+1);
           }
           else hashmap.put(strbuf, 1);
         }
    }
        System.out.println(hashmap);
        }
    }


