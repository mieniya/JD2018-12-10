package by.it.a_khmelev.jd03_03.dao;

import by.it.a_khmelev.jd03_03.beans.Role;

public class RoleDao extends UniversalDao<Role>{
    public RoleDao() {
        super(Role.class, "roles");
    }
}
