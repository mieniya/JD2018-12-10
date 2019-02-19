package by.it.titkovskaya.jd03_02.crud;

import java.sql.*;

public class TaskB {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT users.name,roles.role " +
                    "FROM users INNER JOIN roles ON users.roles_id=roles.id");
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.print(resultSet.getString(i) + "\t\t");
                }
                System.out.println();
            }
            resultSet = statement.executeQuery("select count(users.name) from users");
            if (resultSet.next()) {
                System.out.print("TOTAL users: " + resultSet.getInt(1) + "\t");
            }
            resultSet = statement.executeQuery("select count(users.roles_id) " +
                    "FROM users INNER JOIN roles ON users.roles_id=roles.id");
            if (resultSet.next()) {
                System.out.println("TOTAL roles: " + resultSet.getInt(1));
            }
        }
    }
}
