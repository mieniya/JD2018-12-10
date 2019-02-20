package by.it.naron.jd03_02.crudOperations;

import by.it.naron.jd03_02.beans.Orders;
import by.it.naron.jd03_02.tools.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class OrdersCrud {

    public boolean create(Orders orders) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
      //      String sql = String.format(Locale.ENGLISH)
            String sql = String.format(Locale.ENGLISH,
                    "INSERT INTO `orders`" +
                            "(`amount`, `time_delivery`, `price`, `users_id`, `goods_Flower_id`) " +
                            "VALUES ('%d','%d','%.2f','%d','%d')",
                    orders.getAmount(), orders.getTime_delivery(), orders.getPrice(),
                    orders.getUsers_id(), orders.getGoods_flower_id());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orders.setId(generatedKeys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }



    public Orders read(int id) throws SQLException {
        Orders ordersResult = null;
        String readOrdersSql = String.format(Locale.ENGLISH,
                "SELECT `id`, `amount`, `time_delivery`, `price`, " +
                "`users_id`, `goods_flower_id` FROM `orders` WHERE id = %d",id);
        try(Connection connection = Connect.getConnection();
            Statement statement = connection.createStatement()
        ){


            ResultSet resultSet = statement.executeQuery(readOrdersSql);
            if(resultSet.next()){
                ordersResult = new Orders(
                        resultSet.getInt("id") ,
                        resultSet.getInt("amount"),
                        resultSet.getInt("time_delivery"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("users_id"),
                        resultSet.getInt("goods_flower_id"));
                return ordersResult;
            }else
                return null;
        }
    }

    public boolean update(Orders orders) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "UPDATE `orders` " +
                     "SET `amount`='%d',`time_delivery`='%d',`price`='%.2f'," +
                            "`users_id`='%d', `goods_Flower_id`='%d' " +
                            "WHERE `id`='%d'",
                    orders.getAmount(), orders.getTime_delivery(), orders.getPrice(),
                    orders.getUsers_id(), orders.getGoods_flower_id(),orders.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Orders orders) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "DELETE FROM `orders` WHERE `id`='%d'",
                    orders.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }






}
