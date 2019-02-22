package by.it.zagurskaya.jd03_02.beans;

public class Accaunt {
    private long id;
    private int accaunt;
    private int accauntSub;
    private String fullAccount;
    private long currency;

    public Accaunt() {
    }

    public Accaunt(long id, int accaunt, int accauntSub, String fullAccount, long currency) {
        this.id = id;
        this.accaunt = accaunt;
        this.accauntSub = accauntSub;
        this.fullAccount = fullAccount;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccaunt() {
        return accaunt;
    }

    public void setAccaunt(int accaunt) {
        this.accaunt = accaunt;
    }

    public int getAccauntSub() {
        return accauntSub;
    }

    public void setAccauntSub(int accauntSub) {
        this.accauntSub = accauntSub;
    }

    public String getFullAccount() {
        return fullAccount;
    }

    public void setFullAccount(String fullAccount) {
        this.fullAccount = fullAccount;
    }

    public long getCurrency() {
        return currency;
    }

    public void setCurrency(long currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Accaunt{" +
                "id=" + id +
                ", accaunt=" + accaunt +
                ", accauntSub=" + accauntSub +
                ", fullAccount='" + fullAccount + '\'' +
                ", currency=" + currency +
                '}';
    }
}