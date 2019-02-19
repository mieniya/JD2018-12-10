package by.it.zagurskaya.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        ConnectionSource connectionSource = new ConnectionSource();

        try (Connection connection = connectionSource.getConnection()) {
            try {
                new C_Reset().reset(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            new C_Init().init(connection);
            try {
                new A_AddUser().addUser(connection);
                new A_AddData().addData(connection);
                new B_AddRoles().addRole(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            new B_ShowUsers().showUsers(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
