package by.it.subach.jd01_10;

public class Bean {

    @Param(a = 10, b = 20)
    static int sum(int x, int y){
        return x + y;
    }

    @Param(a = 1, b = -1)
    static int max(int x, int y){
        return x > y ? x : y;
    }

    int min(int x, int y){
        return x < y ? x : y;
    }

    @Param(a = 20, b = 1)
    double avg(int x, int y){
        return (x + y) / 2;
    }

}
