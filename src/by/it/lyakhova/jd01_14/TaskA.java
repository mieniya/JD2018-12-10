package by.it.lyakhova.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    private static String getPath(Class<?> clazz, String filename){
        //System.out.println(clazz.getName());
        //получаем информацию о классе
        String path = clazz.getName(); //полный путь к классу
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");//удаляем имя класса, для этого заменили на пустое множество
        path = path.replace(".", File.separator);//все встреченные точки заменим на File.separator
        //определяем где находится каталог src
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        //System.out.println(path);
        return path + filename;
    }
    public static void main(String[] args) {
        //универсальный метод дл обращения к файлу
        String path = getPath(TaskA.class, "dataTaskA.bin");
        System.out.println(path);

       // Sstem.out.println(System.getProperty("user.dir"));
        //String path = "/Users/anastasiyalyakhova/Documents/Study/JAVA/src/by/it/lyakhova/jd01_14";
        //String path = System.getProperty("user.dir") + "/src/by/it/lyakhova/jd01_14/dataTaskA.bin";

        //write Binary File With Int
        writeBinaryFileWithInt(path);

        List<Integer> list = new ArrayList<>();
        double sum = 0;
        // read binary file with int
        sum = readBinaryFileWithInt(path, list, sum);

        //print to console
        printToConsole(list, sum);

        //print to file
        printToFile(list);

    }

    private static void writeBinaryFileWithInt(String path) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream))
        {
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt((int)(Math.random()*50));
            }
            //Эксперимент с записью числа
           /* int i = 48+256*49+256*256*50+256*256*256*51;
            dataOutputStream.writeInt(i);
            System.out.println(i);*/
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static double readBinaryFileWithInt(String path, List<Integer> list, double sum) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))){
            while (dis.available()>0){
                int i = dis.readInt();
                sum+=i;
                list.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    private static void printToConsole(List<Integer> list, double sum) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        //System.out.println(list);
        System.out.println("\navg=" + sum/list.size());
    }

    private static void printToFile(List<Integer> list) {
        String txtOut = getPath(TaskA.class, "resultTaskA.txt");
        try(PrintWriter pw = new PrintWriter(new FileWriter(txtOut))) {
            for (Integer integer : list) {
                pw.print(integer + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
