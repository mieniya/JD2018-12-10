package by.it.zagurskaya.jd03_02.beans;

public class User {
    private long idUser;
    private String login;
    private String password;
    private long roleId;

    public User() {
    }

    public User(long idUser, String login, String password, long roleId) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
