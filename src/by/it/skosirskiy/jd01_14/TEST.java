package by.it.skosirskiy.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
формате file:имя_файла или dir:имя_каталога.
 Продублировать вывод в консоль в файл resultTaskC.txt*/
public class TEST {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        System.out.println("cl.getName(  "+cl.getName());
        System.out.println("System.getProperty  "+System.getProperty("user.dir"));
        System.out.println("path  "+path);
        System.out.println("getpackage "+cl.getPackage());
        return path + clDir;
    }


    public static void main(String[] args) {

            File buf = new File(dir(TaskC.class));
            File file = new File(buf.getParent());
        System.out.println("dir"+dir(TaskC.class));




    }


}