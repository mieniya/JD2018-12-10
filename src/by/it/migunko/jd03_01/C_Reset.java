package by.it.migunko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/"+
                                     "?useUnicode=true&characterEncoding=UTF-8",
                             "root",
                             "");
             Statement statement = connection.createStatement()){


            statement.executeUpdate("DROP TABLE IF EXISTS `migunko`.`tours`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `migunko`.`users`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `migunko`.`roles`;");

            statement.executeUpdate("DROP DATABASE IF EXISTS `migunko`;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
