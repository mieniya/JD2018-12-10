package by.it.zagurskaya.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {

    public void addUser(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `zagurskaya`.`users` (`idUser`, `login`, `password`, `roleId`) VALUES (DEFAULT, 'Sidorova', 'Sidorova', 2);");

        }
    }
}
