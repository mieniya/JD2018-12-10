package by.it.zagurskaya.jd03_02.crud;

import by.it.zagurskaya.jd03_02.ConnCreator;
import by.it.zagurskaya.jd03_02.beans.Role;
import by.it.zagurskaya.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD implements CRUD<User> {

    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `users`(`login`, `password`, `roleId`)" +
                            "VALUES ('%s','%s','%d')",
                    user.getLogin(), user.getPassword(), user.getRoleId());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setIdUser(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public User read(long idUser) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `users` WHERE `idUser`='%d'",
                    idUser);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getLong("idUser"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleId(resultSet.getLong("roleId"));
                return user;
            }
        }
        return null;
    }

    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `users` SET `login`='%s', `password`='%s',`roleId`='%d' WHERE `idUser`='%d'",
                    user.getLogin(),  user.getPassword(), user.getRoleId(),
                    user.getIdUser());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `users` WHERE `idUser`='%s'",
                    user.getIdUser());
            return 1 == statement.executeUpdate(sql);
        }
    }

}
