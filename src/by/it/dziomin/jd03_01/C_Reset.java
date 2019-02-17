package by.it.dziomin.jd03_01;

import java.sql.SQLException;

import static by.it.dziomin.jd03_01.SQL_queries.CreateTables.DROP_TABLES;

class C_Reset {

    static void dropTables() {

        try {
            DBConnector.getStatement().executeUpdate(DROP_TABLES);
            System.out.println("tables dropped");
        } catch (SQLException e) {
            System.out.println("Ошибка удаления таблиц");
        }
    }
}
