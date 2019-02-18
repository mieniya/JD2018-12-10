package by.it.skosirskiy.jd03_01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddUser {
    public static void main(String[ ] args) {

        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            //вставляем пользователей


            statement.executeUpdate("INSERT INTO `skosirskiy`.`users` (`id_user`, `login`, `password`, `email`, `roles_id_role`) VALUES (DEFAULT, 'guest2', 'ascxxzc', 'guest2@mail.ru', 1)");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
