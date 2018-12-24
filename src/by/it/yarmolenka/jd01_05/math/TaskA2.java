package by.it.yarmolenka.jd01_05.math;

import static java.lang.Math.*;

public class TaskA2 {

    public static double calculate(double a, double b) {
        return tan(pow(a + b, 2)) - pow(a + 1.5, 1.0 / 3.0) + a * pow(b, 5) - b / (log(pow(a, 2)));
    }

    public static void printA2(double x){
        System.out.println("\nЗадание А2:");
        System.out.printf("f(a=1.21, b=0.371) = %-20.6f\n", x);
    }
}
