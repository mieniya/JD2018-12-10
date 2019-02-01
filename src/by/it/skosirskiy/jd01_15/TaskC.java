package by.it.skosirskiy.jd01_15;
/*Класс TaskC Нужно реализовать на java приложение - аналог командной строки Windows. Приложение должно
использовать класс File и поддерживать две команды консоли:
 команду cd - смена каталога (посмотрите пример: Win+R → cmd → cd \ → dir ). В тестах проверяются всего
две команды cd .. и cd имя_папки_в_текущем_каталоге
 команду dir - вывод каталога, формат вывода - аналогичный формату в Windows.
 команда end – завершение работы.
 Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.jd01_15.
*/

import java.io.*;
import java.util.Scanner;

public class TaskC {
    static String src = System.getProperty("user.dir")+"\\src\\by\\it\\skosirskiy\\";
    static String dir = src+"jd01_15\\";
    static String line;

    private static void printFolderNameAndFilename(File file) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println("dir:" + item.getName());
                } else {
                    System.out.println("file:" + item.getName());
                   }
            }
    }

    public static void main(String[] args) {
        File file = new File(dir);


        Scanner scan = new Scanner(System.in);
        System.out.println("стартовый каталог: "+file);
        while (!(line = scan.nextLine()).equals("end")){

            if (line.equals("cd ..")){
                file= file.getParentFile();
                System.out.println(file);

            }
            else if(line.equals("dir")){
                printFolderNameAndFilename(file);
            }
                else    {line=line.replace("cd ","");
                System.out.println(line);
                file=openFolder(line, file);}
                }
        }








    private static File openFolder(String string, File file) {
       File file1 = new File(file.getAbsoluteFile()+"\\"+string);
    return file1;
    }


}
