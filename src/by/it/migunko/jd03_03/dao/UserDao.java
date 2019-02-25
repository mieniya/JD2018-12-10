package by.it.migunko.jd03_03.dao;
import by.it.migunko.jd03_02.connection.ConnCreator;
import by.it.migunko.jd03_03.beans.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao implements InterfaceDao<Users> {
    @Override
    public boolean create(Users users) throws SQLException {
        String sql = String.format("INSERT INTO `users`(`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s',%d)",
                users.getLogin(), users.getPassword(), users.getEmail(), users.getRoles_id());
        long id = executeUpdate(sql);
        if (id > 0) {
            users.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public Users read(long id) throws SQLException {
        List<Users> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean update(Users users) throws SQLException {
        String sql = String.format("UPDATE `users` " +
                        "SET `login`='%s', `password`='%s',`email`='%s'," +
                        "`roles_id`=%d WHERE id=%d",
                users.getLogin(), users.getPassword(), users.getEmail(), users.getRoles_id(), users.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Users users) throws SQLException {
        String sql = String.format("DELETE FROM `users` WHERE id=%d", users.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Users> getAll(String where) throws SQLException {
        List<Users> users = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format("SELECT * FROM `users` "+ where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Users user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")
                );
                users.add(user);
            }
        }
        return users;
    }
}
