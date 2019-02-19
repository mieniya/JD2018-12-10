package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class B_AddRoles {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addRoles() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');"));
            statement.executeUpdate(String.format("%s","INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
