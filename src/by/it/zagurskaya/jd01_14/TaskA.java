package by.it.zagurskaya.jd01_14;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA {
    static String getPath(Class<?> clazz, String filenamr) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + path;
        System.out.println(path);
        return path + filenamr;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(System.getProperty("user.dir"));
//        String path=System.getProperty("user.dir")+"/src/by/it/zagurskaya/JD2018-12-10/dataTaskA";
        String path = getPath(TaskA.class, "dataTaskA.bin");
        System.out.println(path);

        try (
                FileOutputStream fos = new FileOutputStream(path);
                DataOutputStream dos = new DataOutputStream(fos);
        ) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 51));
            }
//            int i = 48+256*49+256*256*50+256*256*256*256*51;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<>();
        double summa = 0;
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(path));
        ) {
            while (dis.available() > 0) {
                int i = dis.readInt();
                summa = summa + i;
                list.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer integer: list) {
            System.out.println(integer+" ");
        }
        System.out.println("\navg" + summa/ list.size());
    }
}

