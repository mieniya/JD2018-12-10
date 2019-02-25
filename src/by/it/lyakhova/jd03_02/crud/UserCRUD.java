package by.it.lyakhova.jd03_02.crud;
import by.it.lyakhova.jd03_02.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO users (login, password, email, contacts, roles_id) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%d')", user.getLogin(), user.getEmail(), user.getPassword(), user.getContacts(), user.getRoles_id());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public User read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT*FROM users WHERE id = '%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setContacts(resultSet.getString("contacts"));
                user.setRoles_id(resultSet.getLong("roles_id"));

                return user;
            }
        }
        return null;
    }

    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE users SET login = '%s', password = '%s', email = '%s'," +
                            " contacts = '%s', roles_id = '%d' WHERE id = '%d'",
                    user.getLogin(), user.getPassword(), user.getEmail(),
                    user.getContacts(), user.getRoles_id(), user.getId());

            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM users WHERE id = '%d'", user.getId());

            return 1 == statement.executeUpdate(sql);
        }
    }
}
