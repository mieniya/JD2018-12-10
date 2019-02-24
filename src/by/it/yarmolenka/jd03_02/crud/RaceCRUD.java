package by.it.yarmolenka.jd03_02.crud;

import by.it.yarmolenka.jd03_02.ConnectionCreator;
import by.it.yarmolenka.jd03_02.beans.Race;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RaceCRUD {

    public boolean create(Race race) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("INSERT INTO `races` (`date`, `race_track`, `description`) " +
                    "VALUES ('%s', '%s', '%s')", race.getDate(), race.getRace_track(), race.getDescription());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    race.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Race read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("SELECT * FROM `races` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return new Race(
                        resultSet.getLong("id"),
                        resultSet.getTimestamp("date"),
                        resultSet.getString("race_track"),
                        resultSet.getString("description")
                );
            }
        }
        return null;
    }

    public boolean update(Race race) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("UPDATE `races` SET `date`='%s', `race_track`='%s', " +
                    "`description`='%s' WHERE `id`='%d'", race.getDate(), race.getRace_track(),
                    race.getDescription(), race.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }

    public boolean delete(Race race) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("DELETE FROM `races` WHERE `id`='%d'", race.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }
}
