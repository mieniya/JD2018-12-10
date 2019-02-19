package by.it.skosirskiy.jd03_01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddUser {
    public static void main(String[ ] args) {

        addUsers();

    }

    private static void addUsers() {
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            //вставляем пользователей


           statement.executeUpdate("INSERT INTO `users` (`login`, `password`, `email`, `roles_id`) VALUES ('semen', 'semen','semen@mail.ru', (SELECT id FROM `roles` WHERE `role`='user'));");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
