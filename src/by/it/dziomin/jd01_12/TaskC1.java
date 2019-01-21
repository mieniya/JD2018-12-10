package by.it.dziomin.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {

        Map<Integer, String> words = new TreeMap<>();
        Map<String, Integer> wordsTemp = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int shifr = 0;

        // Ввод строк
        while (true) {
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            while (words.containsKey(shifr)) {
                shifr = new Random().nextInt(1000);
            }
            words.put(new Random().nextInt(1000), input);

        }
        System.out.println(words);

        // Удаление дублирующихся элементов с помощью временной Map
        for (Map.Entry<Integer, String> entry : words.entrySet()) {
            wordsTemp.put(entry.getValue(), entry.getKey());
        }
        words.clear();
        for (Map.Entry<String, Integer> entry : wordsTemp.entrySet()) {
            words.put(entry.getValue(), entry.getKey());
        }

        System.out.println(words);
    }
}


