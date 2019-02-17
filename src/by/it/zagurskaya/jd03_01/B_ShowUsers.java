package by.it.zagurskaya.jd03_01;

import java.sql.*;

public class B_ShowUsers {

    public void showUsers(Connection connection) throws SQLException {
        try ( Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT `users`.*,`roles`.roleName FROM `zagurskaya`.`users`,`zagurskaya`.`roles` WHERE `zagurskaya`.`users`.roleid = `zagurskaya`.`roles`.idRole;");
            System.out.printf("%-11s%-11s%-11s%-11s%-11s%n", "idUser", "login", "password", "roleId", "roleName");
            System.out.println("-----------------------------------------------------");

            while (resultSet.next()) {
                String outIdUser = resultSet.getString("idUser");
                String outLogin = resultSet.getString("login");
                String outPassword = resultSet.getString("password");
                String outRoleId = resultSet.getString("roleId");
                String outRoleName = resultSet.getString("roleName");
                System.out.printf("%-11s%-11s%-11s%-11s%-11s%n", outIdUser, outLogin, outPassword, outRoleId, outRoleName);

            }
        }
    }
}
