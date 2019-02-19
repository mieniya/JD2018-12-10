package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.beans.Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class AdminCRUD {

    boolean create(Admin admin) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO `admins` (`login`, `email`, `password`) " +
                    "VALUES ('%s', '%s', '%s')", admin.getLogin(), admin.getEmail(), admin.getPassword());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    admin.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Admin read(long id) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `admins` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getLong("id"));
                admin.setLogin(resultSet.getString("login"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                return admin;
            }
        }
        return null;
    }

    boolean update(Admin admin) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `admins` SET `login`='%s', `email`='%s', `password`='%s' " +
                    "WHERE `id`='%d'", admin.getLogin(), admin.getEmail(), admin.getPassword(), admin.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }

    boolean delete(Admin admin) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `admins` WHERE `id`='%d'", admin.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }
}
