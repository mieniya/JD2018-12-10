package by.it.naron.jd03_03.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<TypeBean>{
    public boolean create(TypeBean bean) throws SQLException;
    TypeBean read(long id) throws SQLException;
    public boolean update(TypeBean bean) throws SQLException;
    boolean delete(TypeBean bean) throws SQLException;

    public List<TypeBean> getAll() throws SQLException;

    public List<TypeBean> getAll(String where) throws SQLException;


}
