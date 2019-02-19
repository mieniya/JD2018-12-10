package by.it.naron.jd03_02.crudOperations;

import by.it.naron.jd03_02.beans.Goods_flower;
import by.it.naron.jd03_02.tools.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Goods_flowerCrud {


    public boolean create(Goods_flower goods_flower) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `goods_flower`(`name`, `colour`, `size`)\n" +
                            "VALUES  ('%s','%s','%d');",
                    goods_flower.getName(), goods_flower.getColour(),
                    goods_flower.getSize());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    goods_flower.setId(generatedKeys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }



    public Goods_flower read(int id) throws SQLException {
        String readGoods_flowerSql = String.format("SELECT `id`, " +
                        "`name`, `colour`, `size` " +
                        "FROM `goods_flower` WHERE id=%d",
                id);
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(readGoods_flowerSql);
            if (resultSet.next()) {
                return new Goods_flower(id,
                        resultSet.getString("name"),
                        resultSet.getString("colour"),
                        resultSet.getInt("size"));
            } else return null;
        }
    }


    public boolean update(Goods_flower goods_flower) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `goods_flower` " +
                            "SET `name`='%s',`colour`='%s',`size`='%d'" +
                            "WHERE `id`='%d'",
                    goods_flower.getName(), goods_flower.getColour(),
                    goods_flower.getSize(),  goods_flower.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Goods_flower goods_flower) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `goods_flower` WHERE `id`='%d'",
                    goods_flower.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }












}
