package by.it.subach.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counters = new int[0];

    private static int processOneWord(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String reg = "[а-яА-ЯёЁ]+";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = (matcher.group());
            int p = processOneWord(word);
            if (p >= 0) {
                counters[p]++;
            } else {
                int last = words.length;
                words = Arrays.copyOf(words, last + 1);
                words[last] = word;
                counters = Arrays.copyOf(counters, last + 1);
                counters[last] = 1;
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + "=" + counters[i]);
        }
    }
}





