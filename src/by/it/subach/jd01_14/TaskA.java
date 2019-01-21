package by.it.subach.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    static String getPath(Class<?> clazz, String filename){
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        System.out.println(path);
        return path+filename;
    }

    public static void main(String[] args) {

        String path = getPath(TaskA.class, "dataTaskA.bin");
        System.out.println(path);

        try(
            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream dos = new DataOutputStream(fos)
        )
        {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int)(Math.random()*50));
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>();
        double sum = 0;
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(path));
            while (dis.available() >0){
                int i = dis.readInt();
                sum += i;
                list.add(i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

//        print to console
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println(list);
        System.out.println("avg = " + sum/list.size());

//        print to file

        String txtOut = getPath(TaskA.class, "resultTaskA.txt");
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(txtOut));
            for (Integer integer : list) {
                pw.print(integer + " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
