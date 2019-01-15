package by.it.subach.jd01_10;

public class Bean {

    @Param(a = 10, b = 20)
    static double sum(int x, int y){
        return x + y;
    }

    @Param(a = 1, b = -1)
    double max(int x, int y){
        return x > y ? x : y;
    }

    double min(int x, int y){
        return x < y ? x : y;
    }

    @Param(a = 20, b = 1)
    static double avg(int a, int b){
        return (a + b) / 2.0;
    }

}
