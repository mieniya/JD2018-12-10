package by.it.yarmolenka.jd03_02.beans;

public class Sport {
    private long id;
    private String sport;

    public Sport() {
    }

    public Sport(long id, String sport) {
        this.id = id;
        this.sport = sport;
    }

    public long getId() {
        return id;
    }

    public String getSport() {
        return sport;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    @Override
    public String toString() {
        return "Sport{id=" + id + ", sport='" + sport + "\'}";
    }
}
