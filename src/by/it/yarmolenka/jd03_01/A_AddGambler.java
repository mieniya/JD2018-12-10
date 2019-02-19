package by.it.yarmolenka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddGambler {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addGamblers() {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_PACKAGE, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'admin','admin','admin@mail.ru',1);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'first_gambler','password1','gambler1@mail.ru',2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'second_gambler','password2','gambler2@mail.ru',2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
