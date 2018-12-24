package by.it.subach.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }


    public static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, x) - cos(x);
            }
            System.out.println("При a=" + (double)round(a * 10)/10 + " " + "Сумма y = " + y);
        }

    }


    public static void step2() {
        double b = 0;
        double a = 0;
        for(double x = -6 + 0.5; x < 2; x += 0.5){
            if(x / 2 > -2 && x / 2 <= -1){
                b = sin(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.println("при х/2 = " + x / 2 + "  " + "a = " + a);


            }
            else if(x / 2 > -1 && x / 2 < 0.2){
                b = cos(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.println("при х/2 = " + x / 2 + "  " + "a = " + a);


            }
            else if(x / 2 == 0.2){
                b = cos(pow(x, 2)) / sin(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.println("при х/2 = " + x / 2 + "  " + "a = " + a);


            }
            else
                System.out.println("при x/2 = " + x / 2 + " Вычисления не определены");
//            a = log10(abs(b + 2.74));

//            System.out.println("при х/2 =" + x / 2 + "  " + "a = " + a);
        }
    }
}
