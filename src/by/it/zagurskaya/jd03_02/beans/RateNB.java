package by.it.zagurskaya.jd03_02.beans;

import java.sql.Timestamp;

public class RateNB {
    private long id;
    private double rateSum;
    private Timestamp rateDate;
    private long currency_id;

    public RateNB () {
    }

    public RateNB(long id, double rateSum, Timestamp rateDate, long currency_id) {
        this.id = id;
        this.rateSum = rateSum;
        this.rateDate = rateDate;
        this.currency_id = currency_id;
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

    public Timestamp getRateDate() {
        return rateDate;
    }

    public void setRateDate(Timestamp rateDate) {
        this.rateDate = rateDate;
    }

    public long getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(long currency_id) {
        this.currency_id = currency_id;
    }

    @Override
    public String toString() {
        return "RateNB{" +
                "id=" + id +
                ", rateSum=" + rateSum +
                ", rateDate=" + rateDate +
                ", currency_id=" + currency_id +
                '}';
    }
}
