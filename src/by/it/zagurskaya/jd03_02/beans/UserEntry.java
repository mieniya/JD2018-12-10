package by.it.zagurskaya.jd03_02.beans;

public class UserEntry {
    private long idUsersEntries;
    private long numberUserOperation;
    private long numberEntry;
    private int currencyEntry;
    private String accauntDebitEntry;
    private String accauntKreditEntry;
    private double sumEntry;
    private boolean isSpeting;
    private double rateEntry;

    public UserEntry() {
    }

    public UserEntry(long idusersEntrys, long numberUserOperation, long numberEntry, int currencyEntry, String accauntDebitEntry, String accauntKreditEntry, double sumEntry, boolean isSpeting, double rateEntry) {
        this.idUsersEntries = idusersEntrys;
        this.numberUserOperation = numberUserOperation;
        this.numberEntry = numberEntry;
        this.currencyEntry = currencyEntry;
        this.accauntDebitEntry = accauntDebitEntry;
        this.accauntKreditEntry = accauntKreditEntry;
        this.sumEntry = sumEntry;
        this.isSpeting = isSpeting;
        this.rateEntry = rateEntry;
    }

    public long getIdUsersEntries() {
        return idUsersEntries;
    }

    public void setIdUsersEntries(long idUsersEntrys) {
        this.idUsersEntries = idUsersEntrys;
    }

    public long getNumberUserOperation() {
        return numberUserOperation;
    }

    public void setNumberUserOperation(long numberUserOperation) {
        this.numberUserOperation = numberUserOperation;
    }

    public long getNumberEntry() {
        return numberEntry;
    }

    public void setNumberEntry(long numberEntry) {
        this.numberEntry = numberEntry;
    }

    public int getCurrencyEntry() {
        return currencyEntry;
    }

    public void setCurrencyEntry(int currencyEntry) {
        this.currencyEntry = currencyEntry;
    }

    public String getAccauntDebitEntry() {
        return accauntDebitEntry;
    }

    public void setAccauntDebitEntry(String accauntDebitEntry) {
        this.accauntDebitEntry = accauntDebitEntry;
    }

    public String getAccauntKreditEntry() {
        return accauntKreditEntry;
    }

    public void setAccauntKreditEntry(String accauntKreditEntry) {
        this.accauntKreditEntry = accauntKreditEntry;
    }

    public double getSumEntry() {
        return sumEntry;
    }

    public void setSumEntry(double sumEntry) {
        this.sumEntry = sumEntry;
    }

    public boolean getIsSpeting() {
        return isSpeting;
    }

    public void setIsSpeting(boolean speting) {
        isSpeting = speting;
    }

    public double getRateEntry() {
        return rateEntry;
    }

    public void setRateEntry(double rateEntry) {
        this.rateEntry = rateEntry;
    }

    @Override
    public String toString() {
        return "UserEntry{" +
                "idUsersEntries=" + idUsersEntries +
                ", numberUserOperation=" + numberUserOperation +
                ", numberEntry=" + numberEntry +
                ", currencyEntry=" + currencyEntry +
                ", accauntDebitEntry='" + accauntDebitEntry + '\'' +
                ", accauntKreditEntry='" + accauntKreditEntry + '\'' +
                ", sumEntry=" + sumEntry +
                ", isSpeting=" + isSpeting +
                ", rateEntry=" + rateEntry +
                '}';
    }
}
