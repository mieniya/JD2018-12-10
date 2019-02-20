package by.it.moroz.jd01.jd01_12;

public class Timer {

    private long iniTime;

    Timer() {
        iniTime = System.nanoTime();
    }

    @Override
    public String toString() {
        int delta = (int) (System.nanoTime() - iniTime) / 1000;
        iniTime = System.nanoTime();
        return delta +" мкс";
    }
}
