package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Reset {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void resetDB(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                "?useUnicode=true&characterEncoding=UTF-8", "root", "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("%s","DROP SCHEMA IF EXISTS `moroz` ;"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
