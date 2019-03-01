package by.it.medvedeva.jd03_03.dao;

import by.it.medvedeva.jd03_03.beans.Ad;
import by.it.medvedeva.jd03_03.beans.Role;
import by.it.medvedeva.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;


public class Dao {

    private static volatile Dao dao;

    public InterfaceDao<User> user;
    public InterfaceDao<Role> role;
    public InterfaceDao<Ad> ad;


    public void reset(){
        Connect.reset();
    }
    private Dao() {
        role=new UniversalDAO<>(new Role(),"roles");
        user=new UniversalDAO<>(new User(),"users");
        ad=new UniversalDAO<>(new Ad(),"ads");



    }

    public static Dao getDao(){



        if (dao==null){
            synchronized (Dao.class){
                if (dao==null) {
                    dao=new Dao();
                }
            }
        }
        return dao;
    }

static boolean executeUpdate (String sql) throws SQLException {

    try (Connection connection = by.it.medvedeva.jd03_02.crud.Connect.getConnection();

         Statement statement = connection.createStatement()) {
        return (1 == statement.executeUpdate(sql));
    }
}




}
