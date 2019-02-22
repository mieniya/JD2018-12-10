package by.it.zagurskaya.jd03_02.beans;

import java.sql.Timestamp;

public class RateCB {
    private long id;
    private double rateSum;
    private boolean isBack;
    private Timestamp dateRate;
    private long currencyComing;
    private long currencySpending;

    public RateCB() {
    }

    public RateCB(long id, double rateSum, boolean isBack, Timestamp dateRate, long currencyComing, long currencySpending) {
        this.id = id;
        this.rateSum = rateSum;
        this.isBack = isBack;
        this.dateRate = dateRate;
        this.currencyComing = currencyComing;
        this.currencySpending = currencySpending;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRateSum() {
        return rateSum;
    }

    public void setRateSum(double rateSum) {
        this.rateSum = rateSum;
    }

    public boolean isBack() {
        return isBack;
    }

    public void setBack(boolean back) {
        isBack = back;
    }

    public Timestamp getDateRate() {
        return dateRate;
    }

    public void setDateRate(Timestamp dateRate) {
        this.dateRate = dateRate;
    }

    public long getCurrencyComing() {
        return currencyComing;
    }

    public void setCurrencyComing(long currencyComing) {
        this.currencyComing = currencyComing;
    }

    public long getCurrencySpending() {
        return currencySpending;
    }

    public void setCurrencySpending(long currencySpending) {
        this.currencySpending = currencySpending;
    }

    @Override
    public String toString() {
        return "RateCB{" +
                "id=" + id +
                ", rateSum=" + rateSum +
                ", isBack=" + isBack +
                ", dateRate=" + dateRate +
                ", currencyComing=" + currencyComing +
                ", currencySpending=" + currencySpending +
                '}';
    }
}
