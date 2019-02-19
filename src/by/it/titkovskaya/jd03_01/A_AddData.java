package by.it.titkovskaya.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddData {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    void addData(){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "");
             Statement statement = connection.createStatement())
        {
            statement.executeUpdate("INSERT INTO `titkovskaya`.`accounts` (`id`, `number`, `balance`, `currency`, `users_id`, `account status_id`) VALUES (DEFAULT, 444444444, 750000, 'USD', 4, 1);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`replenishments` (`id`, `date`, `amount`, `accounts_id`) VALUES (DEFAULT, '17.02.2019', 75000, 4);");
            statement.executeUpdate("INSERT INTO `titkovskaya`.`payments` (`id`, `date`, `amount`, `recipient`, `accounts_id`, `payment status_id`) VALUES (DEFAULT, '17.02.2019', 15000, 'gmbh XXX', 4, 1);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
