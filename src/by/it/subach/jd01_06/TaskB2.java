package by.it.subach.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    static String [] sentence;


    public static void main(String[] args) {
        String poem = Poem.text;
        sentenceToArray(poem);
        sortSentence(sentence);
        printSentence(sentence);
    }

    private static String[] sentenceToArray(String str) {
        str = str.replaceAll("\\n+", " " );
        str = str.replaceAll("\\.\\.\\.+", " ");
        str = str.replaceAll("[ -]+", " ");
        sentence = str.split("[.!?]");

        Pattern pattern = Pattern.compile("\\p{Punct}");
        for (int i = 0; i < sentence.length; i++) {
            StringBuilder sb = new StringBuilder(sentence[i]);
            Matcher matcher = pattern.matcher(sb);
            int start = 0;
            while (matcher.find(start)) {
                int find = matcher.start();
                sb.deleteCharAt(find);
                start = find + 1;
            }
            sentence[i] = sb.toString().trim();


        }
        return sentence;
    }

    private static void sortSentence(String[] str) {
        boolean change;
        int counter = str.length - 1;
        do {
            change = false;
            for (int i = 0; i < counter; i++) {
                if (str[i].length() > str[i + 1].length()) {
                    String temp = str[i + 1];
                    str[i + 1] = str[i];
                    str[i] = temp;
                    change = true;
                }
            }
            counter--;
        } while (change == true);
    }

    private static void printSentence(String[] str) {
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }


}



