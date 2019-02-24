package by.it.naron.jd03_02.testPackage;

import by.it.naron.jd03_02.beans.Users;
import by.it.naron.jd03_02.crudOperations.UsersCrud;

import java.sql.SQLException;

public class UsersTest {

    public static void main(String[] args) throws SQLException {

        UsersCrud usersCRUD = new UsersCrud();
        Users user = new Users(0, "TestUser", "TestEmail", "TestPassword", 2);
        if (usersCRUD.create(user))
            System.out.println("CREATE OK: " + user);
        user.setLogin("TestUserUpdate");
        if (usersCRUD.update(user))
            System.out.println("UPDATE OK: " + user);
        user = usersCRUD.read(user.getId());
        if (user != null)
            System.out.println("READ OK: " + user);
        if (usersCRUD.delete(user))
            System.out.println("DELETE OK: " + user);

      //  TEST CASCADE
//                Users users=usersCRUD.read(15);
//                System.out.println(users);
//                usersCRUD.delete(users);


    }

}
