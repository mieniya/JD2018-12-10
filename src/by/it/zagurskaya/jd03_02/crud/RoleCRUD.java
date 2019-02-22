package by.it.zagurskaya.jd03_02.crud;


import by.it.zagurskaya.jd03_02.ConnCreator;
import by.it.zagurskaya.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD implements CRUD<Role> {

    public boolean create(Role role) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `roles`(`idRole`, `roleName`) VALUES ('%s','%s')",
                    role.getIdRole(), role.getRoleName());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setIdRole(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Role read(long idRole) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `roles` WHERE `idRole`='%d'",
                    idRole);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Role role = new Role();
                role.setIdRole(resultSet.getLong("idRole"));
                role.setRoleName(resultSet.getString("roleName"));
                return role;
            }
        }
        return null;
    }

    public boolean update(Role role) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    " UPDATE `roles` SET `roleName`='%s' WHERE `idRole`='%d'",
                    role.getRoleName(),
                    role.getIdRole());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Role role) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `roles` WHERE `idRole`='%d'",
                    role.getIdRole());
            return 1 == statement.executeUpdate(sql);
        }
    }

}
