package by.it.moroz.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        step1();
        step2();
    }

    private static void step1() {

        for (double a = 0; a <= 2; a += 0.2) {
            double res = 0;
            for (int x = 1; x <= 6; x++) {
                double y = pow(7, a) - cos(x);
                res += y;
            }
            System.out.printf("При а=%1.2f y = %g\n", a, res);
        }
        System.out.println();
    }

    private static void step2() {

        for (double x = -5.5; x < 2; x += 0.5) {
            double x1=x/2;
            if (x1 > -2 && x1 <= -1) {
                double a = log10(abs(sin(pow(x,2))+2.74));
                System.out.printf("При x/2=%2.2f a = %e\n", x1, a);
            } else if (x1 > -1 && x1 < 0.2) {
                double a = log10(abs(cos(pow(x, 2)) + 2.74));
                System.out.printf("При x/2=%2.2f a = %e\n", x1, a);
            } else if (x1 == 0.2) {
                double a = log10(abs((cos(pow(x, 2)) / sin(pow(x, 2))) + 2.74));
                System.out.printf("При x/2=%2.2f a = %e\n", x1, a);
            } else System.out.printf("При x/2=%2.2f вычисления не определены\n", x1);

        }
    }
}
