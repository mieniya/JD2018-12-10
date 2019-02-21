package by.it.zagurskaya.jd03_02.crud;

import by.it.zagurskaya.jd03_02.ConnCreator;
import by.it.zagurskaya.jd03_02.beans.UserEntry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserEntryCRUD implements CRUD<UserEntry> {

    public boolean create(UserEntry userEntry) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `usersEntries`(`idUsersEntrys`, `numberUserOperation`, `numberEntry`, `currencyEntry`, `accauntDebitEntry`, `accauntKreditEntry`, `sumEntry`, `isSpeting`, `rateEntry`)" +
                            "VALUES ('%d','%s','%s','%s','%s','%s','%s','%s','%s')",
                    userEntry.getIdUsersEntries(), userEntry.getNumberUserOperation(), userEntry.getNumberEntry(), userEntry.getCurrencyEntry(), userEntry.getAccauntDebitEntry(), userEntry.getAccauntKreditEntry(), userEntry.getSumEntry(), userEntry.getIsSpeting(), userEntry.getRateEntry());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    userEntry.setIdUsersEntries(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public UserEntry read(long idUserEntry) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `usersEntries` WHERE `idUserEntry`='%d'",
                    idUserEntry);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                UserEntry userEntry = new UserEntry();
                userEntry.setIdUsersEntries(resultSet.getLong("idUsersEntries"));
                userEntry.setNumberUserOperation(resultSet.getLong("numberUserOperation"));
                userEntry.setNumberEntry(resultSet.getLong("numberEntry"));
                userEntry.setCurrencyEntry(resultSet.getInt("currencyEntry"));
                userEntry.setAccauntDebitEntry(resultSet.getString("accauntDebitEntry"));
                userEntry.setAccauntKreditEntry(resultSet.getString("accauntKreditEntry"));
                userEntry.setSumEntry(resultSet.getDouble("sumEntry"));
                userEntry.setIsSpeting(resultSet.getBoolean("isSpeting"));
                userEntry.setRateEntry(resultSet.getDouble("rateEntry"));
                return userEntry;
            }
        }
        return null;
    }

    public boolean update(UserEntry userEntry) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `usersEntries` SET `numberUserOperation`='%s', `numberEntry`='%s',`currencyEntry`='%s' ,`accauntDebitEntry`='%s' ,`accauntDebitEntry`='%s',`accauntKreditEntry`='%s',`sumEntry`='%s',`isSpeting`='%s', `rateEntry`='%s',`idUsersEntries`='%d'  WHERE `idUsersEntries`='%d'",
                    userEntry.getNumberUserOperation(), userEntry.getNumberEntry(), userEntry.getCurrencyEntry(), userEntry.getAccauntDebitEntry(), userEntry.getAccauntKreditEntry(), userEntry.getSumEntry(), userEntry.getIsSpeting(), userEntry.getRateEntry(),
                    userEntry.getIdUsersEntries());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(UserEntry userEntry) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `usersEntries` WHERE `idUsersEntries`='%s'",
                    userEntry.getIdUsersEntries());
            return 1 == statement.executeUpdate(sql);
        }
    }

}
