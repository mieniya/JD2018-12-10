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
            statement.executeUpdate("INSERT INTO `yarmolenka`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`roles` (`id`, `role`) VALUES (DEFAULT, 'gambler')");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`users` (`id`, `login`, `email`, `password`, `cashier`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'admin', 'admin@mail.ru', 'adminpassword', NULL, 1)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`users` (`id`, `login`, `email`, `password`, `cashier`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'gambler1', 'gambler1@mail.ru', 'gambler1password', 1000, 2)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`users` (`id`, `login`, `email`, `password`, `cashier`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'gambler2', 'gambler2@mail.ru', 'gambler2password', 2000, 2)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`races` (`id`, `date`, `race_track`, `description`) " +
                    "VALUES (DEFAULT, '2019-03-03 19:00:00', 'Minsk race track', 'Minsk city race')");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`races` (`id`, `date`, `race_track`, `description`) " +
                    "VALUES (DEFAULT, '2019-03-04 19:00:00', 'Brest race track', 'Big race')");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `description`, `odds`, `fk_races`) " +
                    "VALUES (DEFAULT, 'Horse #1 wins', 7, 1)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `description`, `odds`, `fk_races`) " +
                    "VALUES (DEFAULT, 'Horse #2 wins', 15, 1)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `description`, `odds`, `fk_races`) " +
                    "VALUES (DEFAULT, 'Horse #1 wins', 5, 2)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`events` (`id`, `description`, `odds`, `fk_races`) " +
                    "VALUES (DEFAULT, 'Horse #2 wins', 9, 2)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`bets` (`id`, `amount`, `payout`, `fk_users`, `fk_events`) " +
                    "VALUES (DEFAULT, 100, NULL, 2, 1)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`bets` (`id`, `amount`, `payout`, `fk_users`, `fk_events`) " +
                    "VALUES (DEFAULT, 100, NULL, 3, 3)");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`bets` (`id`, `amount`, `payout`, `fk_users`, `fk_events`) " +
                    "VALUES (DEFAULT, 100, NULL, 2, 2)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
