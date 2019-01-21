package by.it.dziomin.jd01_13;

import java.util.*;

public class TaskC extends TaskB{
    private static Scanner scanner;
    private static int errCount = 0;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        readData();
    }

    private static void readData() {
        LinkedList<Double> list = new LinkedList<>();

        while (true) {
            String str = readFromScanner(scanner);
            processData(list, str);
        }
    }

    private static void processData(LinkedList<Double> list, String str) {
        try {
            list.addFirst(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            handleException(e, list);
        }
    }

    private static void handleException(Exception e, LinkedList<Double> list) {
        errCount++;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            System.err.println("Exception while sleep: " + e1.getMessage());
        }

        for (Double aDouble : list) {
            System.out.print(aDouble + " ");
        }

        if (errCount >= 4) {
            throw new Error(e);
        }
    }
}
