package by.it.yarmolenka.jd03_02.beans;


public class Bet {
    private long id;
    private double amount;
    private double payout;
    private long fk_events;
    private long fk_gamblers;
    private long fk_cashiers;

    public Bet() {
    }

    public Bet(long id, double amount, double payout, long fk_events, long fk_gamblers, long fk_cashiers) {
        this.id = id;
        this.amount = amount;
        this.payout = payout;
        this.fk_events = fk_events;
        this.fk_gamblers = fk_gamblers;
        this.fk_cashiers = fk_cashiers;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public double getPayout() {
        return payout;
    }

    public long getFk_events() {
        return fk_events;
    }

    public long getFk_gamblers() {
        return fk_gamblers;
    }

    public long getFk_cashiers() {
        return fk_cashiers;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayout(double payout) {
        this.payout = payout;
    }

    public void setFk_events(long fk_events) {
        this.fk_events = fk_events;
    }

    public void setFk_gamblers(long fk_gamblers) {
        this.fk_gamblers = fk_gamblers;
    }

    public void setFk_cashiers(long fk_cashiers) {
        this.fk_cashiers = fk_cashiers;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", amount=" + amount +
                ", payout=" + payout +
                ", fk_events=" + fk_events +
                ", fk_gamblers=" + fk_gamblers +
                ", fk_cashiers=" + fk_cashiers +
                '}';
    }
}
