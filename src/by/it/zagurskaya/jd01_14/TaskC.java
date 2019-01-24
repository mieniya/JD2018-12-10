package by.it.zagurskaya.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    public static void main(String[] args) {
        Path currentClassPath = Paths.get(getPath(TaskC.class));   // google = java get Path from string
        File currentClassPathFile = currentClassPath.toFile();
        File outputFile = currentClassPath.resolve("resultTaskC.txt").toFile();

        //System.out.println(currentClassPath);
        List<String> fileInfoStrings = new ArrayList<>();
        File[] inputFiles = currentClassPathFile.getParentFile().listFiles();
        for (File inputFile : inputFiles) {
            fileInfoStrings.addAll(getFileInfoStrings(inputFile));
        }

        printToFile(outputFile.getAbsolutePath(), fileInfoStrings);

    }

    private static String getPath(Class<?> clazz) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path;
    }

    private static List<String> getFileInfoStrings(File file) {
        List<String> fileInfoStrings = new ArrayList<>();

        if (file.isDirectory()) {
            String dirInfoString = "dir:" + file.getName();
            System.out.println(dirInfoString);
            fileInfoStrings.add(dirInfoString);
            File[] insideDirectoryFiles = file.listFiles();
            for (File item : insideDirectoryFiles) {
                fileInfoStrings.addAll(getFileInfoStrings(item));
            }
        } else {
            String fileInfoString = "file:" + file.getName();
            System.out.println(fileInfoString);
            fileInfoStrings.add(fileInfoString);
        }
        return fileInfoStrings;
    }

    private static void printToFile(String path, List<String> results) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            for (String result : results) {
                out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
