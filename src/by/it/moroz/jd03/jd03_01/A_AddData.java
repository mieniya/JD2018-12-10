package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class A_AddData {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addData() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`)" +
                    " VALUES (DEFAULT, 'Pizza', 2, 28.35, 56.7, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 'Spaghetti pepperoni', 1, 18.26, 18.26, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 'Coffee', 2, 5.00, 5.00, 1);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 'Steak', 1, 35.85, 35.85, 3);"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 'Salad', 1, 13.25, 13.25, 3);"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
