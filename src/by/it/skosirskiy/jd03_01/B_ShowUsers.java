package by.it.skosirskiy.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class B_ShowUsers {


    void showUsers() {
        try (
                Connection connection=
                        DriverManager.getConnection
                                (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                Statement statement=connection.createStatement()) {
            //вставляем пользователей


            ResultSet resultSet = statement.executeQuery("SELECT `users`.*,`roles`.role FROM `users`,`roles` WHERE `users`.roles_id = `roles`.id;");
            System.out.printf("%-11s%-11s%-11s%-11s%-11s%n", "id", "login", "password", "roles_id", "role");
            System.out.println("-----------------------------------------------------");

            while (resultSet.next()) {
                String outIdUser = resultSet.getString("id");
                String outLogin = resultSet.getString("login");
                String outPassword = resultSet.getString("password");
                String outRoleId = resultSet.getString("roles_id");
                String outRoleName = resultSet.getString("role");
                System.out.printf("%-11s%-11s%-11s%-11s%-11s%n", outIdUser, outLogin, outPassword, outRoleId, outRoleName);

            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
