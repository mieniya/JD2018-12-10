package by.it.zagurskaya.jd03_02.beans;

public class Role {
    private long idRole;
    private String roleName;

    public Role() {
    }

    public Role(long idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
