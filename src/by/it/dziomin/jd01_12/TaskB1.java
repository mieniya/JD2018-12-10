package by.it.dziomin.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("[a-z'A-Z]+");
        Matcher matcher;
        while (true) {
            String input = sc.next();
            matcher = pattern.matcher(input);
            if (input.equals("end")) {
                break;
            }
            while (matcher.find()) {
                words.add(matcher.group());
            }
        }

        System.out.println("words:" + words);

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int newCount;
            if (map.containsKey(word)) {
                newCount = map.get(word) + 1;
            } else {
                newCount = 1;
            }
            map.put(word, newCount);
        }
        System.out.println("map:" + map);

    }

}