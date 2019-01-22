package by.it.skosirskiy.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/*Вариант А. В классе TaskA нужно выполнить следующие шаги:
 Записать в двоичный файл dataTaskA.bin 20 случайных чисел типа Integer.
 Файл должен быть в том же каталоге, что и исходный код для класса
TaskA.java.
 Затем нужно прочитать записанный файл в коллекцию ArrayList.
 Вывести в консоль прочитанные числа через пробел
 Вывести с новой строки их среднее арифметическое avg=20.123.
 Продублировать вывод в консоль в файл resultTaskA.txt*/
public class TaskA {
    private static String dir (Class<?> cl){
        String path=System.getProperty("user.dir")+File.separator+"src"+File.separator;
        String clDir=cl.getName().replace(cl.getSimpleName(),"").replace(".",File.separator);
        return path+clDir;

    }
    public static void main(String[] args) {
        System.out.println(dir(TaskA.class));
        DataOutputStream dos=null;
        try {
            dos=new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(dir(TaskA.class)+"dataTaskA.bin")));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random()*25));
            }
        }
        catch (IOException e){}
        finally {
            if(dos !=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream inp=new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class)+"dataTaskA.bin")));
                PrintWriter out2= new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskA.txt"))
        ){
                double sum=0;
                double count=0;
                while (inp.available()>0){
                    int value=(inp.readInt());
                    System.out.print(value+" ");
                    out2.print(value+" ");
                    count++;
                    sum=sum+value;
                }
            System.out.println("\navg="+sum/count);
                out2.print("\navg="+sum/count);

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
