package by.it.a_khmelev.jd03_02;

import by.it.a_khmelev.jd03_02.beans.Role;
import by.it.a_khmelev.jd03_02.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD = new UserCRUD();

        User user = new User(0, "TestUser", "TestEmail", "TestPassword", 2);
        if (userCRUD.create(user))
            System.out.println("CREATEGOODSFLOWER OK: " + user);
        user.setLogin("TestUserUpdate");
        if (userCRUD.update(user))
            System.out.println("UPDATE OK: " + user);
        user = userCRUD.read(user.getId());
        if (user != null)
            System.out.println("READ OK: " + user);
        if (userCRUD.delete(user))
            System.out.println("DELETE OK: " + user);

        RoleCRUD roleCRUD = new RoleCRUD();

        Role role = new Role(0, "TestRole");
        if (roleCRUD.create(role))
            System.out.println("CREATEGOODSFLOWER OK: " + role);
        role.setRole("TestRoleUpdate");
        if (roleCRUD.update(role))
            System.out.println("UPDATE OK: " + role);
        role = roleCRUD.read(role.getId());
        if (role != null)
            System.out.println("READ OK: " + role);
        if (roleCRUD.delete(role))
            System.out.println("DELETE OK: " + role);

        //TEST CASCADE
//                User user=userCRUD.read(3);
//                System.out.println(user);
//                userCRUD.delete(user);


    }
}
