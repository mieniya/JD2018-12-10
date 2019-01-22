package by.it.skosirskiy.jd01_14;

import java.io.File;

/* Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
формате file:имя_файла или dir:имя_каталога.
 Продублировать вывод в консоль в файл resultTaskC.txt*/
public class TaskC {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator +"by"+File.separator +"it"+File.separator +"skosyrskiy"+File.separator;
//        System.out.println("getProperty "+System.getProperty("user.dir"));
//        System.out.println("pacjage "+cl.getPackage());
//        System.out.println("getname "+cl.getName());
//        System.out.println("simplename "+cl.getSimpleName());
//        System.out.println("super "+cl.getSuperclass());
//        System.out.println("gettype "+cl.getTypeName());
//        System.out.println("name "+cl.getName());
    //    String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path ;
    }



    public static void main(String[] args) {

        File file = new File(dir(TaskC.class));
        System.out.println(dir(TaskC.class));
        System.out.println("file "+file.getParent());
        String [] array=file.list();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}