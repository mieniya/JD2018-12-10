package by.it.skosirskiy.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/* Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
формате file:имя_файла или dir:имя_каталога.
 Продублировать вывод в консоль в файл resultTaskC.txt*/
public class TaskC {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }
    public static void main(String[] args) {

        File buf = new File(dir(TaskC.class));
        File file = new File(buf.getParent());
        printAllFolderNameAndFilename(file);
        
    }
    private static void printAllFolderNameAndFilename(File file) {
        try (PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskC.class) + "resultTaskC.txt"));
        ) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println("dir:" + item.getName());
                    out2.println("dir:" + item.getName());
                    printAllFolderNameAndFilename(item);
                } else {
                    System.out.println("file:" + item.getName());
                    out2.println("file:" + item.getName());
                }
            }
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}