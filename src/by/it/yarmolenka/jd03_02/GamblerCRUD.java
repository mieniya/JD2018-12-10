package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.beans.Gambler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class GamblerCRUD {

    boolean create(Gambler gambler) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `gamblers` (`login`, `email`, `password`) " +
                    "VALUES ('%s', '%s', '%s')", gambler.getLogin(), gambler.getEmail(), gambler.getPassword());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    gambler.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Gambler read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `gamblers` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                Gambler gambler = new Gambler();
                gambler.setId(resultSet.getLong("id"));
                gambler.setLogin(resultSet.getString("login"));
                gambler.setEmail(resultSet.getString("email"));
                gambler.setPassword(resultSet.getString("password"));
                return gambler;
            }
        }
        return null;
    }

    boolean update(Gambler gambler) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("UPDATE `gamblers` SET `login`='%s', `email`='%s', " +
                    "`password`='%s' WHERE `id`='%d'", gambler.getLogin(), gambler.getEmail(),
                    gambler.getPassword(), gambler.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }

    boolean delete(Gambler gambler) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("DELETE FROM `gamblers` WHERE `id`='%d'", gambler.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }
}
