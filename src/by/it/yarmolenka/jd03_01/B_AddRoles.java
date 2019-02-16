package by.it.yarmolenka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addRoles() {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_PACKAGE, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `yarmolenka`.`roles` (`id`, `role`) " +
                    "VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`roles` (`id`, `role`) " +
                    "VALUES (DEFAULT, 'gambler');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
