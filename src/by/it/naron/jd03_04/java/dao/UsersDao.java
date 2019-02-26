package by.it.naron.jd03_04.java.dao;


import by.it.naron.jd03_04.java.beans.Users;

public class UsersDao extends UniversalDao<Users> {
    public UsersDao() {
        super(Users.class, "ads");
    }
}
