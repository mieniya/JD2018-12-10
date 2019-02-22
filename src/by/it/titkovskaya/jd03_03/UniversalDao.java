package by.it.titkovskaya.jd03_03;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UniversalDao<TypeBean> {

    private Class<TypeBean> beanClass;
    private String table;
    private Field[] fields;

    public UniversalDao(Class<TypeBean> beanClass, String table) {
        this.beanClass = beanClass;
        this.table = table;
        this.fields = beanClass.getDeclaredFields();
    }

    public TypeBean read(long id) throws SQLException {
        List<TypeBean> beans = getAll(" WHERE `id`=" + id);
        return beans.size() == 1 ? beans.get(0) : null;
    }

    public boolean create(TypeBean bean) throws SQLException, IllegalAccessException {
        String sql = "INSERT INTO `" + table + "` (";
        String values = "";
        String delimiter = "";
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sql=sql.concat(delimiter + "`" + fields[i].getName() + "`");
            values=values.concat(delimiter + "'" + fields[i].get(bean) + "'");
            delimiter=",";
        }
        sql=sql + ") VALUES (" + values + ")";
        long id = executeCreate(sql);
        if (id > 0){
            fields[0].setAccessible(true);
            fields[0].set(bean,id);
        }
        return id > 0;
    }

    public boolean update(TypeBean bean) throws SQLException, IllegalAccessException {
        String sql = "UPDATE `" + table + "` SET ";
        String delimiter = "";
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sql=sql.concat(delimiter + "`" + fields[i].getName() + "`='" + fields[i].get(bean) + "'");
            delimiter=",";
        }
        sql=sql + " WHERE `id`='" + fields[0].get(bean) + "'";
        return executeUpdate(sql);
    }

    public boolean delete(TypeBean bean) throws SQLException, IllegalAccessException {
        String sql = "DELETE FROM `" + table + "` WHERE `id`=" + fields[0].get(bean) + "'";
        return executeUpdate(sql);
    }

    public List<TypeBean> getAll() throws SQLException {
        return getAll("");
    }

    public List<TypeBean> getAll(String where) throws SQLException {
        List<TypeBean> beans = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `users` " + where;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
/*                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setName(resultSet.getString("name"));
                user.setRoles_id(resultSet.getLong("roles_id"));
                users.add(user);
  */
            }
        }
        return beans;
    }

    private boolean executeUpdate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return 1 == statement.executeUpdate(sql);
        }
    }

    private long executeCreate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return 0;
    }
}
