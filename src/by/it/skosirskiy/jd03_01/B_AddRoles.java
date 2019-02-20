package by.it.skosirskiy.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class B_AddRoles {


    void AddRoles() {
        try (
                Connection connection=
                        DriverManager.getConnection
                                (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                Statement statement=connection.createStatement()) {
            //вставляем пользователей


            statement.executeUpdate("INSERT INTO `roles` (`role`) VALUES ('dispatcher')");
           statement.executeUpdate("INSERT INTO `roles` (`role`) VALUES ('worker')");
            statement.executeUpdate("INSERT INTO `roles` (`role`) VALUES ('brigadier')");


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
