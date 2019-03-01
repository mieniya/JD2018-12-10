package by.it.lyakhova.jd03_02;

import by.it.lyakhova.jd03_02.crud.ConnCreator;

import java.sql.*;

public class TaskB {

    public static void main(String[] args) {

        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()
             ) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users INNER JOIN roles ON users.id = roles.id");
            while (resultSet.next()){
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount; i++) {
                    System.out.println(
                            resultSetMetaData.getColumnLabel(i) + "=" +
                            resultSet.getString(i));
                }
            }
            System.out.println();

            resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");
            if (resultSet.next()){
                System.out.println("Count of users = " + resultSet.getInt(1));
            }

            resultSet = statement.executeQuery("SELECT COUNT(*) FROM roles");
            if (resultSet.next()){
                System.out.println("Count of roles = " + resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
