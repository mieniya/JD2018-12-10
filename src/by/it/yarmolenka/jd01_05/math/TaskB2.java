package by.it.yarmolenka.jd01_05.math;

public class TaskB2 {

    public static void printB2() {
        double b;
        System.out.println("\n\nЗадание B2:");
        for (double x = -5.5; x < 2; x += 0.5) {
            System.out.printf("При x/2 = %5.2f", x / 2);
            if (x / 2 > -2 && x / 2 <= -1) b = Math.sin(Math.pow(x, 2));
            else if (x / 2 > -1 && x / 2 < 0.2) b = Math.cos(Math.pow(x, 2));
            else if (x / 2 == 0.2) b = 1 / Math.tan(Math.pow(x, 2));
            else {
                System.out.println(" вычисления не определены");
                continue;
            }
            double a = Math.log10(Math.abs(b + 2.74));
            System.out.printf(" a = %-8.6f\n", a);

        }
    }
}