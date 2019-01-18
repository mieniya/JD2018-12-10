package by.it.moroz.jd01_12;

public class Timer {

    private long iniTime;
    private Integer Delta;

    public Timer() {
        iniTime = System.nanoTime();
    }

    @Override
    public String toString() {
        Delta =(int) (System.nanoTime()-iniTime)/1000;
        iniTime = System.nanoTime();
        return Delta.toString()+" мкс";
    }
}
