package by.it.subach.jd03_02;

import by.it.subach.jd03_02.beans.Checkout;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckoutCRUD {

    boolean create(Checkout checkout) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `checkout`(`checkout_status`, `order_id`) " +
                            "VALUES ('%b','%d')",
                    checkout.isCheckoutStatus(),
                    checkout.getOrder_id()
            );
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    checkout.setId(generatedKeys.getInt("id"));
                    return true;
                }
            }
        }
        return false;
    }

    Checkout read(int id) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `checkout` WHERE `id`='%d'",
                    id
            );
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                Checkout checkout = new Checkout();
                checkout.setId(resultSet.getInt("id"));
                checkout.setCheckoutStatus(resultSet.getBoolean("checkout_status"));
                checkout.setOrder_id(resultSet.getInt("order_id"));
            }
        }
        return null;
    }

    boolean update(Checkout checkout) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `checkout` " +
                    "SET `checkout_status`='%b',`order_id`='%d' " +
                    "WHERE `id`='%d'",
                    checkout.isCheckoutStatus(),
                    checkout.getOrder_id(),
                    checkout.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(Checkout checkout) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `checkout` WHERE `id`='%d'",
                    checkout.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }
}
