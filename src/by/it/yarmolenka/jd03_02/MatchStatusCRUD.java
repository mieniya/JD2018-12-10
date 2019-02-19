package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.beans.MatchStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MatchStatusCRUD {

    boolean create(MatchStatus matchStatus) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `match_status` (`status`) VALUES ('%s')",
                    matchStatus.getStatus());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    matchStatus.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    MatchStatus read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `match_status` WHERE `id`='%s'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                MatchStatus status = new MatchStatus();
                status.setId(resultSet.getLong("id"));
                status.setStatus(resultSet.getString("status"));
                return status;
            }
        }
        return null;
    }

    boolean update(MatchStatus status) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `match_status` SET `status`='%s' WHERE `id`='%d'",
                    status.getStatus(), status.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }

    boolean delete(MatchStatus status) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `match_status` WHERE `id`='%d'", status.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }
}
