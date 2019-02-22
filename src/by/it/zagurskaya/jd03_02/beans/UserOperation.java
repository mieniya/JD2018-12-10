package by.it.zagurskaya.jd03_02.beans;

import java.sql.Timestamp;

public class UserOperation {
    private long idUserOperation;
    private Timestamp dateOperation;
    private double rateEntry;
    private double sumEntry;
    private int currencyOperation;
    private int numberUser;
    private long numberOperation;
    private String specification;
    private String checkingAccount;

    public UserOperation() {
    }

    public UserOperation(long idUserOperation, Timestamp dateOperation, double rateEntry, double sumEntry, int currencyOperation, int numberUser, long numberOperation, String specification, String checkingAccount) {
        this.idUserOperation = idUserOperation;
        this.dateOperation = dateOperation;
        this.rateEntry = rateEntry;
        this.sumEntry = sumEntry;
        this.currencyOperation = currencyOperation;
        this.numberUser = numberUser;
        this.numberOperation = numberOperation;
        this.specification = specification;
        this.checkingAccount = checkingAccount;
    }

    public long getIdUserOperation() {
        return idUserOperation;
    }

    public void setIdUserOperation(long idUserOperation) {
        this.idUserOperation = idUserOperation;
    }

    public Timestamp getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Timestamp dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getRateEntry() {
        return rateEntry;
    }

    public void setRateEntry(double rateEntry) {
        this.rateEntry = rateEntry;
    }

    public double getSumEntry() {
        return sumEntry;
    }

    public void setSumEntry(double sumEntry) {
        this.sumEntry = sumEntry;
    }

    public int getCurrencyOperation() {
        return currencyOperation;
    }

    public void setCurrencyOperation(int currencyOperation) {
        this.currencyOperation = currencyOperation;
    }

    public int getNumberUser() {
        return numberUser;
    }

    public void setNumberUser(int numberUser) {
        this.numberUser = numberUser;
    }

    public long getNumberOperation() {
        return numberOperation;
    }

    public void setNumberOperation(long numberOperation) {
        this.numberOperation = numberOperation;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(String checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    @Override
    public String toString() {
        return "UserOperation{" +
                "idUserOperation=" + idUserOperation +
                ", dateOperation=" + dateOperation +
                ", rateEntry=" + rateEntry +
                ", sumEntry=" + sumEntry +
                ", currencyOperation=" + currencyOperation +
                ", numberUser=" + numberUser +
                ", numberOperation=" + numberOperation +
                ", specification='" + specification + '\'' +
                ", checkingAccount='" + checkingAccount + '\'' +
                '}';
    }
}
