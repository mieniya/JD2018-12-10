package by.it.subach.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static List<Double> inputs = new ArrayList<>();
    private static String input;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int errors = 0;
        while (errors < 5) {
            input = scanner.next();
            try {
                readData();
            } catch (Exception e) {
                errors++;
            }
        }
        throw new Exception("Too many illegal inputs");
    }

    private static void readData() throws Exception {
            try {
                inputs.add(Double.parseDouble(input));
            }catch (IllegalArgumentException e){
                Thread.sleep(100);
                for (int i = inputs.size()-1; i >= 0; i--) {
                    System.out.print(inputs.get(i) + " ");
                }
                System.out.println();
                throw  new Exception();
            }

    }
}
