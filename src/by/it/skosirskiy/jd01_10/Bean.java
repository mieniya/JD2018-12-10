package by.it.skosirskiy.jd01_10;

public class Bean {
    @Param(a=2, b=5)
    static double sum(int a1, int a2) {
        return a1 + a2;
    }

    @Param(a=2, b=5)
    static double max(int b1, int b2) {
        return b1 > b2 ? b1 : b2;
    }
    @Param(a=2, b=5)
    double min(int c1, int c2) {
        return c1 < c2 ? c1 : c2;
    }
    double avg(int d1, int d2) {
        return (d1+d2)/2.0;
    }

}
