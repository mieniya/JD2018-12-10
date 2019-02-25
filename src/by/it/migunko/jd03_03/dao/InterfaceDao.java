package by.it.migunko.jd03_03.dao;
import java.sql.SQLException;
import java.util.List;
public interface InterfaceDao<Bean> {
    boolean create(Bean been) throws SQLException;
    Bean read(long id) throws SQLException;
    boolean update(Bean been) throws SQLException;
    boolean delete(Bean been) throws SQLException;
    List<Bean> getAll(String whereAndOrder) throws SQLException;
}
