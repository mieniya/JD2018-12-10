package by.it.subach.jd03_03;

import by.it.subach.jd03_03.beans.User;
import by.it.subach.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        C_Init.initDB();
        DAO dao = DAO.getInstance();
        User user = new User();
        user.setRole_id(1);
        if(dao.user.create(user)){
            System.out.println("Create OK " + user);
        }
        user.setLogin("TestLogin");
        if(dao.user.update(user)){
            System.out.println("Update OK " + user);
        }
        user = dao.user.read(user.getId());
        System.out.println(user);
        if(user != null){
            System.out.println("Read OK " + user);
        }
        if(dao.user.delete(user)){
            System.out.println("Delete OK " + user);
        }



    }
}
