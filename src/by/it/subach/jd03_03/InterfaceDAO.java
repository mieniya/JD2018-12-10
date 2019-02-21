package by.it.subach.jd03_03;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<TypeBean> {

    public TypeBean read(Long id);
    public boolean create(TypeBean bean) throws SQLException;
    public boolean update(TypeBean bean) throws SQLException;
    public boolean delete(TypeBean bean) throws SQLException;
    public List<TypeBean> getAll();
    public List<TypeBean> getAll(String where) throws SQLException;

}
