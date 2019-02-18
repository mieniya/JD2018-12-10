package by.it.zagurskaya.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles {

    public void addRole(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `zagurskaya`.`roles` (`idRole`, `roleName`) VALUES (DEFAULT, 'controller');");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`users` (`idUser`, `login`, `password`, `roleId`) VALUES (DEFAULT, 'Kozlova', 'Kozlova', (SELECT idRole FROM `zagurskaya`.`roles` WHERE roleName ='controller'));");
        }
    }
}
