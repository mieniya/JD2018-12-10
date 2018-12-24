package by.it.lyakhova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
        
    }

    private static void step1() {
        for (double a=0; a<2; a=a+0.2){
            double y = 0;
            for (double x=1; x<7; x++){
                y = y + pow(7,a)-cos(x);
            }
            System.out.println("При a=" + a + " Сумма y = " + y);
        }
    }

    private static void step2() {
        double a;
        for (double x = -5.5; x < 2; x = x + 0.5){
            double half = x/2;
            System.out.print("При х/2 = " + half);

            if ((half>-2)&&(half<=-1)) {
               a = log10(abs(sin(pow(x, 2)) + 2.74));
                System.out.println(" a = " + a);
            }
            else if ((half>-1)&&(half<0.2)){
                a = log10(abs(cos(pow(x, 2)) + 2.74));
                System.out.println(" a = " + a);
            }
            else if (half == 0.2){
                a = log10(abs(atan(pow(x, 2)) + 2.74));
                System.out.println(" a = " + a);
            }
            else System.out.println(" вычисления не определены");
        }

    }
}
