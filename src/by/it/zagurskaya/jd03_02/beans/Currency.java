package by.it.zagurskaya.jd03_02.beans;

public class Currency {
    private long idCurrency;
    private String iso;
    private String nameCurrency;

    public Currency () {
    }

    public Currency(long idCurrency, String iso, String nameCurrency) {
        this.idCurrency = idCurrency;
        this.iso = iso;
        this.nameCurrency = nameCurrency;
    }

    public long getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(long idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getNameCurrency() {
        return nameCurrency;
    }

    public void setNameCurrency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "idCurrency=" + idCurrency +
                ", iso='" + iso + '\'' +
                ", nameCurrency='" + nameCurrency + '\'' +
                '}';
    }
}
