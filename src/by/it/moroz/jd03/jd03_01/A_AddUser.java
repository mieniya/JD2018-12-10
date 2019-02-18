package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddUser {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addUsers(){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8", "root", ""))  {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, " +
                    "`name`, `surname`, `numberphone`, `roles_id`) " +
                    "VALUES (DEFAULT, 'TrinzoA', 'qwerty123', 'trizzzno@gmail.com', 'Nezavisimosti, 54-84', " +
                    "'Andrei', 'Trizno', 298563456, 2);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'BorokhaM', 'borokha', " +
                    "NULL, NULL, 'Maria', 'Borokha', NULL, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, NULL, NULL, NULL, 'Kedishko, 3-1', " +
                    "'Vladislau', 'Makarevich', 447568394, 3);"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
