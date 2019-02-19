package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.beans.Cashier;
import by.it.yarmolenka.jd03_02.beans.Cashier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class CashierCRUD {

    boolean create(Cashier cashier) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `cashiers` (`overall`, `available`, `in_bets`, " +
                            "`fk_gamblers`, `fk_admins`) VALUES ('%f', '%f', '%f', '%d', '%d')",
                    cashier.getOverall(), cashier.getAvailable(), cashier.getIn_bets(),
                    cashier.getFk_gamblers(), cashier.getFk_admins());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cashier.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Cashier read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `cashiers` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Cashier cashier = new Cashier();
                cashier.setId(resultSet.getLong("id"));
                cashier.setOverall(resultSet.getDouble("overall"));
                cashier.setAvailable(resultSet.getDouble("available"));
                cashier.setIn_bets(resultSet.getDouble("in_bets"));
                cashier.setFk_gamblers(resultSet.getLong("fk_gamblers"));
                cashier.setFk_admins(resultSet.getLong("fk_admins"));
                return cashier;
            }
        }
        return null;
    }

    boolean update(Cashier cashier) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `cashiers` SET `overall`='%f', `available`='%f', " +
                            "`in_bets`='%f', `fk_gamblers`='%d', `fk_admins`='%d' WHERE `id`='%d'",
                    cashier.getOverall(), cashier.getAvailable(), cashier.getIn_bets(),
                    cashier.getFk_gamblers(), cashier.getFk_admins(), cashier.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }

    boolean delete(Cashier cashier) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `cashiers` WHERE `id`='%d'", cashier.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }
}
