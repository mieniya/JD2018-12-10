package by.it.skosirskiy.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a =  756.13;
        double x =  0.3;
        double z;

        z= cos(pow((x*x+PI/6),5))-sqrt(x*(pow(a,3)))-log(abs((a-1.12*x)/4));
        System.out.println(z);
    }
    private static void step2(){
        double a= 1.21;
        double b=0.371;
        double y=tan((a+b)*(a+b))-pow((a+1.5), 1/3.0)+a*pow(b, 5)-(b/log(a*a));
        System.out.println(y);
    }
    private static void step3() {
        double x=12.1;
        double a=-5;
        double f=0;
        do {

            f=exp(a*x)-3.45*a;
            System.out.printf("%6s%5f%5s%6f", "при а= ", a, "f= ", f);
            a=a+3.75;
        } while ((-5<=a)&&(a<=12));
    }
}
