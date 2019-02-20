package by.it.yarmolenka.project_bookmaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseCreator {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void create(){
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_PACKAGE, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `yarmolenka`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `yarmolenka` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`roles`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`users`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `cashier` DOUBLE NULL,\n" +
                    "  `fk_roles` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`fk_roles` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`fk_roles`)\n" +
                    "    REFERENCES `yarmolenka`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`races`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`races` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `date` TIMESTAMP(6) NULL,\n" +
                    "  `race_track` VARCHAR(50) NULL,\n" +
                    "  `description` VARCHAR(500) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`events`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`events` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(500) NULL,\n" +
                    "  `odds` DOUBLE NULL,\n" +
                    "  `fk_races` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_events_race1_idx` (`fk_races` ASC),\n" +
                    "  CONSTRAINT `fk_events_race1`\n" +
                    "    FOREIGN KEY (`fk_races`)\n" +
                    "    REFERENCES `yarmolenka`.`races` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`bets`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`bets` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `amount` DOUBLE NULL,\n" +
                    "  `payout` DOUBLE NULL,\n" +
                    "  `fk_users` INT NOT NULL,\n" +
                    "  `fk_events` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_bets_users1_idx` (`fk_users` ASC),\n" +
                    "  INDEX `fk_bets_events1_idx` (`fk_events` ASC),\n" +
                    "  CONSTRAINT `fk_bets_users1`\n" +
                    "    FOREIGN KEY (`fk_users`)\n" +
                    "    REFERENCES `yarmolenka`.`users` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_bets_events1`\n" +
                    "    FOREIGN KEY (`fk_events`)\n" +
                    "    REFERENCES `yarmolenka`.`events` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
