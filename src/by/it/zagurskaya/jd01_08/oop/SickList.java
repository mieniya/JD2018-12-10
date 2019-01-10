package by.it.zagurskaya.jd01_08.oop;

import java.time.LocalDate;

public class SickList {

    private String sickName;

    private String sickerName;

    private Integer number;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isOpen;

    public String getSickName() {
        return sickName;
    }

    public void setSickName(String sickName) {
        this.sickName = sickName;
    }

    public String getSickerName() {
        return sickerName;
    }

    public void setSickerName(String sickerName) {
        this.sickerName = sickerName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        if (number == null) {
            this.number = number;
        }
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
