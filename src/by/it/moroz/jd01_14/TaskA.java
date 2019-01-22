package by.it.moroz.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static void main(String[] args) {

        String path = getPath(TaskA.class, "dataTaskA.bin");
        System.out.println(path);

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            //int i = 48 + 256 * 49 + 256 * 256 * 50 + 256 * 256 * 256 * 51;
           // dataOutputStream.writeInt(i);
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt((int) ((Math.random()*50)-25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>();
        double sum=0;

        try(DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            while (dis.available()>0){
                int i = dis.readInt();
                list.add(i);
                sum+=i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(list);
        //System.out.println("\navg="+sum/list.size());

        String txtOut = getPath(TaskA.class, "resultTaskA.txt");
        try(PrintWriter out = new PrintWriter(new FileWriter(txtOut))) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println("\navg="+sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getPath(Class<?> clazz, String fileName) {
        String name = clazz.getName();
        String simpleName = clazz.getSimpleName();
        name = name.replace(simpleName, "");
        name = name.replace(".", File.separator);
        name = System.getProperty("user.dir") + File.separator + "src" + File.separator + name;
        //System.out.println(name);
        return name + fileName;
    }

}
