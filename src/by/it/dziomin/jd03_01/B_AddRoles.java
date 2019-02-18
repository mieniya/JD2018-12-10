package by.it.dziomin.jd03_01;

import java.sql.SQLException;

import static by.it.dziomin.jd03_01.SQL_queries.AddData.ADD_ROLES;

class B_AddRoles {
    static void addRoles() {
        try {
            for (String addRole : ADD_ROLES) {
                DBConnector.getStatement().executeUpdate(addRole);
            }
            System.out.println("roles added");

        } catch (SQLException e) {
            System.out.println("Ошибка заполнения таблицы ролей");
        }
    }
}
