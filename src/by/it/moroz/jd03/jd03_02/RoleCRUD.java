package by.it.moroz.jd03.jd03_02;

import by.it.moroz.jd03.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class RoleCRUD {

    boolean createRole(Role role) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String create = String.format(
                    "INSERT INTO `roles`(`role`) VALUES ('%s')",
                    role.getRole());
            int i = statement.executeUpdate(create, Statement.RETURN_GENERATED_KEYS);
            if (i == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    Role readRole(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String read = String.format("SELECT * FROM `roles` WHERE `id`='%d'", id);
            ResultSet resultSet = statement.executeQuery(read);
            if (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setRole(resultSet.getString("role"));
                return role;
            }
        }
        return null;
    }

    boolean updateRole(Role role) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String update = String.format("UPDATE `roles` SET `role`='%s' WHERE `id`='%d'",
                    role.getRole(), role.getId());
            return 1==statement.executeUpdate(update);
        }
    }

    boolean deleteRole(Role role) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String delete = String.format("DELETE FROM `roles` WHERE `id`='%d'", role.getId());
            return 1==statement.executeUpdate(delete);
        }
    }
}
