package by.it.migunko.jd03_02.crud;

import by.it.migunko.jd03_02.beans.Users;
import by.it.migunko.jd03_02.connection.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {
     public   boolean create(Users users) throws SQLException {
            try (Connection connection = ConnCreator.getConnection();
                 Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO " +
                            "`users`(`login`, `password`, `email`, `roles_id`) " +
                            "VALUES ('%s','%s','%s',%d)",
                    users.getLogin(), users.getPassword(), users.getEmail(), users.getRoles_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    users.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Users read(long id) throws SQLException {
        Users users = null;
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                            "SELECT `id`, `login`, `password`, `email`, `roles_id` FROM `users` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                users = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")
                );
            }
        }
        return users;
    }

    public boolean update(Users users) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `users` " +
                            "SET `login`='%s', `password`='%s',`email`='%s'," +
                            "`roles_id`=%d WHERE id=%d",
                    users.getLogin(), users.getPassword(), users.getEmail(), users.getRoles_id(), users.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Users users) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `users` WHERE id=%d",
                    users.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
