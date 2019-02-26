package by.it.lyakhova.jd03_02.crud;
import by.it.lyakhova.jd03_02.bean.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoleCRUD {

    public boolean create(Role role) throws SQLException {
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = String.format("INSERT INTO roles (role, description) "+
                    "VALUES ('%s', '%s',)", role.getRole(), role.getDescription());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (count==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    role.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Role read(long id) throws SQLException {
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = String.format("SELECT * FROM roles WHERE id=`%d`", id);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                Role role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setRole(resultSet.getString("role"));
                role.setDescription(resultSet.getString("description"));
                return role;
            }
        }
        return null;
    }

    public boolean update(Role role) throws SQLException {
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = String.format("UPDATE roles SET role = '%s', description = '%s' WHERE id = '%d'",
                    role.getRole(), role.getDescription(), role.getId());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (count==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    role.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(Role role) throws SQLException {
        try(Connection connection = ConnCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = String.format("DELETE FROM roles WHERE id = '%d'", role.getId());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (count==1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    role.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }
}
