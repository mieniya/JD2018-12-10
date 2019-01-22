package by.it.skosirskiy.jd01_14;
/*В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TEST {


    private static String dir (Class<?> cl){
        String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }
    public static void main(String[] args)  {
        System.out.println(dir(TEST.class));
    }

}
