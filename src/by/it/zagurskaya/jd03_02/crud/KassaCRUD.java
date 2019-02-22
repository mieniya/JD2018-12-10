package by.it.zagurskaya.jd03_02.crud;


import by.it.zagurskaya.jd03_02.ConnCreator;
import by.it.zagurskaya.jd03_02.beans.Kassa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KassaCRUD implements CRUD<Kassa> {

    @Override
    public boolean create(Kassa kassa) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `kassa`(`idKassa`,`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCurrency`, `numberUser`, `date`, `duties`) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                    kassa.getIdCurrency(), kassa.getReceivedCurrency(),kassa.getComingCurrency(),kassa.getSpendingCurrency(), kassa.getHendedCurrency(), kassa.getBalanceCurrency(), kassa.getNumberUser(),kassa.getDate(), kassa.getDuties());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    kassa.setIdKassa(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Kassa readByUserNumber(int numberUser) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `kassa` WHERE `numberUser`='%d'",
                    numberUser);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Kassa kassa = new Kassa();
                kassa.setIdKassa(resultSet.getLong("idKassa"));
                kassa.setIdCurrency(resultSet.getInt("idCurrency"));
                kassa.setReceivedCurrency(resultSet.getDouble("receivedCurrency"));
                kassa.setComingCurrency(resultSet.getDouble("comingCurrency"));
                kassa.setSpendingCurrency(resultSet.getDouble("spendingCurrency"));
                kassa.setHendedCurrency(resultSet.getDouble("hendedCurrency"));
                kassa.setBalanceCurrency(resultSet.getDouble("balanceCurrency"));
                kassa.setNumberUser(resultSet.getInt("numberUser"));
                kassa.setDate(resultSet.getTimestamp("date"));
                kassa.setDuties(resultSet.getInt("duties"));
                return kassa;
            }
        }
        return null;
    }

    @Override
    public boolean update(Kassa kassa) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    " UPDATE `kassa` SET `receivedCurrency`='%s', `comingCurrency`='%s', `spendingCurrency`='%s', `hendedCurrency`='%s', `balanceCurrency`='%s', `numberUser`='%s', `date`='%s', `duties`='%s' WHERE `idCurrency`='%d'",
                    kassa.getReceivedCurrency(),
                    kassa.getComingCurrency(),
                    kassa.getSpendingCurrency(),
                    kassa.getHendedCurrency(),
                    kassa.getBalanceCurrency(),
                    kassa.getNumberUser(),
                    kassa.getDate(),
                    kassa.getDuties(),
                    kassa.getIdCurrency());
            return 1 == statement.executeUpdate(sql);
        }
    }

    @Override
    public Kassa read(long idKassa) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `kassa` WHERE `idKassa`='%d'",
                    idKassa);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Kassa kassa = new Kassa();
                kassa.setIdKassa(resultSet.getLong("idKassa"));
                kassa.setIdCurrency(resultSet.getInt("idCurrency"));
                kassa.setReceivedCurrency(resultSet.getDouble("receivedCurrency"));
                kassa.setComingCurrency(resultSet.getDouble("comingCurrency"));
                kassa.setSpendingCurrency(resultSet.getDouble("spendingCurrency"));
                kassa.setHendedCurrency(resultSet.getDouble("hendedCurrency"));
                kassa.setBalanceCurrency(resultSet.getDouble("balanceCurrency"));
                kassa.setNumberUser(resultSet.getInt("numberUser"));
                kassa.setDate(resultSet.getTimestamp("date"));
                kassa.setDuties(resultSet.getInt("duties"));
                return kassa;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Kassa kassa) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `kassa` WHERE `idCurrency`='%d'",
                    kassa.getIdCurrency());
            return 1 == statement.executeUpdate(sql);
        }
    }

}
