package by.it.skosirskiy.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
      step1();
        step2();
    }

    private static void step1() {

        double a=0;
        do {
            double sum=0;
            double y=0;
            for (int i = 1; i < 7; i++) {

             sum=pow(7,a)-cos(i);
             y=y+sum;
         }
            System.out.printf("%10s%10f%10s%10f\n", "а=", a, "Сумма y=", y);
            a=a+0.2;
       }while ((0<=a)&&(a<=2));
    }

    private static void step2() {
        double x = -5.5;
        double a = 0;

        do {
            boolean non=false;
            double beta=0;
            double alpha =0;
            if((-2<x/2)&&(x/2<=-1)){
                beta=sin(x*x);
                non=true;
            }
            if((-1<x/2)&&(x/2<0.2)){
                beta=cos(x*x);
                non=true;
            }
            if(x / 2 == 0.2){
                beta=cos(x*x)/sin(x*x);
                non=true;
            }

            if (non==true) {alpha=log10(abs(beta+2.74));
                System.out.printf("%8s%4f%4s%10f\n", "При x/2=", x, "a=",alpha);
            }
            else {
            System.out.printf("%8s%4f%18s\n", "При x/2=", x, " вычисления не определены");}
            x=x+0.5;


        }while((-6< x)&&(x<2));
    }

}
