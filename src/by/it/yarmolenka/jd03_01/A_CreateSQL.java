package by.it.yarmolenka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_CreateSQL {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void createSQL() {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_PACKAGE, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {statement.executeUpdate(
                "CREATE SCHEMA IF NOT EXISTS `yarmolenka` "
        );
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`roles` (" +
                    "  `id` INT NOT NULL AUTO_INCREMENT," +
                    "  `role` VARCHAR(100) NULL," +
                    "  PRIMARY KEY (`id`))" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`gamblers` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NOT NULL,\n" +
                    "  `password` VARCHAR(100) NOT NULL,\n" +
                    "  `email` VARCHAR(100) NOT NULL,\n" +
                    "  `fk_roles` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_gamblers_roles1_idx` (`fk_roles` ASC),\n" +
                    "  CONSTRAINT `fk_gamblers_roles1`\n" +
                    "    FOREIGN KEY (`fk_roles`)\n" +
                    "    REFERENCES `yarmolenka`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`bets` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `sport` VARCHAR(100) NOT NULL,\n" +
                    "  `event` VARCHAR(100) NOT NULL,\n" +
                    "  `actual_bet` VARCHAR(100) NOT NULL,\n" +
                    "  `odds` DOUBLE NOT NULL,\n" +
                    "  `actual_result` VARCHAR(100) NOT NULL,\n" +
                    "  `bet_amount` DOUBLE NOT NULL,\n" +
                    "  `payout` DOUBLE NOT NULL,\n" +
                    "  `fk_gamblers` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_bets_gamblers_idx` (`fk_gamblers` ASC),\n" +
                    "  CONSTRAINT `fk_bets_gamblers`\n" +
                    "    FOREIGN KEY (`fk_gamblers`)\n" +
                    "    REFERENCES `yarmolenka`.`gamblers` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
