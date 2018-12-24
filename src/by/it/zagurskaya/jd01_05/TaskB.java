package by.it.zagurskaya.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a < 2; a = a + 0.2) {
            double y = 0;
            for (double x = 1; x <= 6; x++) {
                double y1 = pow(7, a) - cos(x);
                y = y + y1;
            }
            System.out.println("y(" + a + ")= " + y);
        }
    }

    private static void step2() {
        for (double x = -6; x < 2; x = x + 0.5) {
            double y = log10(abs(param(x) + 2.74));
            System.out.println("param" + param(x) + "   y(" + x + ")= " + y);
        }
    }

    private static double param(double x) {
        double rezult;
        if (-4 < x || x <= -2) rezult = sin(x * x);
        else if (-1 < x || x < 0.4) rezult = cos(x * x);
        else if (x == 0.4) rezult = 1.0 / tan(x * x);
        else rezult = 0;
        return rezult;
    }
}
