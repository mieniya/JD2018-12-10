package by.it.migunko.jd03_03;
import by.it.migunko.jd03_03.beans.Roles;
import by.it.migunko.jd03_03.beans.Users;
import by.it.migunko.jd03_03.beans.Tours;
import by.it.migunko.jd03_03.dao.Dao;
import java.sql.SQLException;


public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        Roles role=new Roles(0,"Test");
        dao.role.create(role);
        role.setRole("ChangedRole");
        dao.role.update(role);
        dao.role.delete(role);
        System.out.println(role);

        Users user=new Users(
                0,
                "test_login",
                "test_pass",
                "test_email",
                2);
        dao.user.create(user);
        user.setLogin("ChangedLogin");
        user.setPassword("ChangedPassword");
        user.setEmail("ChangedEmail");
        dao.user.update(user);
        dao.user.delete(user);
        System.out.println(user);
    }
}

