package by.it.subach.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String word = scanner.next();
            if (word.equalsIgnoreCase("end"))    break;
            else{
                word = word.replaceAll("[;:?!,\\-\\.]", "");
//                map.merge(word, 1, Integer::sum);
                map.putIfAbsent(word, 0);
                map.put(word, map.get(word) + 1);
            }
        }


        System.out.println(map);
    }
}
