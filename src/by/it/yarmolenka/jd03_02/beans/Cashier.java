package by.it.yarmolenka.jd03_02.beans;

public class Cashier {
    private long id;
    private double overall;
    private double available;
    private double in_bets;
    private long fk_gamblers;
    private long fk_admins;

    public Cashier() {
    }

    public Cashier(long id, double overall, double available, double in_bets, long fk_gamblers, long fk_admins) {
        this.id = id;
        this.overall = overall;
        this.available = available;
        this.in_bets = in_bets;
        this.fk_gamblers = fk_gamblers;
        this.fk_admins = fk_admins;
    }

    public long getId() {
        return id;
    }

    public double getOverall() {
        return overall;
    }

    public double getAvailable() {
        return available;
    }

    public double getIn_bets() {
        return in_bets;
    }

    public long getFk_gamblers() {
        return fk_gamblers;
    }

    public long getFk_admins() {
        return fk_admins;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public void setIn_bets(double in_bets) {
        this.in_bets = in_bets;
    }

    public void setFk_gamblers(long fk_gamblers) {
        this.fk_gamblers = fk_gamblers;
    }

    public void setFk_admins(long fk_admins) {
        this.fk_admins = fk_admins;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "id=" + id +
                ", overall=" + overall +
                ", available=" + available +
                ", in_bets=" + in_bets +
                ", fk_gamblers=" + fk_gamblers +
                ", fk_admins=" + fk_admins +
                '}';
    }
}
