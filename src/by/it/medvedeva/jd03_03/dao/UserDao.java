package by.it.medvedeva.jd03_03.dao;

import by.it.medvedeva.jd03_03.beans.User;
import by.it.medvedeva.jd03_03.dao.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDao implements InterfaceDao<User> {

    public boolean create(User user) throws SQLException {
        String sql = String.format(
                "INSERT INTO `users` (`id`,`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s', '%s', '%s', '%d')",
                user.getFk_roles(), user.getLogin(), user.getEmail(),user.getPassword()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    user.setFk_roles(id);

                    return true;
                }
            }
            return false;
        }
    }
    public boolean delete(User user) throws SQLException {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`id` = %d",
                user.getId()
        );
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    @Override
    public User read(long id) throws SQLException {
        return null;
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(
                "UPDATE `users` SET " +
                        "`login` = '%s', `password` = '%s', " +
                        "`email` = '%s',  `roles_id` = '%d' " +
                        "WHERE id = %d",
                                user.getLogin(), user.getPassword(), user.getEmail(),user.getFk_roles(),user.getId()
        );
        return Dao.executeUpdate(sql);
    }

   public User read(User user) throws SQLException {
        User result=null;
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {


            String sql = String.format("SELECT `id`, `login`, `password`, `email`, `roles_id` " +
                    "FROM `users` WHERE id=%d", user.getId());
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                //id ok
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                int roles_id = resultSet.getInt("roles_id");

            };
        }
                return result;
        }

    @Override
    public List<by.it.medvedeva.jd03_03.beans.User> getAll(String sqlSuffix) throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }
}





