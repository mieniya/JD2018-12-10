package by.it.subach.jd03_02.beans;

public class Role {

    private long id;
    private String role;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}

