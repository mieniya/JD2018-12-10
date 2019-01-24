package by.it.zagurskaya.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static final String CDPrev = "cd..";
    private static final String CDNext = "cd ";
    private static final String DIR = "dir";
    private static final String END = "end";

    public static void main(String[] args) throws IOException {
        Path currentPath = Paths.get(getPath(TaskC.class));
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

    private static Path getDIR(Path path) throws IOException {
        Path currentClassPath = path;
        File currentClassPathFile = currentClassPath.toFile();
        List<String> fileInfoStrings = new ArrayList<>();
        File[] inputFiles = currentClassPathFile.listFiles();
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

//        System.out.println("lastAccessTime: " + attr.lastAccessTime());
//        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

        String modifailTime = attr.lastModifiedTime().toString();
        modifailTime = modifailTime.replace("T","  ");
        modifailTime = modifailTime.split("\\.", 2)[0];

        System.out.printf("%-11s",modifailTime);
        System.out.printf("%-11s","   <DIR>    ");
        System.out.printf("%-11s","           ");
        System.out.printf("%-11s",".");
        System.out.println();
        System.out.printf("%-11s",modifailTime);
        System.out.printf("%-11s","   <DIR>    ");
        System.out.printf("%-11s","           ");
        System.out.printf("%-11s","..");
        System.out.println();

        for (File inputFile : inputFiles) {
            getFileInfoStrings(inputFile);
        }
        return path;
    }

    private static void getFileInfoStrings(File file) throws IOException {
        Path directoryPath = Paths.get(file.getAbsolutePath());
        BasicFileAttributes attr = Files.readAttributes(directoryPath, BasicFileAttributes.class);

        if (file.isDirectory()) {

            String modifailTime = attr.lastModifiedTime().toString();
            modifailTime = modifailTime.replace("T","  ");
            modifailTime = modifailTime.split("\\.", 2)[0];
            // Не правильно показывает время?????
            System.out.printf("%-11s",modifailTime);
            System.out.printf("%-11s","   <DIR>    ");
            System.out.printf("%-11s","           ");
            System.out.printf("%-11s",file.getName());
            System.out.println();

        } else {
            String modifailTime = attr.lastModifiedTime().toString();
            modifailTime = modifailTime.replace("T","  ");
            modifailTime = modifailTime.split("\\.", 2)[0];

            System.out.printf("%-11s",modifailTime);
            System.out.printf("           ");
            System.out.printf("%,11d",attr.size());
            System.out.printf(" ");
            System.out.printf("%-11s",file.getName());
            System.out.println();
        }
    }
}
