package by.it.naron.jd03_02;

import by.it.naron.jd03_02.tools.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {
        String sql = "SELECT * FROM roles INNER JOIN users ON users.roles_id=roles.id";
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                System.out.printf("%s: %-20s", metaData.getColumnLabel(2), resultSet.getString(2));
                System.out.print(metaData.getColumnLabel(4) + ": " + resultSet.getString(4) + "\t\t");
                System.out.print(metaData.getColumnLabel(3) + ": " + resultSet.getString(3) + "\t\t");
                System.out.println();
            }
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM roles WHERE id>0");
            if (resultSet.next()) {
                System.out.println("количество возможных ролей: " + resultSet.getInt(1));
            }
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM users WHERE id>0");
            if (resultSet.next()) {
                System.out.println("количество пользователей: " + resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
