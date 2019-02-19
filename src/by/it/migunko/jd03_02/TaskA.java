package by.it.migunko.jd03_02;
import by.it.migunko.jd03_02.beans.Users;
import by.it.migunko.jd03_02.crud.UserCRUD;

import java.sql.SQLException;
public class TaskA {
    public static void main(String[] args) throws SQLException {
        UserCRUD crud = new UserCRUD();
        Users testUser = new Users(
                0,
                "TestLogin",
                "TestPassword",
                "TestEmail",
                3);
        if (crud.create(testUser))
            System.out.println("Create "+testUser);
        testUser=crud.read(testUser.getId());
        if (testUser!=null)
            System.out.println("Read "+testUser);
        testUser.setEmail("TestEmail");
        if (crud.update(testUser))
            System.out.println("Update "+testUser);
        if (crud.delete(testUser))
            System.out.println("Delete "+testUser);
    }
}
