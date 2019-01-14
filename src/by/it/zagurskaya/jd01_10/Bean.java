package by.it.zagurskaya.jd01_10;

public class Bean {

    @Param(a=10,b=20)
    double sum(int x, int y){
        return x+y;
    }
    static double max(int d, int z){
        return d>z? d:z;
    }
    @Param(a=10,b=5)
    double min(int d, int z){
        return d<z? d:z;
    }
    @Param(a=20,b=3)
    static  double avg(int a, int b){
        return ((a+b)/2.0);
    }
}
