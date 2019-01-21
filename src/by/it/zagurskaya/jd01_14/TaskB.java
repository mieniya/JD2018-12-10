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
        String result = "words=" + readTextFileWithWord(path) + ", marks=" + readTextFileWithMark(path);
        System.out.println(result);
        printToFile(result);
    }
    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path + filename;
    }
    private static String readTextFileWithWord(String path) {
        String regAllWord = " ";
        List<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String value = br.readLine(); value != null; value = br.readLine()) {
                value = value.replaceAll("[\\n,:!-;.]", " ");
                value = value.replaceAll("\\s[\\s]+", " ");
                wordList.addAll(Arrays.asList(value.split(regAllWord)));
            }
            System.out.println("конец файла");
        } catch (IOException e) {
            System.err.println("что-то пошло не так, т.к. " + e.getMessage());
        }
        return Integer.toString(wordList.size());
    }
    private static String readTextFileWithMark(String path) {
        String reg = "[,:!;.]";
        Pattern pattern = Pattern.compile(reg);
        List<String> markList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String value = br.readLine(); value != null; value = br.readLine()) {
                Matcher matcher = pattern.matcher(value);
                while (matcher.find()) {
                    String mark = matcher.group();
                    markList.add(mark);
                }
            }
            System.out.println("конец файла");
        } catch (IOException e) {
            System.err.println("что-то пошло не так, т.к. " + e.getMessage());
        }
        return Integer.toString(markList.size());
    }
    private static void printToFile(String result) {
        String txtOut = getPath(TaskA.class, "resultTaskB.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(txtOut))) {
            out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

