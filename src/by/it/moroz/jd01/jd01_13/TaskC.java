package by.it.moroz.jd01.jd01_13;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TaskC {

    private static ArrayDeque<Double> numbers = new ArrayDeque<>();
    private static String num;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; ) {
            try {
                num = scanner.nextLine();
                readData();
            } catch (Exception e) {
                i++;
            }
        }
        throw new Exception("Errors more than 10");
    }

    static void readData() throws Exception {
        try{
            double number = Double.parseDouble(num);
            numbers.addFirst(number);
        } catch (IllegalArgumentException e){
            Thread.sleep(100);
            for (Double number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            throw new Exception();
        }
    }
}
