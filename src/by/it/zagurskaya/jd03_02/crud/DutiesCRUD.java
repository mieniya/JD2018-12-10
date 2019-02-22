package by.it.zagurskaya.jd03_02.crud;

import by.it.zagurskaya.jd03_02.ConnCreator;
import by.it.zagurskaya.jd03_02.beans.Duties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DutiesCRUD implements CRUD<Duties> {

    public boolean create(Duties duties) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `duties`(`numberUser`, `dateDuties`, `numberDuties`, `isClose`)" +
                            "VALUES ('%s','%s','%s','%d')",
                    duties.getNumberUser(), duties.getDateDuties(), duties.getNumberDuties(), duties.getIdDuties());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    duties.setIdDuties(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Duties read(long idDuties) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `duties` WHERE `idDuties`='%d'",
                    idDuties);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Duties duties = new Duties();
                duties.setNumberUser(resultSet.getInt("numberUser"));
                duties.setDateDuties(resultSet.getTimestamp("dateDuties"));
                duties.setNumberDuties(resultSet.getInt("numberDuties"));
                duties.setClose(resultSet.getBoolean("isClose"));
                return duties;
            }
        }
        return null;
    }

    public boolean update(Duties duties) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `duties` SET `numberUser`='%s', `dateDuties`='%s',`numberDuties`='%s' ,`isClose`='%s',`idDuties`='%d'  WHERE `idDuties`='%d'",
                    duties.getNumberUser(), duties.getDateDuties(), duties.getNumberDuties(), duties.getClose(),
                    duties.getIdDuties());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Duties duties) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `duties` WHERE `idDuties`='%s'",
                    duties.getIdDuties());
            return 1 == statement.executeUpdate(sql);
        }
    }

}
