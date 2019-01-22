package by.it.yarmolenka.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String del = File.separator;
        path = path + del + "src" + del + "by" + del + "it" + del + "yarmolenka";
        File file = new File(path);
        StringBuilder listOfFiles = getFileList(file);
        System.out.println(listOfFiles);
        writeFileList(listOfFiles);
    }

    private static StringBuilder getFileList(File file) {
        StringBuilder sb = new StringBuilder();
        if (file.isFile()) sb.append("file:").append(file.getName()).append("\n");
        else {
            sb.append("dir:").append(file.getName()).append("\n");
            File[] files = file.listFiles();
            if (files != null)
                for (File file1 : files) {
                    sb.append(getFileList(file1));
                }
        }
        return sb;
    }

    private static void writeFileList(StringBuilder sb) {
        String path = TaskA.getPath(TaskC.class, "resultTaskC.txt");
        try (
            FileWriter fw = new FileWriter(new File(path))
        ){
            fw.append(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
