package by.it.dziomin.jd03_01;

import java.sql.SQLException;

import static by.it.dziomin.jd03_01.SQL_queries.CreateTables.*;

class C_Init {

    static void init() {
        try {

            DBConnector.getStatement().executeUpdate(CREATE_SCHEMA);
            System.out.println("Schema created");
            DBConnector.getStatement().executeUpdate(CREATE_ROLES);
            System.out.println("table roles created");
            DBConnector.getStatement().executeUpdate(CREATE_USERS);
            System.out.println("table users created");
            DBConnector.getStatement().executeUpdate(CREATE_CARS);
            System.out.println("table cars created");
            DBConnector.getStatement().executeUpdate(CREATE_RENTS);
            System.out.println("table rents created");

        } catch (SQLException e) {
            System.out.println("Ошибка инициализации");
        }

    }
}

