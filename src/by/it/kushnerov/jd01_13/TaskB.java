package by.it.kushnerov.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        double sum = 0;
        String word;
        Scanner sc = new Scanner(System.in);
        try {
            while (sc.hasNext() && !(word = sc.next()).equalsIgnoreCase("end")) {
                double number = Double.parseDouble(word);
                sum += number;
                if (sum < 0) throw new ArithmeticException();
                double sqrt = Math.sqrt(sum);
                System.out.printf(Locale.ENGLISH,"number: %5.3f, square root of sum: %5.3f\n", number, sqrt);
            }
        } catch (NumberFormatException | ArithmeticException e) {
            String name = e.getClass().getName();
            String className = "none";
            int lineNumber = 1;
            System.out.printf(" name: %s\n", name);
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getMethodName().equals("main")) {
                    className = element.getClassName();
                    lineNumber = element.getLineNumber();
                    System.out.printf(" name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d\n"
                            , name, className, lineNumber);
                    break;
                }
            }
        }
    }
}
