package by.it.naron.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    protected void dropDB() {

        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/" +
                                     "?useUnicode=true&characterEncoding=UTF-8",
                             "root",
                             "");
             Statement statement = connection.createStatement()
        ) {

  //          statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`orders` ;");
//                 statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`users` ;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`roles` ;");
 //         statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`goods_flower` ;");
            statement.executeUpdate("DROP DATABASE  IF EXISTS `naron` ;");

        } catch (SQLException e) {
            e.printStackTrace();

        }
///////////////////////////////////////////////////////////////////////////



    }
}
