package by.it.lyakhova.jd01_12;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String reg = "[-A-Za-z']+";
        Pattern pattern = Pattern.compile(reg);
        StringBuilder text = new StringBuilder();

        String line;
        while (!"end".equalsIgnoreCase(line = scanner.nextLine())) {

            text.append(" ").append(line);

        }
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (!words.containsKey(matcher.group())) words.put(matcher.group(), 1);
            else {
                Integer value = words.get(matcher.group()) + 1;
                words.put(matcher.group(), value);
            }
        }

        for (Map.Entry<String, Integer> entry: words.entrySet()){

            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("%s=%d ", key, value);
        }
        //System.out.println(words);
    }
}
