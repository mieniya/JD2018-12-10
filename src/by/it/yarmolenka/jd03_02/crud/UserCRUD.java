package by.it.yarmolenka.jd03_02.crud;

import by.it.yarmolenka.jd03_02.ConnectionCreator;
import by.it.yarmolenka.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Locale;

public class UserCRUD {

    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,"INSERT INTO `users` (`login`, `email`, `password`, `cashier`, " +
                            "`fk_roles`) VALUES ('%s', '%s', '%s', '%f', '%d')", user.getLogin(),
                    user.getEmail(), user.getPassword(), user.getCashier(), user.getFk_roles());
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
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `users` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getDouble("cashier"),
                        resultSet.getLong("fk_roles")
                );
            }
        }
        return null;
    }

    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,"UPDATE `users` SET `login`='%s', `email`='%s', " +
                            "`password`='%s', `cashier`='%f', `fk_roles`='%d' WHERE `id`='%d'", user.getLogin(),
                    user.getEmail(), user.getPassword(), user.getCashier(), user.getFk_roles(), user.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }

    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `users` WHERE `id`='%d'", user.getId());
            return statement.executeUpdate(sql) == 1;
        }
    }

    public void showUsersWithRoles() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = "SELECT * FROM `users` INNER JOIN `roles` ON `users`.`fk_roles`=`roles`.`id`";
            ResultSet resultSet = statement.executeQuery(sql);
            long usersCount = 0;
            long rolesCount = 0;
            HashSet<String> set = new HashSet<>();
            while (resultSet.next()){
                System.out.println(resultSet.getString(2) + " - " +
                        resultSet.getString(8));
                usersCount++;
                if (set.add(resultSet.getString("role"))) rolesCount++;
            }
            System.out.println("Users: " + usersCount + "\nRoles: " + rolesCount);
        }
    }
}
