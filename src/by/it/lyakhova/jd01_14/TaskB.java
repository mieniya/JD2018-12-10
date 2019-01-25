package by.it.lyakhova.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {
        //path to files
        String path = getPath(TaskB.class, "text.txt");
        String txtOut = getPath(TaskB.class, "resultTaskB.txt");

        StringBuilder buf = new StringBuilder();

        //read file with text
        readFileWithText(path, buf);

        //count words
        int words = countPatterns(buf, "[А-Яа-яЁё]+");

        //count marks
        int marks = countPatterns(buf, "[\\p{P}]+");

        //Print to file
        printToFile(txtOut, words, marks);

        //print to console
        System.out.println("words=" + words + ", punctuation marks="+marks);
    }

    private static void readFileWithText(String path, StringBuilder buf) {
        int b;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            while ((b = reader.read())!=-1){
                buf.append((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToFile(String txtOut, int words, int marks) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(txtOut))) {
            String str = "words=" + words + ", punctuation marks="+marks;
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countPatterns(StringBuilder buf, String s) {
        Matcher matchWords = Pattern.compile(s).matcher(buf);
        int pattern = 0;
        while (matchWords.find()) {
            pattern++;
        }
        return pattern;
    }

    private static String getPath(Class<?> clazz, String filename) {
        //получаем информацию о классе
        String path = clazz.getName(); //полный путь к классу
        path = path.replace(clazz.getSimpleName(), "").replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }
}
