package by.it.subach.jd03_02;

import by.it.subach.jd03_02.beans.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryCRUD {

    boolean create(Category category) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `categories`" +
                            "(`category_name`, `category_description`) " +
                            "VALUES ('%s','%s')",
                    category.getName(),
                    category.getDescription()
            );
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    category.setId(generatedKeys.getInt("id"));
                    return true;
                }
            }
        }
        return false;
    }

    Category read(long id) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `categories` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("category_name"));
                category.setDescription(resultSet.getString("category_description"));
            }
        }
        return null;
    }

    boolean update(Category category) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `categories` " +
                            "SET `category_name`='%s',`category_description`='%s' " +
                            "WHERE `id`='%d'",
                    category.getName(),
                    category.getDescription(),
                    category.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(Category category) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `categories` WHERE `id`='%d'",
                    category.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }
}
