package by.it.dziomin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String reg = "(?<=[а-яё])[.!]\\s+";
        String[] sentence = Poem.text.split(reg);
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = delSlashN(sentence[i]);
        }

        sentence = sortSentences(sentence);
        for (String s : sentence) {
            System.out.print(s + "\n");
        }
    }

    private static String delSlashN(String sentence) {
        String regular = " {2,}";
        Pattern pattern = Pattern.compile(regular);

        String newSentence = sentence.replace('\n', ' ');
        newSentence = newSentence.replace(';', ' ');
        newSentence = newSentence.replace(':', ' ');
        newSentence = newSentence.replace('-', ' ');
        newSentence = newSentence.replace(',', ' ');
        newSentence = newSentence.replace('.', ' ');
        Matcher matcher = pattern.matcher(newSentence);
        while (matcher.find()) {
            newSentence = matcher.replaceAll(" ");
        }
        newSentence = newSentence.trim();
        return newSentence;
    }

    private static String[] sortSentences(String[] sentences) {
        String tempString;
        for (int i = 0; i < sentences.length - 1; i++) {
            for (int j = 0; j < sentences.length - 1 - i; j++) {
                if (sentences[j].length() > sentences[j + 1].length()) {
                    tempString = sentences[j];
                    sentences[j] = sentences[j + 1];
                    sentences[j + 1] = tempString;
                }
            }
        }
        return sentences;
    }

}
