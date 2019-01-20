package by.it.skosirskiy.jd01_12;

import java.util.*;


public class TaskC1 {
    private static Map<Integer, String> map=new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String str;

        while((!(str= scanner.next()).equals("end"))){
            int key=0;

            key=random();
            if (!map.containsKey(key)) {
                map.put(key, str);
            }

        }



    }

    private static Integer random(){
        return (int)Math.random()*1000;
    }
}
