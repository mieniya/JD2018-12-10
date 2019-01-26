package by.it.kushnerov.jd01_14;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        System.out.println(path);
        return path+filename;
    }


    public static void main(String[] args) {
        String path = getPath(TaskA.class,"dataTaskA.bin");
        System.out.println(path);

        getBinaryFileWithInt(path);

        List<Integer> list = new ArrayList<>();
        double sum=0;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))){
            while (dis.available()>0){
                int i = dis.readInt();
                sum+=i;
                list.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer i : list){
            System.out.println(i+" ");
        }
        System.out.println("\navg=" + sum / list.size());

        String txtOut = getPath(TaskA.class, "resultA.txt");
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(txtOut));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getBinaryFileWithInt(String path) {
        try(
                FileOutputStream fos = new FileOutputStream(path);
                DataOutputStream dos = new DataOutputStream(fos);
        )
        {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*50)-25);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
