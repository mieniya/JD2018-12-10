package by.it.naron.jd03_03.dao;


import by.it.naron.jd03_03.beans.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RolesDao extends AbstractDao implements InterfaceDao<Roles> {


    @Override
    public boolean create(Roles roles) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `roles`(`role`) " +
                        "VALUES ('%s')",
                roles.getRole());
        roles.setId(executeCreate(sql));
        return roles.getId() > 0;
    }

    @Override
    public boolean update(Roles roles) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "update naron.roles set role = '%s' where id='%d';\n",
                roles.getRole(),roles.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Roles roles) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `roles` WHERE `id`='%d'",
                roles.getId());
        return executeUpdate(sql);
    }

    @Override
    public Roles read(long id) throws SQLException {
        List<Roles> users = getAll(" WHERE id=" + id);
        return users.size() == 0 ? null : users.get(0);
    }

    @Override
    public List<Roles> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Roles> getAll(String where) throws SQLException {
        List<Roles> result = new ArrayList<>();
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "SELECT * FROM `roles` " + where);
          //  System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Roles roles = new Roles();
                roles.setId(resultSet.getLong("id"));
                roles.setRole(resultSet.getString("role"));
                result.add(roles);
                 }
        }
        return result;
    }
}