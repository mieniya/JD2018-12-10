package by.it.zagurskaya.jd01_13;

import java.util.*;

public class TaskC {

    static Scanner scanner;
    static List<Double> expressionList;


    public static void main(String[] args) throws InterruptedException {

        scanner = new Scanner(System.in);
        expressionList = new ArrayList<>();

        int countException = 0;
        while (true) {
            try {
                readData();
            } catch (NumberFormatException e) {
                if (countException < 5) {
                    Thread.sleep(100);
                    invertPrintList(expressionList);
                    countException++;
                } else {
                    throw e;
                }
            }

        }

    }

    static void readData() {
        String expr = scanner.nextLine();
        expressionList.add(Double.parseDouble(expr));
    }

    static void invertPrintList(List<Double> listExp) {
        List<Double> reverseOrderList = new ArrayList<>(listExp);
        Collections.reverse(reverseOrderList);

        for (Double aDoubles : reverseOrderList) {
            System.out.print(aDoubles + " ");
        }
    }
}
