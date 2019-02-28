package by.it.titkovskaya.jd03.jd03_03.beans;

public class AccountStatus {

    private long id;
    private String status;

    public AccountStatus() {
    }

    public AccountStatus(long id, String status) {
        this.id = id;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\nAccountStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
