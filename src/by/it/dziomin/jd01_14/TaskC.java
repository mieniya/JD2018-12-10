package by.it.dziomin.jd01_14;

import java.io.File;

public class TaskC extends TaskB {


    private static String path;

    public static void main(String[] args) {

        path = TaskA.getPass(TaskC.class, "resultTaskC.txt");
        File file = new File(path);
        File currentDir = file.getParentFile().getParentFile();
        getListFiles(currentDir);
    }

    private static void getListFiles(File dir) {
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("dir:" + file.getName());
                TaskA.printToFile("\ndir:" + file.getName(), path, true);
                getListFiles(file);
            } else {
                System.out.println("file:" + file.getName());
                TaskA.printToFile("\nfile:" + file.getName(), path, true);
            }
        }
    }

}
