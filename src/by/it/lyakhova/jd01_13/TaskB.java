package by.it.lyakhova.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        double sum = 0;

        Scanner scanner = new Scanner(System.in);

        String expression;
        while (!(expression = scanner.nextLine()).equalsIgnoreCase("END")){
            try {
                double number = Double.parseDouble(expression);//NumberFormatException

                sum+=number;

                if (sum<0) throw new ArithmeticException("Невозможно извлечь корень");

                System.out.println(number + " " +Math.sqrt(sum));


            }catch (NumberFormatException | ArithmeticException e){

                String name = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                String className = "none";
                Integer lineNumber = -1;
                for (StackTraceElement element :
                        stackTrace) {
                    if (element.getMethodName().equals("main")) {
                        className = element.getClassName();
                        lineNumber = element.getLineNumber();
                    }
                }
                System.out.printf("name: %s\n" +
                                "class: %s\n" +
                                "line: %s\n",
                        name, className, lineNumber);
            }
        }

    }

}
