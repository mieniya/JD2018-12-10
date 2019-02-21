package by.it.zagurskaya.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

            ResultSet resultSetCountUsers = statement.executeQuery("SELECT COUNT(*) FROM `zagurskaya`.`users`,`zagurskaya`.`roles` WHERE `zagurskaya`.`users`.roleid = `zagurskaya`.`roles`.idRole;");
            System.out.printf("\ncountUsers = ");

            while (resultSetCountUsers.next()) {
                String outCount = resultSetCountUsers.getString("COUNT(*)");
                System.out.printf(outCount+"\n\n");
            }

            ResultSet resultSetCountRoles = statement.executeQuery("SELECT `zagurskaya`.`roles`.roleName, COUNT(*) FROM `zagurskaya`.`users`,`zagurskaya`.`roles` WHERE `zagurskaya`.`users`.roleid = `zagurskaya`.`roles`.idRole GROUP BY `zagurskaya`.`roles`.roleName;");
            System.out.printf("%-13s%-13s%n", "roleName", "COUNT(*)");
            System.out.println("-------------------");

            while (resultSetCountRoles.next()) {
                String outCountRoleName = resultSetCountRoles.getString("roleName");
                String outCountRoles = resultSetCountRoles.getString("COUNT(*)");
                System.out.printf("%-13s%-13s%n", outCountRoleName, outCountRoles);
            }
        }
    }
}
