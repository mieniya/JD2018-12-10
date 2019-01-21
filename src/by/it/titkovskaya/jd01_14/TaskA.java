package by.it.titkovskaya.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
В классе TaskA нужно выполнить следующие шаги:
 Записать в двоичный файл dataTaskA.bin 20 случайных чисел типа Integer.
 Файл должен быть в том же каталоге, что и исходный код для класса
TaskA.java.
 Затем нужно прочитать записанный файл в коллекцию ArrayList.
 Вывести в консоль прочитанные числа через пробел
 Вывести с новой строки их среднее арифметическое avg=20.123.
 Продублировать вывод в консоль в файл resultTaskA.txt
 */
public class TaskA {

    private static String getPath(Class<?> clazz, String filename){
        String path = clazz.getName();
        path=path.replace(clazz.getSimpleName(),"");
        path=path.replace(".", File.separator);
        path=System.getProperty("user.dir")+File.separator+"src"+File.separator+path;
        return path+filename;
    }

    public static void main(String[] args) {
        String path = getPath(TaskA.class,"dataTaskA.bin");
        System.out.println(path);
        //write
        writeBinaryFileWithInt(path);

        List<Integer> list = new ArrayList<>();
        double sum = 0;
        //read
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            while (dis.available()>0){
                int i = dis.readInt();
                sum+=i;
                list.add(i);
            }
        }catch (IOException e){
            e.getStackTrace();
        }
        //print to console
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println("\navg="+sum/list.size());

        //print to file
        String txtOut = getPath(TaskA.class, "resultTaskA.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(txtOut))){
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBinaryFileWithInt(String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             DataOutputStream dos = new DataOutputStream(fos))
        {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random()*51));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
