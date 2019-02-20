package by.it.moroz.jd01.jd01_14;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {

        String fileName = getPath("text.txt");
        int countWords = 0;
        int countPunct = 0;
        countWords = getCountWords(fileName, countWords);
        countPunct = getCountPunct(fileName, countPunct);
        //print to console
        System.out.println("words="+countWords + ", punctuation marks=" + countPunct);
        printToFile(countWords, countPunct);
    }

    private static int getCountWords(String fileName, int countWords) {
        try(Scanner scanner = new Scanner(new FileReader(new File(fileName)))) {
            Pattern patWord = Pattern.compile("[а-яА-яё]+");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matWord = patWord.matcher(line);
                while (matWord.find())
                    countWords++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countWords;
    }

    private static int getCountPunct(String fileName, int countPunct) {
        try(Scanner scanner = new Scanner(new FileReader(new File(fileName)))) {
            Pattern patPunct = Pattern.compile("\\p{Punct}+");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matPunct = patPunct.matcher(line);
                while (matPunct.find())
                    countPunct++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countPunct;
    }

    private static void printToFile(int countWords, int countPunct) {
        String txtOut = getPath("resultTaskB.txt");
        try(PrintWriter out = new PrintWriter(new FileWriter(txtOut))) {
            out.println("words="+countWords+", punctuation marks="+countPunct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(String fileName) {
        String name = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        name = name.replace(simpleName, "");
        name = name.replace(".", File.separator);
        name = System.getProperty("user.dir") + File.separator + "src" + File.separator + name;
        return name + fileName;
    }
}
