package by.it.yarmolenka.jd01_15;

import java.io.*;

/**
 * комментарий комментарий комментарий комментарий комментарий комментарий
 * комментарий комментарий комментарий комментарий комментарий комментарий
 * комментарий комментарий комментарий комментарий комментарий комментарий
 */

public class TaskB {
    public static void main(String[] args) {
        String path = TaskA.getPath(TaskB.class) + "TaskB.java";
        StringBuilder sb = new StringBuilder();

        try (RandomAccessFile file = new RandomAccessFile(path, "r")){
            long n = 0;
            while ((char)file.read()!='/');






        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
