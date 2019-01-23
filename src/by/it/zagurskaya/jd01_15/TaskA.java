package by.it.zagurskaya.jd01_15;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskA {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = -15+(int)(Math.random());

            }
        }
        String filename = getPath(TaskA.class,"matrix.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(filename));
       }

    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path + filename;
    }
}
