package by.it.zagurskaya.jd01_15;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static final String CDPrev = "cd..";
    private static final String CDNext = "cd ";
    private static final String DIR = "dir";
    private static final String END = "end";

    public static void main(String[] args) {
        Path currentPath = Paths.get(getPath(TaskC.class));   // google = java get Path from string
        File currentClassPathFile = currentPath.toFile();


        String expression;
        Scanner scanner = new Scanner(System.in);

        while (!(expression = scanner.nextLine()).equals(END)) {
            if (expression.contains(DIR)) {
                currentPath = getDIR(currentPath);

            } else if (expression.contains(CDNext)) {
                currentPath = getCDNext(currentPath,expression);

            } else if (expression.contains(CDPrev)) {
                currentPath = getCDPrev(currentPath);
            } else {
                System.out.println("не верно введена команда!!!");
            }
        }
    }

    private static String getPath(Class<?> clazz) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        System.out.println(path);
        return path;
    }

    private static Path getCDNext(Path path, String directory) {
        directory = directory.replace("cd ","\\");
        String directotyPath = path.toString()+directory;
        File filePath = new File(directotyPath);

        if (filePath.isDirectory()) {
            System.out.println(Paths.get(directotyPath));
            return Paths.get(directotyPath);
        } else {
            System.out.println("нет каталога "+directory);
            System.out.println(path);
            return path;
        }
    }

    private static Path getCDPrev(Path path) {
        Path rootPath = Paths.get(System.getProperty("user.dir"));
        if (path != rootPath) {
            System.out.println(path.getParent());
            return path.getParent();
        } else {
            System.out.println(rootPath);
            return rootPath;
        }
    }

    private static Path getDIR(Path path) {
        Path currentClassPath = path;   // google = java get Path from string
        File currentClassPathFile = currentClassPath.toFile();
        List<String> fileInfoStrings = new ArrayList<>();
        File[] inputFiles = currentClassPathFile.listFiles();
        for (File inputFile : inputFiles) {
            fileInfoStrings.addAll(getFileInfoStrings(inputFile));
        }
        return path;
    }

    private static List<String> getFileInfoStrings(File file) {
        List<String> fileInfoStrings = new ArrayList<>();

        if (file.isDirectory()) {
            String dirInfoString = "dir:" + file.getName();
            System.out.println(dirInfoString);
            ///????????????
            //System.out.println(Files.getAttribute());
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
}
