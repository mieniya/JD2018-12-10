package by.it.dziomin.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB extends TaskA {

    public static void main(String[] args) {
        String path = TaskA.getPass(TaskB.class, "TaskB.txt");
        String result = readFromFile(path);
        System.out.println(result);

        path = TaskA.getPass(TaskB.class, "resultTaskB.txt");
        TaskA.printToFile(result, path, false);
    }

    private static String readFromFile(String path) {

        Pattern patterWords = Pattern.compile("[А-Яа-яёЁ]+");
        Matcher matchWords;
        int words = 0;

        Pattern patternPunctuation = Pattern.compile("[,!?.:;]");
        Matcher matchPunct;
        int punctuation = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String str = reader.readLine();
                matchWords = patterWords.matcher(str);
                matchPunct = patternPunctuation.matcher(str);
                while (matchWords.find()) {
                    words++;
                }
                while (matchPunct.find()) {
                    punctuation++;
                }
            }
            return ("words=" + words + ", punctuation marks=" + punctuation);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return null;
    }

}
