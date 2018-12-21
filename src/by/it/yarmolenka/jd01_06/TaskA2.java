package by.it.yarmolenka.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counter = new int[0];

    private static void processOneWord(String word) {
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (str.equals(word)) {
                counter[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length+1);
        words[words.length-1]=word;
        counter = Arrays.copyOf(counter, counter.length+1);
        counter[counter.length-1]=1;
    }

    public static void main(String[] args) {
        Pattern p1 = Pattern.compile("[А-Яа-яЁё]+");
        Matcher m1 = p1.matcher(Poem.text);
        while (m1.find()) {
            processOneWord(m1.group());
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counter[i]);
        }
    }

}

