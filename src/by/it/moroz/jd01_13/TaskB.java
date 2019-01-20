package by.it.moroz.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String s;
            int a;
            int sqrt = 0;
            while (!(s = scanner.nextLine().toLowerCase()).equals("end")) {
                a = (int) Double.parseDouble(s);
                sqrt += a;
                if (sqrt >= 0) {
                    System.out.println("Число = " + a + " Корень = " + Math.sqrt(sqrt));
                } else throw new ArithmeticException("Отрицательное число под корнем");
            }
        } catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getMethodName().equals("main")) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int line = element.getLineNumber();
                    System.out.printf("name: %s\n", name);
                    System.out.printf("class: %s\n", className);
                    System.out.printf("line: %d\n", line);
                }
            }
        }
    }
}
