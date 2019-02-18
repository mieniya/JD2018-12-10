package by.it.yarmolenka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void addBets() {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_PACKAGE, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `yarmolenka`.`bets` (`id`, `sport`, `event`, `actual_bet`, " +
                    "`odds`, `actual_result`, `bet_amount`, `payout`, `fk_gamblers`) " +
                    "VALUES (DEFAULT, 'soccer','match1','W1' ,2.4,'X',100,0,2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`bets` (`id`, `sport`, `event`, `actual_bet`, " +
                    "`odds`, `actual_result`, `bet_amount`, `payout`, `fk_gamblers`) " +
                    "VALUES (DEFAULT, 'soccer','match2','W2' ,2.1,'W2',100,210,2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`bets` (`id`, `sport`, `event`, `actual_bet`, " +
                    "`odds`, `actual_result`, `bet_amount`, `payout`, `fk_gamblers`) " +
                    "VALUES (DEFAULT, 'hockey','match3','W1' ,3.7,'W1',100,370,3);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
