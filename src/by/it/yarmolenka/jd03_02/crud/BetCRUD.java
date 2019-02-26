package by.it.yarmolenka.jd03_02.crud;

import by.it.yarmolenka.jd03_02.ConnectionCreator;
import by.it.yarmolenka.jd03_02.beans.Bet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class BetCRUD {

    public boolean create(Bet bet) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format(Locale.ENGLISH, "INSERT INTO `bets` (`amount`, `payout`, `fk_users`, `fk_events`) " +
                    "VALUES ('%f', '%f', '%d', '%d')", bet.getAmount(), bet.getPayout(), bet.getFk_users(),
                    bet.getFk_events());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    bet.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Bet read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("SELECT * FROM `bets` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return new Bet(
                        resultSet.getLong("id"),
                        resultSet.getDouble("amount"),
                        resultSet.getDouble("payout"),
                        resultSet.getLong("fk_users"),
                        resultSet.getLong("fk_events")
                );
            }
        }
        return null;
    }

    public boolean update(Bet bet) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format(Locale.ENGLISH, "UPDATE `bets` SET `amount`='%f', `payout`='%f', " +
                    "`fk_users`='%d', `fk_events`='%d' WHERE `id`='%d'", bet.getAmount(),
                    bet.getPayout(), bet.getFk_users(), bet.getFk_events(), bet.getId());
            return statement.executeUpdate(sql) == 1;

        }
    }

    public boolean delete(Bet bet) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("DELETE FROM `bets` WHERE `id`='%d'", bet.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }
}
