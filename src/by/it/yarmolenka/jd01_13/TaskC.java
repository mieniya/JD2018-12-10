package by.it.yarmolenka.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static List<Double> list = new ArrayList<>();
    private static String line;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int err = 0;
        while (err < 5) {
            line = sc.next();
            try {
                readData();
            } catch (Exception e){
                err++;
            }
        }
        throw new Exception("error");
    }

    private static void readData() throws Exception {
        try {
            list.add(Double.parseDouble(line));
        } catch (IllegalArgumentException e) {
            Thread.sleep(100);
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            throw new Exception();
        }

    }
}
