package by.it.yarmolenka.jd03_02.beans;

import java.sql.Timestamp;

public class Match {
    private long id;
    private Timestamp date;
    private String description;
    private String result;
    private long fk_sports;
    private long fk_match_status;
    private long fk_admins;

    public Match() {
    }

    public Match(long id, Timestamp date, String description, String result, long fk_sports, long fk_match_status, long fk_admins) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.result = result;
        this.fk_sports = fk_sports;
        this.fk_match_status = fk_match_status;
        this.fk_admins = fk_admins;
    }

    public long getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getResult() {
        return result;
    }

    public long getFk_sports() {
        return fk_sports;
    }

    public long getFk_match_status() {
        return fk_match_status;
    }

    public long getFk_admins() {
        return fk_admins;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setFk_sports(long fk_sports) {
        this.fk_sports = fk_sports;
    }

    public void setFk_match_status(long fk_match_status) {
        this.fk_match_status = fk_match_status;
    }

    public void setFk_admins(long fk_admins) {
        this.fk_admins = fk_admins;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                ", fk_sports=" + fk_sports +
                ", fk_match_status=" + fk_match_status +
                ", fk_admins=" + fk_admins +
                '}';
    }
}
