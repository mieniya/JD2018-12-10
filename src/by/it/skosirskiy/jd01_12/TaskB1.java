package by.it.skosirskiy.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskB1 {
    private static Map<String, Integer> hashmap=new HashMap<String, Integer>();
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String str;


        while((!(str= scanner.next()).equals("end"))){
           if(hashmap.containsKey(str)){
               hashmap.put(str,hashmap.get(str)+1);


           }
           else hashmap.put(str, 1);
        }
        System.out.println(hashmap);

    }

}
