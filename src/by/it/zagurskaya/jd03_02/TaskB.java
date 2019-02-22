package by.it.zagurskaya.jd03_02;

import by.it.zagurskaya.jd03_02.B_ShowUsers;

import java.sql.Connection;
import java.sql.SQLException;

public class TaskB {
    public static void main(String[] args) {
        try (Connection connection = ConnCreator.getConnection()) {
            new B_ShowUsers().showUsers(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
