package by.it.naron.jd03_04.java.dao;


import by.it.naron.jd03_04.java.beans.Roles;

public class RolesDao extends UniversalDao<Roles> {
    public RolesDao() {
        super(Roles.class, "roles");
    }
}
