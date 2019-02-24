package by.it.naron.jd03_03.beans;

import java.util.Objects;

public class Roles {
 //fields
    private long id;
    private String role;

//construcrors


    public Roles() {
    }

    public Roles(long id, String role) {
        this.id = id;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return id == roles.id &&
                Objects.equals(role, roles.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, role);
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
