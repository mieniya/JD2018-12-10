package by.it.zagurskaya.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String path = getPath(TaskA.class, "text.txt");
        String exeption = null;
        System.out.println("words="+readTextFileWithWord(path, exeption)+", marks="+readTextFileWithMark(path,exeption));

    }

    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path + filename;
    }

    private static String readTextFileWithWord(String path, String value) {
        String regAllWord = " ";
        BufferedReader br = null;
        List<String> wordList = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((value = br.readLine()) != null) {
                value = value.replaceAll("[\\n,:;.]", " ");
                value = value.replaceAll("\\s[\\s]+", " ");
                wordList.addAll(Arrays.asList(value.split(regAllWord)));
            }
        } catch (NullPointerException | IOException e) {
            System.err.print("конец файла");
        }
        return Integer.toString(wordList.size());
    }

    private static String readTextFileWithMark(String path, String value) {
        String reg = "[,:;.]";
        Pattern pattern = Pattern.compile(reg);
        BufferedReader br = null;
        List<String> markList = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((value = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(value);
                while (matcher.find()) {
                    String mark = matcher.group();
                    markList.add(mark);
                   // System.out.println(word);
                }
            }
        } catch (NullPointerException | IOException e) {
            System.err.print("конец файла");
        }
        return Integer.toString(markList.size());
    }
}

