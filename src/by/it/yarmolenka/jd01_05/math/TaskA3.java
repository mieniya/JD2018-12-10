package by.it.yarmolenka.jd01_05.math;

import static java.lang.Math.exp;

public class TaskA3 {
    private static double calculate(double a, double x) {
        return exp(a * x) - 3.45 * a;
    }
    public static void printA3(double x, double a){
        System.out.println("\nЗадание А3:");
        for (double i = -5; i <= 12; i += a) {
            System.out.printf("a=%5.2f; f=%-20.4f\n", i, TaskA3.calculate(i, x));
        }
    }
}
