package by.it.skosirskiy.jd01_14;
/*В файле с текстом TaskB.txt нужно подсчитать общее количество знаков
препинания и слов
 Вывести результат на консоль в виде одной строки:
words=123, punctuation marks=15
 Продублировать вывод в консоль в файл resultTaskB.txt*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static int countWords=0;
    private static int countpunctuation=0;
    private static Pattern pattern = Pattern.compile("[а-яА-яёЁ]+");
    private static Pattern pattern1=Pattern.compile("[-,.:!]+");

    private static String dir (Class<?> cl){
        String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;
    }
    public static void main(String[] args)  {
        System.out.println(dir(TaskB.class));
        try (BufferedReader br = new BufferedReader(
                new FileReader(dir(TaskA.class)+"text.txt"));
             PrintWriter out2=new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskB.txt"))
        ) {
            while (br.ready()){
                String buf = br.readLine();
                System.out.println(buf);
                Matcher matcher = pattern.matcher(buf);
                while (matcher.find()){
                   countWords++;
                }
                Matcher matcher1 = pattern1.matcher(buf);
                while (matcher1.find()){
                    countpunctuation++;
                }
            }
            System.out.println("words="+countWords+", punctuation marks="+countpunctuation);
            out2.println("words="+countWords+", punctuation marks="+countpunctuation);
        }
        catch (IOException e){}
    }

}
