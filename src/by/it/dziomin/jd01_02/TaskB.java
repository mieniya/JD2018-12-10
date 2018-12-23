package by.it.dziomin.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

//        int[] mas = new int[10];
//        for (int i = 0; i < mas.length; i++) {
//            mas[i]=sc.nextInt();
//        }
        step1();
        Scanner sc = new Scanner(System.in);
        int mon = sc.nextInt();
        step2(mon);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);

    }

    static void step1() {
        for (int i = 0; i < 25;) {
            System.out.print(++i + " ");
            if (i % 5 == 0)
                System.out.println();
        }
    }

    static void step2(int month) {
        String str;
        switch (month) {
            case 1:
                str = "январь";
                break;
            case 2:
                str = "февраль";
                break;
            case 3:
                str = "март";
                break;
            case 4:
                str = "апрель";
                break;
            case 5:
                str = "май";
                break;
            case 6:
                str = "июнь";
                break;
            case 7:
                str = "июль";
                break;
            case 8:
                str = "август";
                break;
            case 9:
                str = "сентябрь";
                break;
            case 10:
                str = "октябрь";
                break;
            case 11:
                str = "ноябрь";
                break;
            case 12:
                str = "декабрь";
                break;
            default:
                str = "нет такого месяца";
        }
        System.out.println(str);
    }

    static void step3(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0)
            System.out.println("корней нет");
        else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1);
            System.out.println(x2);
        } else {
            double x = -b / (2 * a);
            System.out.println(x);
        }
    }


}
