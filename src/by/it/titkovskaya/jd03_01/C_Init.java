package by.it.titkovskaya.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root", 
                "");
             Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS 'titkovskaya' ;");
            statement.executeUpdate("");
            statement.executeUpdate("");
            statement.executeUpdate("");
            statement.executeUpdate("");
            statement.executeUpdate("");
            statement.executeUpdate("");
            statement.executeUpdate("");
            statement.executeUpdate("");
            statement.executeUpdate("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
