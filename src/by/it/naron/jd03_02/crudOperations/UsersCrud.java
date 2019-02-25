package by.it.naron.jd03_02.crudOperations;

import by.it.naron.jd03_02.beans.Users;
import by.it.naron.jd03_02.tools.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UsersCrud {


    public boolean create(Users users) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "INSERT INTO `users`(`login`, `e-mail`, `password`, `roles_id`) " +
                            "VALUES ('%s','%s','%s','%d')",
                    users.getLogin(), users.getEmail(), users.getPassword(), users.getRoles_id());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    users.setId(generatedKeys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }

   public Users read(long id) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "SELECT * FROM `users` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Users users = new Users();
                users.setId(resultSet.getLong("id"));
                users.setLogin(resultSet.getString("login"));
                users.setEmail(resultSet.getString("e-mail"));
                users.setPassword(resultSet.getString("password"));
                users.setRoles_id(resultSet.getLong("roles_id"));
                return users;
            }
        }
        return null;
    }

    public boolean update(Users users) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "UPDATE `users` " +
                            "SET `login`='%s',`e-mail`='%s',`password`='%s',`roles_id`='%d' " +
                            "WHERE `id`='%d'",
                    users.getLogin(), users.getEmail(), users.getPassword(), users.getRoles_id(),
                    users.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Users users) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "DELETE FROM `users` WHERE `id`='%d'",
                    users.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }














    //чтение
//    public Users read(long id) throws SQLException {
//        Users usersResult = null;
//        String readUsersSql = String.format(
//                "SELECT `id`, `login`, `password`, `e-mail`, `password`, `roles_id` FROM `users` WHERE id = %d", id);
//        try (Connection connection = Connect.getConnection();
//             Statement statement = connection.createStatement()
//        ) {
//            ResultSet resultSet = statement.executeQuery(readUsersSql);
//            if (resultSet.next()) {
//                usersResult = new Users(
//                        resultSet.getInt("id"),
//                        resultSet.getString("login"),
//                        resultSet.getString("password"),
//                        resultSet.getString("e-mail"),
//                        resultSet.getInt("roles_id"));
//                return usersResult;
//            } else
//                return null;
//        }
//    }
}
