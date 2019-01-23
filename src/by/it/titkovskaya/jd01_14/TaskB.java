package by.it.titkovskaya.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
В классе TaskB нужно выполнить следующие шаги:
 В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt
 */

public class TaskB {
    public static void main(String[] args) {
        File file = new File(TaskA.getPath(TaskB.class, "TaskB.txt"));
        StringBuilder sb = readTextFile(file);
        int wordsCount = getMatchesCount(sb, "[^?!()\":;,.\\s-]+");
        int punctuationCount = getMatchesCount(sb, "[?!()\":;,.-]+");
        System.out.println("words="+wordsCount);
        System.out.println("punctuation marks="+punctuationCount);
        printToFile(wordsCount, punctuationCount);
    }

    private static StringBuilder readTextFile(File file) {
        StringBuilder sb = new StringBuilder();
        int b;
        FileReader is = null;
        try {
            is = new FileReader(file);
            while ((b = is.read()) != -1) {
                sb.append((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb;
    }

    private static int getMatchesCount(StringBuilder sb, String regex) {
        int punctuationCount = 0;
        Pattern pattern2 = Pattern.compile(regex);
        Matcher matcher2 = pattern2.matcher(sb);
        while (matcher2.find()) {
            punctuationCount++;
        }
        return punctuationCount;
    }

    static void printToFile(int wordsCount, int punctCount) {
        String result = TaskA.getPath(TaskB.class, "resultTaskB.txt");
        File resultTask = new File(result);
        try (PrintWriter out = new PrintWriter(new FileWriter(resultTask))) {
            out.println("words="+wordsCount);
            out.println("punctuation marks="+punctCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
