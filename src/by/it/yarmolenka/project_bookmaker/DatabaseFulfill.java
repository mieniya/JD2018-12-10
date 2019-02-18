package by.it.yarmolenka.project_bookmaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseFulfill {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void fulfill() {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_ROOT, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `email`, `password`) " +
                    "VALUES (DEFAULT, 'gambler1', 'gambler1@mail.ru', 'gambler1pass');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `email`, `password`) " +
                    "VALUES (DEFAULT, 'gambler2', 'gambler2@mail.ru', 'gambler2pass');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`sports` (`id`, `sport`) VALUES (DEFAULT, 'soccer');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`sports` (`id`, `sport`) VALUES (DEFAULT, 'hockey');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`match_status` (`id`, `finished`) VALUES (DEFAULT, true);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`match_status` (`id`, `finished`) VALUES (DEFAULT, false);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`admins` (`id`, `login`, `email`, `password`) " +
                    "VALUES (DEFAULT, 'admin1', 'admin1@mail.ru', 'admin1pass');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`admins` (`id`, `login`, `email`, `password`) " +
                    "VALUES (DEFAULT, 'admin2', 'admin2@mail.ru', 'admin2pass');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`matches` (`id`, `date`, `discription`, `result`, " +
                    "`fk_sports`, `fk_match_status`, `fk_admins`) VALUES (DEFAULT, '2019-11-11 11:11:11', 'BATE - Dinamo', NULL, 1, 2, 1);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`matches` (`id`, `date`, `discription`, `result`, `fk_sports`, " +
                    "`fk_match_status`, `fk_admins`) VALUES (DEFAULT, '2019-11-11 11:11:11', 'SKA - CSKA', NULL, 2, 2, 2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, " +
                    "`fk_admins`) VALUES (DEFAULT, 'W1', 2.2, 1, 1);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, " +
                    "`fk_admins`) VALUES (DEFAULT, 'X', 2.8, 1, 1);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, " +
                    "`fk_admins`) VALUES (DEFAULT, 'W2', 3.6, 1, 1);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, " +
                    "`fk_admins`) VALUES (DEFAULT, 'W1', 2.4, 2, 2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, " +
                    "`fk_admins`) VALUES (DEFAULT, 'X', 4.0, 2, 2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, " +
                    "`fk_admins`) VALUES (DEFAULT, 'W2', 1.8, 2, 2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`cashiers` (`id`, `overall`, `available`, `in_bets`, " +
                    "`fk_gamblers`, `fk_admins`) VALUES (DEFAULT, 1000, 900, 100, 1, 1);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`cashiers` (`id`, `overall`, `available`, `in_bets`, " +
                    "`fk_gamblers`, `fk_admins`) VALUES (DEFAULT, 2000, 1800, 200, 2, 2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`bets` (`id`, `amount`, `payout`, `fk_events`, " +
                    "`fk_gamblers`, `fk_cashiers`) VALUES (DEFAULT, 100, NULL, 1, 1, 1);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`bets` (`id`, `amount`, `payout`, `fk_events`, " +
                    "`fk_gamblers`, `fk_cashiers`) VALUES (DEFAULT, 200, NULL, 4, 2, 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
