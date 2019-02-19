package by.it.naron.jd03_02.crudOperations;

import by.it.naron.jd03_02.beans.Roles;
import by.it.naron.jd03_02.tools.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RolesCrud {
    /////////////////////////////////////////////////////////////////////////////
    public boolean create(Roles roles) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO `roles`(`role`) VALUES ('%s')",
                    roles.getRole());
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    roles.setId(generatedKeys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////

    public Roles read(int id) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT * FROM `roles` WHERE `id`='%d'",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Roles role = new Roles();
                role.setId(resultSet.getInt("id"));
                role.setRole(resultSet.getString("role"));
                return role;
            }
        }
        return null;
    }


//    public Roles read(int id) throws SQLException {
//        Roles rolesResult = null;
//        String readRolesSql = String.format("SELECT `id`, `role` FROM `roles` WHERE id = %d", id);
//        try (Connection connection = Connect.getConnection();
//             Statement statement = connection.createStatement()
//        ) {
//            ResultSet resultSet = statement.executeQuery(readRolesSql);
//            if (resultSet.next()) {
//                //               return new Roles(resultSet.getLong("id"),resultSet.getString("role"));
//                rolesResult = new Roles(
//                        resultSet.getInt("id"),
//                        resultSet.getString("role")
//                );
//                return rolesResult;
//            }
//        }
//        return null;
//    }

    /////////////////////////////////////////////////////////////////////////////
    public boolean update(Roles roles) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `roles` SET `role`='%s' " +
                            "WHERE `id`='%d'",
                    roles.getRole(),
                    roles.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }

/////////////////////////////////////////////////////////////////////////////


    public boolean delete(Roles roles) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `roles` WHERE `id`='%d'",
                    roles.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }


}
