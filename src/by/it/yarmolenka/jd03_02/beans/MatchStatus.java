package by.it.yarmolenka.jd03_02.beans;

public class MatchStatus {
    private long id;
    private String status;

    public MatchStatus() {
    }

    public MatchStatus(long id, String status) {
        this.id = id;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MatchStatus{id=" + id + ", finished=" + status + '}';
    }
}
