package by.it.naron.jd03_02.testPackage;

import by.it.naron.jd03_02.beans.Roles;
import by.it.naron.jd03_02.crudOperations.RolesCrud;

import java.sql.SQLException;

public class RolesTest {
    public static void main(String[] args) throws SQLException {


//проверка BeanCRUD для пользователей

         RolesCrud rolesCrud = new RolesCrud();
        Roles roles = new Roles(0, "TestRole");

        if (rolesCrud.create(roles))
            System.out.println("CREATE OK: " + roles);
        roles.setRole("TestRoleUpdate");
        if (rolesCrud.update(roles))
            System.out.println("UPDATE OK: " + roles);
        roles = rolesCrud.read(roles.getId());
        if (roles != null)
            System.out.println("READ OK: " + roles);
        if (rolesCrud.delete(roles))
            System.out.println("DELETE OK: " + roles);

        //TEST CASCADE
        //        User user=userCRUD.read(3);
        //        System.out.println(user);
        //        userCRUD.delete(user);


    }


























    }






