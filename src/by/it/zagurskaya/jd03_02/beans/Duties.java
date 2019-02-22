package by.it.zagurskaya.jd03_02.beans;

import java.sql.Timestamp;

public class Duties {
    private long idDuties;
    private int numberUser;
    private Timestamp dateDuties;
    private int numberDuties;
    private boolean isClose;

    public Duties () {
    }

    public Duties(long idDuties, int numberUser, Timestamp dateDuties, int numberDuties, boolean isClose) {
        this.idDuties = idDuties;
        this.numberUser = numberUser;
        this.dateDuties = dateDuties;
        this.numberDuties = numberDuties;
        this.isClose = isClose;
    }

    public long getIdDuties() {
        return idDuties;
    }

    public void setIdDuties(long idDuties) {
        this.idDuties = idDuties;
    }

    public int getNumberUser() {
        return numberUser;
    }

    public void setNumberUser(int numberUser) {
        this.numberUser = numberUser;
    }

    public Timestamp getDateDuties() {
        return dateDuties;
    }

    public void setDateDuties(Timestamp dateDuties) {
        this.dateDuties = dateDuties;
    }

    public int getNumberDuties() {
        return numberDuties;
    }

    public void setNumberDuties(int numberDuties) {
        this.numberDuties = numberDuties;
    }

    public boolean getClose() {
        return isClose;
    }

    public void setClose(boolean close) {
        isClose = close;
    }

    @Override
    public String toString() {
        return "Duties{" +
                "idDuties=" + idDuties +
                ", numberUser=" + numberUser +
                ", dateDuties=" + dateDuties +
                ", numberDuties=" + numberDuties +
                ", isClose=" + isClose +
                '}';
    }
}
