package by.it.moroz.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class TaskC {

    public static void main(String[] args) {
        String name = System.getProperty("user.dir") + "/src/by/it/moroz";
        name = name.replace("/", File.separator);

        File fileName = new File(name);

        File[] list = fileName.listFiles();
        assert list != null;
        for (File file : list) {
            if (file.isDirectory())
                System.out.println("dir:" + file.getName());
            File files = new File(name, file.getName());
            for (File listFile : Objects.requireNonNull(files.listFiles())) {
                if (listFile.isDirectory())
                    System.out.println("dir:" + listFile.getName());
                if (listFile.isFile())
                    System.out.println("file:" + listFile.getName());
            }
            if (file.isFile())
                System.out.println("file:" + file.getName());
        }
        printToFile(fileName);
    }

    private static void printToFile(File fileName) {
        String txtOut = System.getProperty("user.dir") + "/src/by/it/moroz/jd01_14/resultTaskC.txt";
        try (PrintWriter out = new PrintWriter(new FileWriter(txtOut))) {
            File[] list = fileName.listFiles();
            assert list != null;
            for (File file : list) {
                if (file.isDirectory())
                    out.println("dir:" + file.getName());
                if (file.isFile())
                    out.println("file:" + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
