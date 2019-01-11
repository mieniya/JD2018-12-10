package by.it.zagurskaya.jd01_08.oop;

public class Sick {

    private int sickListDay;

    private String sickName;

    private String symptoms;

    private String sickKiller;

    public Sick(int sickListDay, String sickName, String symptoms, String sickKiller) {
        this.sickListDay = sickListDay;
        this.sickName = sickName;
        this.symptoms = symptoms;
        this.sickKiller = sickKiller;
    }

    public int getSickListDay() {
        return sickListDay;
    }

    public String getSickName() {
        return sickName;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getSickKiller() {
        return sickKiller;
    }
}
