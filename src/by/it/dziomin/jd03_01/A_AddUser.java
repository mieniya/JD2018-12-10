package by.it.dziomin.jd03_01;

import java.sql.SQLException;

import static by.it.dziomin.jd03_01.SQL_queries.AddData.ADD_USERS;

class A_AddUser {

    static void addUsers() {
        try {
            for (String addUser : ADD_USERS) {
                DBConnector.getStatement().executeUpdate(addUser);
            }
            System.out.println("users added");

        } catch (SQLException e) {
            System.out.println("Ошибка заполнения таблицы пользователей");
        }

    }

}
