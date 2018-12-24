package by.it.pkzm.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {

        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double z;
        double first = cos(pow((x * x + PI / 6), 5));
        double second = sqrt(x * pow(a, 3));
        double third = log(abs((a - 1.12 * x) / 4));
        System.out.println(z= first - second - third);

    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y;
        y = tan(pow((a + b), 2)) - pow((a + 1.5), 1.0 / 3) + a * pow(b, 5) - b / log(a * a);
        System.out.println("y= " + y);
    }

    private static void step3() {

    }
}