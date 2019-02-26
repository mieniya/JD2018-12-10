package by.it.lyakhova.jd03_02;

import by.it.lyakhova.jd03_02.bean.User;
import by.it.lyakhova.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD = new UserCRUD();
        User user = new User(0, "TestUser", "TestPassword", "TestEmail", "TestContacts", 2);

        if (userCRUD.create(user)) System.out.println("Create ok " + user);
        user.setLogin("TestUserUpdate");

        if (userCRUD.update(user)) System.out.println("update ok " + user);
        user = userCRUD.read(user.getId());

        if(user!=null) System.out.println("read ok " + user);
//user = userCRUD.read(4);
        if (userCRUD.delete(user)) System.out.println("delete ok " + user);
    }
}
