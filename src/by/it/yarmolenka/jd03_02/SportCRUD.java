package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.beans.Sport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SportCRUD {

    boolean create(Sport sport) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `sports`(`sport`) VALUES ('%s')",
                    sport.getSport());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()){
                    sport.setId(keys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Sport read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("SELECT * FROM `sports` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                Sport sport = new Sport();
                sport.setId(resultSet.getLong("id"));
                sport.setSport(resultSet.getString("sport"));
                return sport;
            }
        }
        return null;
    }

    boolean update(Sport sport) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("UPDATE `sports` SET `sport`='%s' WHERE `id`='%d'",
                    sport.getSport(), sport.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    boolean delete(Sport sport) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("DELETE FROM `sports` WHERE `id`='%d'", sport.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
