package by.it.skosirskiy.jd03_01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddData {
    public static void main(String[ ] args) {

        addDate();

    }

    private static void addDate() {
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `requests` (`type`,`date_create`,`date_complete`, `user_id`,`status_id`,`address_id`) " +
                    "VALUES ('no water','2019-02-02','2019-02-08',(SELECT id FROM `users` WHERE `login`='semen'), (SELECT id FROM `statuses` WHERE `status`='complete'),3)");
            statement.executeUpdate("INSERT INTO `requests` (`type`,`date_create`,`date_complete`, `user_id`,`status_id`,`address_id`) " +
                    "VALUES ('fix the door','2019-02-08','2019-02-28',(SELECT id FROM `users` WHERE `login`='semen'), (SELECT id FROM `statuses` WHERE `status`='in_work'),3)");
            statement.executeUpdate("INSERT INTO `requests` (`type`,`date_create`,`date_complete`, `user_id`,`status_id`,`address_id`) " +
                    "VALUES ('no internet','2019-04-08','2019-02-5',(SELECT id FROM `users` WHERE `login`='semen'), (SELECT id FROM `statuses` WHERE `status`='complete'),3)");
          }



        catch (Exception e){
            e.printStackTrace();
        }
    }
}
