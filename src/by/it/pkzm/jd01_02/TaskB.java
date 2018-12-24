package by.it.pkzm.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();

        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();

        step2(month);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        step3(a, b, c);
    }

    private static void step1() {
        System.out.print(1 + " ");
        if (0 == 1 % 5) System.out.println();
        System.out.print(2 + " ");
        if (0 == 2 % 5) {
            System.out.println();
        }
        System.out.print(3 + " ");
        if (0 == 3 % 5) {
            System.out.println();
        }
        System.out.print(4 + " ");
        if (0 == 4 % 5) {
            System.out.println();
        }
        System.out.print(5 + " ");
        if (0 == 5 % 5) {
            System.out.println();
        }
        System.out.print(6 + " ");
        if (0 == 6 % 5) {
            System.out.println();
        }
        System.out.print(7 + " ");
        if (0 == 7 % 5) {
            System.out.println();
        }
        System.out.print(8 + " ");
        if (0 == 8 % 5) {
            System.out.println();
        }
        System.out.print(9 + " ");
        if (0 == 9 % 5) {
            System.out.println();
        }
        System.out.print(10 + " ");
        if (0 == 10 % 5) {
            System.out.println();
        }
        System.out.print(11 + " ");
        if (0 == 11 % 5) {
            System.out.println();
        }
        System.out.print(12 + " ");
        if (0 == 12 % 5) {
            System.out.println();
        }
        System.out.print(13 + " ");
        if (0 == 13 % 5) {
            System.out.println();
        }
        System.out.print(14 + " ");
        if (0 == 14 % 5) {
            System.out.println();
        }
        System.out.print(15 + " ");
        if (0 == 15 % 5) {
            System.out.println();
        }
        System.out.print(16 + " ");
        if (0 == 16 % 5) {
            System.out.println();
        }
        System.out.print(17 + " ");
        if (0 == 17 % 5) {
            System.out.println();
        }
        System.out.print(18 + " ");
        if (0 == 18 % 5) {
            System.out.println();
        }
        System.out.print(19 + " ");
        if (0 == 19 % 5) {
            System.out.println();
        }
        System.out.print(20 + " ");
        if (0 == 20 % 5) {
            System.out.println();
        }
        System.out.print(21 + " ");
        if (0 == 21 % 5) {
            System.out.println();
        }
        System.out.print(22 + " ");
        if (0 == 22 % 5) {
            System.out.println();
        }
        System.out.print(23 + " ");
        if (0 == 23 % 5) {
            System.out.println();
        }
        System.out.print(24 + " ");
        if (0 == 24 % 5) {
            System.out.println();
        }
        System.out.print(25 + " ");
        if (0 == 25 % 5) {
            System.out.println();
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }

    }

    private static void step3(double a, double b, double c) {
        double dis = b * b - 4 * a * c;
        if (dis < 0) System.out.println("корней нет");
        else if (0 == dis) {
            double x1 = (-b + Math.sqrt(dis)) / (2 * a);
            double x2 = (-b - Math.sqrt(dis)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }

    }
}
