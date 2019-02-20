package by.it.subach.jd03_03;

import java.util.List;

public interface InterfaceDAO<TypeBean> {

    public TypeBean read(Long id);
    public boolean create(TypeBean bean);
    public boolean update(TypeBean bean);
    public boolean delete(TypeBean bean);
    public List<TypeBean> getAll();
    public List<TypeBean> getAll(String where);

}
