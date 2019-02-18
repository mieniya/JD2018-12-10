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
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_ROOT, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `yarmolenka`;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `yarmolenka` DEFAULT CHARACTER SET utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`gamblers`;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`gamblers` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`sports` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`sports` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `sport` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`match_status` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`match_status` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `finished` TINYINT(1) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`admins` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`admins` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`matches` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`matches` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `date` TIMESTAMP NULL,\n" +
                    "  `discription` VARCHAR(500) NULL,\n" +
                    "  `result` VARCHAR(45) NULL,\n" +
                    "  `fk_sports` INT NOT NULL,\n" +
                    "  `fk_match_status` INT NOT NULL,\n" +
                    "  `fk_admins` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_matches_sports_idx` (`fk_sports` ASC),\n" +
                    "  INDEX `fk_matches_match_status1_idx` (`fk_match_status` ASC),\n" +
                    "  INDEX `fk_matches_admins1_idx` (`fk_admins` ASC),\n" +
                    "  CONSTRAINT `fk_matches_sports`\n" +
                    "    FOREIGN KEY (`fk_sports`)\n" +
                    "    REFERENCES `yarmolenka`.`sports` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_matches_match_status1`\n" +
                    "    FOREIGN KEY (`fk_match_status`)\n" +
                    "    REFERENCES `yarmolenka`.`match_status` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_matches_admins1`\n" +
                    "    FOREIGN KEY (`fk_admins`)\n" +
                    "    REFERENCES `yarmolenka`.`admins` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`events` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`events` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `discription` VARCHAR(500) NULL,\n" +
                    "  `odds` DOUBLE NULL,\n" +
                    "  `fk_matches` INT NOT NULL,\n" +
                    "  `fk_admins` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_events_matches1_idx` (`fk_matches` ASC),\n" +
                    "  INDEX `fk_events_admins1_idx` (`fk_admins` ASC),\n" +
                    "  CONSTRAINT `fk_events_matches1`\n" +
                    "    FOREIGN KEY (`fk_matches`)\n" +
                    "    REFERENCES `yarmolenka`.`matches` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_events_admins1`\n" +
                    "    FOREIGN KEY (`fk_admins`)\n" +
                    "    REFERENCES `yarmolenka`.`admins` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`cashiers` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`cashiers` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `overall` DOUBLE NULL,\n" +
                    "  `available` DOUBLE NULL,\n" +
                    "  `in_bets` DOUBLE NULL,\n" +
                    "  `fk_gamblers` INT NOT NULL,\n" +
                    "  `fk_admins` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_cashiers_gamblers1_idx` (`fk_gamblers` ASC),\n" +
                    "  INDEX `fk_cashiers_admins1_idx` (`fk_admins` ASC),\n" +
                    "  CONSTRAINT `fk_cashiers_gamblers1`\n" +
                    "    FOREIGN KEY (`fk_gamblers`)\n" +
                    "    REFERENCES `yarmolenka`.`gamblers` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_cashiers_admins1`\n" +
                    "    FOREIGN KEY (`fk_admins`)\n" +
                    "    REFERENCES `yarmolenka`.`admins` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `yarmolenka`.`bets` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `yarmolenka`.`bets` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `amount` DOUBLE NULL,\n" +
                    "  `payout` DOUBLE NULL,\n" +
                    "  `fk_events` INT NOT NULL,\n" +
                    "  `fk_gamblers` INT NOT NULL,\n" +
                    "  `fk_cashiers` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_bets_events1_idx` (`fk_events` ASC),\n" +
                    "  INDEX `fk_bets_gamblers1_idx` (`fk_gamblers` ASC),\n" +
                    "  INDEX `fk_bets_cashiers1_idx` (`fk_cashiers` ASC),\n" +
                    "  CONSTRAINT `fk_bets_events1`\n" +
                    "    FOREIGN KEY (`fk_events`)\n" +
                    "    REFERENCES `yarmolenka`.`events` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_bets_gamblers1`\n" +
                    "    FOREIGN KEY (`fk_gamblers`)\n" +
                    "    REFERENCES `yarmolenka`.`gamblers` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_bets_cashiers1`\n" +
                    "    FOREIGN KEY (`fk_cashiers`)\n" +
                    "    REFERENCES `yarmolenka`.`cashiers` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
