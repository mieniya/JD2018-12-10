package by.it.subach.jd03_02;

import by.it.subach.jd03_02.beans.BlackList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BlacklistCRUD {

    boolean create(BlackList blackList) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("INSERT INTO `blacklist`(`user_id`) VALUES ('%d')",
                    blackList.getUser_id()
            );
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    blackList.setId(generatedKeys.getInt("id"));
                    return true;
                }
            }
        }
        return false;


    }

    BlackList read(long id) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `blacklist` WHERE `id`='%d'",
                    id
            );
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                BlackList blackList = new BlackList();
                blackList.setId(resultSet.getInt("id"));
                blackList.setUser_id(resultSet.getLong("user_id"));
            }
        }
        return null;
    }

    boolean update(BlackList blackList) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("UPDATE `blacklist` " +
                    "SET `user_id`='%d' WHERE `id`='%d'",
                    blackList.getUser_id(),
                    blackList.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }

    }

    boolean delete(BlackList blackList) throws SQLException {
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("DELETE FROM `blacklist` WHERE `id`='%d'",
                    blackList.getId()
            );
            return 1 == statement.executeUpdate(sql);
        }
    }
}
