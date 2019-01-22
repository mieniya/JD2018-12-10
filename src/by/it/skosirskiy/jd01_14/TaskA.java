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

    private static String src = System.getProperty("user.dir")+"\\src\\by\\it\\skosirskiy\\";
    private static String filename=src+"jd01_14/dataTaskA.bin";
    private static String filename1=src+"jd01_14/resultTaskA.txt";
    static File f = new File(filename);
    static File f1 = new File(filename1);
    static Collection<Integer> col = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        getRandomMas();


        try (DataInputStream inp = new DataInputStream(new BufferedInputStream
                (new FileInputStream(filename)))) {
            double sum=0;
            double count=0;
            Integer value=0;
            while (inp.available()>0){
                value=(inp.readInt());
                col.add(value);
                count++;
                sum=sum+value;
                System.out.print(value+" ");
            }
            System.out.println("avg="+ sum/count);

        }
        catch (IOException e){
            System.out.println("FilenotFound: "+filename);
        }

        DataOutputStream dos =null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f1));
            for (Integer element : col) {
                dos.writeInt(element);
            }

        }
        catch (IOException e){
            System.out.println("FilenotFound: "+filename);
        }
        finally {
            if(dos!=null){dos.close();}
        }



    }



    private static void getRandomMas() throws IOException {
        DataOutputStream dos =null;
        try {
           dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random()*3000));
                }
        }
        catch (IOException e){
            System.out.println("FilenotFound: "+filename);
        }
        finally {
            if(dos!=null){dos.close();}
        }
    }


}
