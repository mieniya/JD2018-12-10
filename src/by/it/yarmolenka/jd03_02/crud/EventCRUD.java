package by.it.yarmolenka.jd03_02.crud;

import by.it.yarmolenka.jd03_02.ConnectionCreator;
import by.it.yarmolenka.jd03_02.beans.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class EventCRUD {

    public boolean create(Event event) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format(Locale.ENGLISH,"INSERT INTO `events` (`description`, `odds`, `fk_races`) " +
                    "VALUES ('%s', '%f', '%d')", event.getDescription(), event.getOdds(), event.getFk_races());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    event.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Event read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("SELECT * FROM `events` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return new Event(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getDouble("odds"),
                        resultSet.getLong("fk_races")
                );
            }
        }
        return null;
    }

    public boolean update(Event event) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format(Locale.ENGLISH,"UPDATE `events` SET `description`='%s', " +
                    "`odds`='%f', `fk_races`='%d' WHERE `id`='%d'", event.getDescription(),
                    event.getOdds(), event.getFk_races(), event.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }

    public boolean delete(Event event) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("DELETE FROM `events` WHERE `id`='%d'", event.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }
}
