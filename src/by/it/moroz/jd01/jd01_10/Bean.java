package by.it.moroz.jd01.jd01_10;

public class Bean {

    @Param(a=10, b=20)
   static double sum (int x, int y){
        return x+y;
    }

    @Param(a=3 , b=4)
    double max (int d, int z){
        return d>z? d : z;
    }


    double min (int a1, int a2){
        return a1<a2? a1 : a2;
    }

    @Param(a=9, b=6)
    static double avg (int a, int b){
        return (a+b)/2.0;
    }
}
