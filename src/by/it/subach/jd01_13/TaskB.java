package by.it.subach.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        while (true) {
            String str = scanner.next();
            if (str.equalsIgnoreCase("end")) break;
            else
                try {
                    double input = Double.parseDouble(str);
                    System.out.println(input);
                    sum += input;
                    if(sum < 0)     {throw  new ArithmeticException();}
                    System.out.println(Math.sqrt(sum));
                }
                catch (ArithmeticException | NumberFormatException e) {

                    String name = e.getClass().getName();
                    String className = "none";
                    int lineNumber = -1;
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement elem : stackTrace) {
                        if (elem.getMethodName().equals("main")) {
                            className = elem.getClassName();
                            lineNumber = elem.getLineNumber();
                        }

                    }
                    System.out.printf("name: %s\n" +
                            "class: %s\n" +
                            "line: %d\n",
                            name, className, lineNumber);
                }
        }

    }
}
