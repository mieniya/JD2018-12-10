package by.it.moroz.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    public static void main(String[] args) {

        String path = getPath("dataTaskA.bin");
        System.out.println(path);

        writeBinaryFileWithInt(path);
        List<Integer> list = new ArrayList<>();
        double sum=0;
        sum = readBinaryFileWithInt(path, list, sum);
        printToConsole(list, sum);
        printToFile(list, sum);
    }

    private static double readBinaryFileWithInt(String path, List<Integer> list, double sum) {
        try(DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            while (dis.available()>0){
                int i = dis.readInt();
                list.add(i);
                sum+=i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }

    private static void writeBinaryFileWithInt(String path) {
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
    }

    private static void printToConsole(List<Integer> list, double sum) {
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println("\navg="+sum/list.size());
    }

    private static void printToFile(List<Integer> list, double sum) {
        String txtOut = getPath("resultTaskA.txt");
        try(PrintWriter out = new PrintWriter(new FileWriter(txtOut))) {
            for (Integer integer : list) {
               out.print(integer+" ");
            }
            out.println("\navg="+sum/list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(String fileName) {
        String name = TaskA.class.getName();
        String simpleName = TaskA.class.getSimpleName();
        name = name.replace(simpleName, "");
        name = name.replace(".", File.separator);
        name = System.getProperty("user.dir") + File.separator + "src" + File.separator + name;
        return name + fileName;
    }

}
