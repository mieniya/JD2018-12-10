package by.it.moroz.jd03.jd03_02;

import by.it.moroz.jd03.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class UserCRUD {

    boolean createUser(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String create = String.format(
                    "INSERT INTO `users`(`login`,`password`,`email`,`address`,`name`,`surname`,`numberphone`,`roles_id`) " +
                            "VALUES ('%s','%s','%s','%s','%s','%s','%d','%d')",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getAddress(), user.getName(),
                    user.getSurname(), user.getNumberphone(), user.getRoles_id());
            int i = statement.executeUpdate(create, Statement.RETURN_GENERATED_KEYS);
            if (i == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    User readUser(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String read = String.format("SELECT * FROM `users` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(read);
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setNumberphone(resultSet.getInt("numberphone"));
                user.setRoles_id(resultSet.getLong("roles_id"));
                return user;
            }
        }
        return null;
    }

    boolean updateUser(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String update = String.format("UPDATE `users` SET `login`='%s',`password`='%s',`email`='%s'," +
                            "`address`='%s',`name`='%s',`surname`='%s',`numberphone`='%d',`roles_id`='%d' WHERE `id`='%d'",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getAddress(), user.getName(),
                    user.getSurname(), user.getNumberphone(), user.getRoles_id(), user.getId());
            return 1==statement.executeUpdate(update);
        }
    }

    boolean deleteUser(User user) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String delete = String.format("DELETE FROM `users` WHERE `id`='%d'", user.getId());
            return 1==statement.executeUpdate(delete);
        }
    }

}
