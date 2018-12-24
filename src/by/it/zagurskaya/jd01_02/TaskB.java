package by.it.zagurskaya.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        step1();

        System.out.println("Введите число от 1 до 12");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        step2(month);

        System.out.println("Введите числа для квадратного уравнения:");
        System.out.println("Введите число a:");
        double a = scanner.nextDouble();
        System.out.println("Введите число b:");
        double b = scanner.nextDouble();
        System.out.println("Введите число c:");
        double c = scanner.nextDouble();

        step3(a, b, c);

    }


    private static void step1() {
        for (int i = 1; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) System.out.println();
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
                System.out.print("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {
        double x1;
        double x2;
        double diskr;
        diskr = b * b - 4 * a * c;
        System.out.println();
        if (diskr < 0) {
            System.out.println("корней нет");
        } else if (diskr == 0) {
            x1 = -b / (2 * a);
            System.out.println("Одно решение х=" + x1);
        } else {
            x1 = (-b + Math.sqrt(diskr)) / (2 * a);
            x2 = (-b - Math.sqrt(diskr)) / (2 * a);
            System.out.println("1-е решение х1=" + x1);
            System.out.println("2-е решение х2=" + x2);
        }
    }
}