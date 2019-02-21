package by.it.subach.jd03_03;

import by.it.subach.jd03_03.beans.Role;

public class RoleDao extends UniversalDAO<Role>{
    public RoleDao(Class<Role> aClass, String sqlTableName) {
        super(Role.class, "role");
    }
}
