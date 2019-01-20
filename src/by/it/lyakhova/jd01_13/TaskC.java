package by.it.lyakhova.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner;

    static void readData() throws Exception{
        int count = 0;
        ArrayList<Double> list = new ArrayList<>();

        while (true) {
            try {
                double number = Double.parseDouble(scanner.next());
                list.add(number);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                for (int i = list.size()-1; i > -1; i--) {
                    System.out.print(list.get(i) + " ");
                }

                if (++count == 5) throw new Exception(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();

    }
}
