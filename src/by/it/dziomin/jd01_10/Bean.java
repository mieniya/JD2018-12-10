package by.it.dziomin.jd01_10;

class Bean {
    @Param(a = 25, b = 10)
    double sum(int x, int y) {
        return x + y;
    }

    @Param(a = 5, b = 15)
    static double max(int x, int y) {
        return (x > y ? x : y);
    }

    @Param(a = 30, b = 3)
    static double min(int x, int y) {
        return (x < y ? x : y);
    }

    //    @Param(a = 25, b = 10)
    double avg(int x, int y) {
        return ((x + y) / 2.0);
    }
}
