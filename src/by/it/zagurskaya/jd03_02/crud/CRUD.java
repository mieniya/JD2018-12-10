package by.it.zagurskaya.jd03_02.crud;

import java.sql.SQLException;

public interface CRUD<T> {

    boolean create(T t) throws SQLException;

    T read(long id) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean delete(T t) throws SQLException;

}
