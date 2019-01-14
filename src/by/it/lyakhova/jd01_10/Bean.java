package by.it.lyakhova.jd01_10;

public class Bean {

    @Param(a = 10, b = 20)
    double sum(int x, int y) {return x + y;}

    static double max(int x, int y) {return x > y ? x : y;}

    @Param(a = 10, b = 5)
    double min(int a, int b) {return a < b ? a : b;}

    @Param(a = 20, b = 3)
    static double avg (int a, int b) {return (a + b) / 2.0;}

}
