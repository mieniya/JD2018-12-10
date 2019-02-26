package by.it.moroz.jd01.jd01_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String text = reader.readLine();
            if (text.equals("end")) break;
            sb.append(text).append(" ");
        }

        Map<String, Integer> words = new HashMap<>();

        String reg = "[a-zA-Z'?]+";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            if (words.containsKey(matcher.group())) {
                int count= words.get(matcher.group());
                count++;
                words.put(matcher.group(), count);
            } else words.put(matcher.group(), 1);
        }
        for (Map.Entry<String, Integer> pair : words.entrySet()){
            System.out.println(pair.getKey()+"="+pair.getValue());
        }

    }
}
