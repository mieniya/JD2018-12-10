package by.it.yarmolenka.jd01_05.math;

public class TaskB1 {

    public static void printB1(double p) {
        System.out.println("Задание B1:");
        for (double a = 0; a <= 2; a += p) {
            double y = 0;
            for (int x = 1; x <= 6; x++) y += (Math.pow(7, a) - Math.cos(x));
            System.out.printf("При a=%4.2f Сумма y = %-8.4f\n", a, y);
        }
    }
}