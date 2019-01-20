package by.it.yarmolenka.jd01_10;

public class Bean {
    static double sum(int x, int y) {
        return x + y;
    }

    @Param(a = 8, b = 4)
    static double max(int x, int y) {
        return x > y ? x : y;
    }

    @Param(a = 10, b = 2)
    double min(int x, int y) {
        return x > y ? y : x;
    }

    @Param(a = 3, b = 5)
    double avg(int x, int y) {
        return (x + y) / 2.0;
    }
}
