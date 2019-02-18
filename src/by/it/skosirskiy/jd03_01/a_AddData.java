package by.it.skosirskiy.jd03_01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class a_AddData {
    public static void main(String[ ] args) {

        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            //вставляем пользователей


            statement.executeUpdate("INSERT INTO `skosirskiy`.`users` (`id_user`, `login`, `password`, `email`, `roles_id_role`) VALUES (DEFAULT, 'guest12', 'ascxxzasdc', 'guest12@mail.ru', 1)");
//            statement.executeUpdate("INSERT INTO `skosirskiy`.`status` (`id`, `status`) VALUES (1, 'canceled');");
//            statement.executeUpdate("INSERT INTO `skosirskiy`.`status` (`id`, `status`) VALUES (2, 'complete');");
//            statement.executeUpdate("NSERT INTO `skosirskiy`.`status` (`id`, `status`) VALUES (3, 'in_work');");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
