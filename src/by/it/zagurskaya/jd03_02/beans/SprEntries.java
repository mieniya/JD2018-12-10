package by.it.zagurskaya.jd03_02.beans;

public class SprEntries {
    private long idEntry;
    private String nameEntry;
    private long currencyEntry;
    private String accauntDebitEntry;
    private String accauntKreditEntry;
    private double sumEntry;
    private boolean isSpeting;
    private double rateEntry;

    public SprEntries() {
    }

    public SprEntries(long idEntry, String nameEntry, long currencyEntry, String accauntDebitEntry, String accauntKreditEntry, double sumEntry, boolean isSpeting, double rateEntry) {
        this.idEntry = idEntry;
        this.nameEntry = nameEntry;
        this.currencyEntry = currencyEntry;
        this.accauntDebitEntry = accauntDebitEntry;
        this.accauntKreditEntry = accauntKreditEntry;
        this.sumEntry = sumEntry;
        this.isSpeting = isSpeting;
        this.rateEntry = rateEntry;
    }

    public long getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(long idEntry) {
        this.idEntry = idEntry;
    }

    public String getNameEntry() {
        return nameEntry;
    }

    public void setNameEntry(String nameEntry) {
        this.nameEntry = nameEntry;
    }

    public long getCurrencyEntry() {
        return currencyEntry;
    }

    public void setCurrencyEntry(long currencyEntry) {
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

    public boolean isSpeting() {
        return isSpeting;
    }

    public void setSpeting(boolean speting) {
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
        return "sprEntrys{" +
                "idEntry=" + idEntry +
                ", nameEntry='" + nameEntry + '\'' +
                ", currencyEntry=" + currencyEntry +
                ", accauntDebitEntry='" + accauntDebitEntry + '\'' +
                ", accauntKreditEntry='" + accauntKreditEntry + '\'' +
                ", sumEntry=" + sumEntry +
                ", isSpeting=" + isSpeting +
                ", rateEntry=" + rateEntry +
                '}';
    }
}
