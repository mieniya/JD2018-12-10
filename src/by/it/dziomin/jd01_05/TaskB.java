package by.it.dziomin.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    public static void step1() {
        System.out.println("-------------------------------------------");
        double y = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (int x = 1; x <= 6; x++) {
                y = y + (pow(7, a) - cos(x));
                System.out.println("a=" + a + " y=" + y);
            }
        }

    }

    public static void step2() {
        System.out.println("-------------------------------------------");
        double a;
        double b;

        for (double x = -5.5; x < 2; x = x + 0.5) {
            double halfX = x / 2;
            if (halfX > -2 && halfX <= -1) {
                b = sin(x * x);
            } else if (halfX > -1 && halfX < 0.2) {
                b = cos(x * x);
            } else if (halfX == 0.2) {
                b = 1 / tan(x * x);
            } else {
                System.out.println("halfX=" + halfX + " нет решения");
                continue;
            }
            a = log10(b + 2.74);
            System.out.println("halfX=" + halfX + " a=" + a);
        }
    }
}
