package by.it.dziomin.jd01_13;

import java.util.Scanner;

public class TaskB extends TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        while (true) {
            String str = readFromScanner(sc);
            if (str == null) break;
            sum = processString(sum, str);
        }
    }

    static String readFromScanner(Scanner sc) {
        String str = sc.nextLine();
        if (str.equalsIgnoreCase("End")) {
            return null;
        }
        return str;
    }

    private static double processString(double sum, String str) {
        try {
            double num = Double.parseDouble(str);
            System.out.println("double: " + num);

            sum = sum + num;
            if (!Double.isNaN(Math.sqrt(sum))) {
                System.out.println("Sqrt: " + Math.sqrt(sum));
            } else {
                throw new ArithmeticException();
            }
        } catch (NumberFormatException e) {
            handleException(e, "Ошибка! Введено некорректное число. Повторите ввод");
        } catch (ArithmeticException e) {
            handleException(e, "Ошибка! Не возможно извлечь корень. Повторите ввод");
        }
        return sum;
    }

    static void handleException(Exception e, String msg) {
        System.err.println(msg);
        TaskA.handleException(e, TaskB.class.getCanonicalName());
    }
}
