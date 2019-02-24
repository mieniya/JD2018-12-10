package by.it.naron.jd03_03.dao;
import by.it.naron.jd03_03.beans.*;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsersDao extends AbstractDao implements InterfaceDao<Users> {
    @Override
    public boolean create(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `users`(`login`, `e-mail`, `password`, `roles_id`) " +
                        "VALUES ('%s','%s','%s','%d')",
                users.getLogin(), users.getEmail(), users.getPassword(), users.getRoles_id());
        users.setId(executeCreate(sql));
        return users.getId() > 0;
    }


    @Override
    public boolean update(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` " +
                        "SET `login`='%s',`e-mail`='%s',`password`='%s',`roles_id`='%d' " +
                        "WHERE `id`='%d'",
                users.getLogin(), users.getEmail(), users.getPassword(), users.getRoles_id(),
                users.getId());
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `users` WHERE `id`='%d'",
                users.getId());
        return executeUpdate(sql);
    }

    @Override
    public Users read(long id) throws SQLException {
//////////////////////////////////////////////////////////////////////////////////////
        List<Users> users = getAll("  WHERE id=" + id);
//////////////////////////////////////////////////////////////////////////////////////
        return users.size() == 0 ? null : users.get(0);
    }

    @Override
    public List<Users> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Users> getAll(String where) throws SQLException {
        List<Users> result = new ArrayList<>();
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(Locale.ENGLISH,
                    "SELECT * FROM `users` " + where);
//            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("e-mail"));
                user.setPassword(resultSet.getString("password"));
                user.setRoles_id(resultSet.getLong("roles_id"));
                result.add(user);
            }
        }
        return result;
    }

}