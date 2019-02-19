package by.it.yarmolenka.jd03_02.beans;

public class Event {
    private long id;
    private String description;
    private double odds;
    private long fk_matches;
    private long fk_admins;

    public Event() {
    }

    public Event(long id, String description, double odds, long fk_matches, long fk_admins) {
        this.id = id;
        this.description = description;
        this.odds = odds;
        this.fk_matches = fk_matches;
        this.fk_admins = fk_admins;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getOdds() {
        return odds;
    }

    public long getFk_matches() {
        return fk_matches;
    }

    public long getFk_admins() {
        return fk_admins;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public void setFk_matches(long fk_matches) {
        this.fk_matches = fk_matches;
    }

    public void setFk_admins(long fk_admins) {
        this.fk_admins = fk_admins;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", odds=" + odds +
                ", fk_matches=" + fk_matches +
                ", fk_admins=" + fk_admins +
                '}';
    }
}
