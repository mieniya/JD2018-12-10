package by.it.skosirskiy.jd01_060;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-яёЁ]]+");
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find()) {
            int start = matcher.start();
                sb.setCharAt(start, '#');

        }
        System.out.println(sb);
    }
}
