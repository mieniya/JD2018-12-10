package by.it.zagurskaya.jd03_02.crud;

import by.it.zagurskaya.jd03_02.ConnCreator;
import by.it.zagurskaya.jd03_02.beans.UserOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserOperationCRUD implements CRUD<UserOperation> {


    public boolean create(UserOperation userOperation) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `usersOperations`(`idUserOperation`, `dateOperation`, `rateEntry`, `sumEntry`, `currencyOperation`, `numberUser`, `numberOperation`, `specification`, `checkingAccount`)" +
                            "VALUES ('%d','%s','%s','%s','%s','%s','%s','%s','%s')",
                    userOperation.getIdUserOperation(), userOperation.getDateOperation(), userOperation.getRateEntry(), userOperation.getSumEntry(), userOperation.getCurrencyOperation(), userOperation.getNumberUser(), userOperation.getNumberOperation(), userOperation.getSpecification(), userOperation.getCheckingAccount());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    userOperation.setIdUserOperation(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public UserOperation read(long idUserOperation) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `usersOperations` WHERE `idUserOperation`='%d'",
                    idUserOperation);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                UserOperation userOperation  = new UserOperation();
                userOperation.setIdUserOperation(resultSet.getLong("idUserOperation"));
                userOperation.setDateOperation(resultSet.getTimestamp("dateOperation"));
                userOperation.setRateEntry(resultSet.getDouble("rateEntry"));
                userOperation.setSumEntry(resultSet.getDouble("sumEntry"));
                userOperation.setCurrencyOperation(resultSet.getInt("currencyOperation"));
                userOperation.setNumberUser(resultSet.getInt("numberUser"));
                userOperation.setNumberOperation(resultSet.getLong("numberOperation"));
                userOperation.setSpecification(resultSet.getString("specification"));
                userOperation.setCheckingAccount(resultSet.getString("checkingAccount"));
                return userOperation;
            }
        }
        return null;
    }

    public boolean update(UserOperation userOperation) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `usersOperations` SET `dateOperation`='%s', `rateEntry`='%s',`sumEntry`='%s' ,`currencyOperation`='%s' ,`numberUser`='%s',`numberOperation`='%s',`specification`='%s',`checkingAccount`='%s', `idUserOperation`='%d'  WHERE `idUserOperation`='%d'",
                    userOperation.getDateOperation(), userOperation.getRateEntry(), userOperation.getSumEntry(), userOperation.getCurrencyOperation(), userOperation.getNumberUser(), userOperation.getNumberOperation(),  userOperation.getSpecification(), userOperation.getCheckingAccount(),
                    userOperation.getIdUserOperation());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(UserOperation userOperation) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `usersOperations` WHERE `idUserOperation`='%s'",
                    userOperation.getIdUserOperation());
            return 1 == statement.executeUpdate(sql);
        }
    }
}

