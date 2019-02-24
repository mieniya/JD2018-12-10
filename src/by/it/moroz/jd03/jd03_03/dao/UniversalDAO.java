package by.it.moroz.jd03.jd03_03.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversalDAO<TypeBean> extends AbstractDAO implements InterfaceDAO<TypeBean> {

    private Class<TypeBean> aClass;
    private String table;
    private Field[] fields;

    UniversalDAO(Class<TypeBean> aClass, String table) {
        this.aClass = aClass;
        this.table = table;
        this.fields = aClass.getDeclaredFields();
    }

    @Override
    public TypeBean read(long id) throws SQLException {
        List<TypeBean> beans = getAll("WHERE `id`=" + id);
        return beans.size()==0?null:beans.get(0);
    }

    @Override
    public boolean create(TypeBean bean) throws SQLException {
        String sql = "INSERT INTO `" + table + "` (";
        String delim = "";
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sql = sql.concat(delim + "`" + fields[i].getName() + "`");
            delim = ", ";
        }
        sql = sql.concat(") VALUES (");
        delim = "";
        try {
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                sql = sql.concat(delim + "'" + fields[i].get(bean) + "'");
                delim = ", ";
            }
            sql = sql.concat(")");
            fields[0].set(bean, executeCreate(sql));
            return fields[0].getLong(bean) > 0;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(TypeBean bean) throws SQLException {
        String sql = "UPDATE `" + table + "` SET ";
        String delim = "";
        try {
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                sql = sql.concat(delim + "`" + fields[i].getName() + "`='" + fields[i].get(bean) + "'");
                delim = ", ";
            }
            fields[0].setAccessible(true);
            sql = sql.concat(" WHERE `" + fields[0].getName() + "`='" + fields[0].get(bean) + "'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(TypeBean bean) throws SQLException {
        String sql = "";
        try {
            sql = "DELETE FROM `" + table + "` WHERE `id`='" + fields[0].get(bean) + "'";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return executeUpdate(sql);
    }

    @Override
    public List<TypeBean> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<TypeBean> getAll(String WHERE) throws SQLException {
        List<TypeBean> beans = new ArrayList<>();
        String sql = String.format("SELECT * FROM `%s`" + WHERE, table, WHERE);
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            //ResultSet resultSet = executeQuery(sql); what is wrong????
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TypeBean bean = newBean();
                for (Field field : fields) {
                    field.setAccessible(true);
                    try {
                        if (field.getType() == Integer.class || field.getType() == int.class)
                            field.set(bean, resultSet.getInt(field.getName()));
                        if (field.getType() == Long.class || field.getType() == long.class)
                            field.set(bean, resultSet.getLong(field.getName()));
                        if (field.getType() == Float.class || field.getType() == float.class)
                            field.set(bean, resultSet.getFloat(field.getName()));
                        if (field.getType() == Double.class || field.getType() == double.class)
                            field.set(bean, resultSet.getDouble(field.getName()));
                        if (field.getType() == BigDecimal.class)
                            field.set(bean, resultSet.getBigDecimal(field.getName()));
                        if (field.getType() == Boolean.class || field.getType() == boolean.class)
                            field.set(bean, resultSet.getBoolean(field.getName()));
                        if (field.getType() == String.class)
                            field.set(bean, resultSet.getString(field.getName()));
                        if (field.getType() == Byte.class || field.getType() == byte.class)
                            field.set(bean, resultSet.getBytes(field.getName()));
                        if (field.getType() == Date.class)
                            field.set(bean, resultSet.getDate(field.getName()));
                        if (field.getType() == Time.class)
                            field.set(bean, resultSet.getTime(field.getName()));
                        if (field.getType() == Timestamp.class)
                            field.set(bean, resultSet.getTimestamp(field.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beans.add(bean);
            }
        }
        return beans;
    }

    private TypeBean newBean() {
        try {
            return aClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
