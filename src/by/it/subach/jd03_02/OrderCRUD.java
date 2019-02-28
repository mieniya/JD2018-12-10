package by.it.subach.jd03_02;

import by.it.subach.jd03_02.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderCRUD {

    boolean create(Order order) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `orders`(`user_id`, `product_id`) " +
                            "VALUES ('%d','%d')",
                    order.getUser_id(),
                    order.getProduct_id()
                    );
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setId(generatedKeys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }

    Order read(int id) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `orders` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUser_id(resultSet.getLong("user_id"));
                order.setProduct_id(resultSet.getInt("product_id"));
                return order;
            }
        }
        return null;
    }

    boolean update(Order order) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `orders` " +
                    "SET `user_id`='%d',`product_id`='%d' " +
                    "WHERE `id`='%d'",
                    order.getUser_id(),
                    order.getProduct_id(),
                    order.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(Order order) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `orders` WHERE `id`='%d'",
                    order.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }

    }
}
