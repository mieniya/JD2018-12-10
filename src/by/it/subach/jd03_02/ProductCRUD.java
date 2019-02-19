package by.it.subach.jd03_02;

import by.it.subach.jd03_02.beans.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductCRUD {

    boolean create(Product product) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `products`" +
                            "(`product_name`, `product_price`, `product_description`, `categories_id`) " +
                            "VALUES ('%s','%.2f','%s','%d')",
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getCategory_id()
            );
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    product.setId(generatedKeys.getInt("id"));
                    return true;
                }
            }
        }
        return false;
    }

    Product read(long id) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `products` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDescription(resultSet.getString("description"));
                product.setCategory_id(resultSet.getInt("categories_id"));
            }
        }
        return null;
    }

    boolean update(Product product) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `products` " +
                            "SET `product_name`='%s',`product_price`='%.2f',`product_description`='%s',`categories_id`='%d' " +
                            "WHERE `id`='%d'",
                    product.getName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getCategory_id(),
                    product.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(Product product) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `products` WHERE `id`='%d'",
                    product.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }

}
