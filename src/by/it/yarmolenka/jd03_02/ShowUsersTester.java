package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class ShowUsersTester {
    public static void main(String[] args) throws SQLException {
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.showUsersWithRoles();
    }
}
