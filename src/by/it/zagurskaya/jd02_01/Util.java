package by.it.zagurskaya.jd02_01;

public class Util {
    static Integer getRandom (int min, int max) {
        return min+(int)(Math.random())*(max-min);
    }
    static int getRandom (int max) {
        return getRandom(0,max);
    }
    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
