package by.it.yarmolenka.jd01_05.math;

import static java.lang.Math.*;

public class TaskA1 {

    public static double part1(double x) {
        return cos(pow(pow(x, 2) + PI / 6, 5));
    }

    public static double part2(double x, double a) {
        return sqrt(x * pow(a, 3));
    }

    public static double part3(double x, double a) {
        return log(abs((a - 1.12 * x) / 4));
    }

    public static double calculate(double x, double a){
        return cos(pow(pow(x, 2) + PI / 6, 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
    }

    public static void printA1(double z1, double z2){
        System.out.println("Задание А1:");
        System.out.printf("Считаем частями: %-20.6f\nСчитаем в одну строку: %-20.6f\n", z1, z2);
    }
}
