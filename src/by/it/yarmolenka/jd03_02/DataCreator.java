package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.beans.*;
import by.it.yarmolenka.jd03_02.crud.*;

import java.sql.*;

class DataCreator {
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


            fulfillData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fulfillData() throws SQLException {
        fulfillRoles();

        fulfillUsers();

        fulfillRaces();

        fulfillEvents();

        fulfillBets();
    }

    private void fulfillBets() throws SQLException {
        BetCRUD betCRUD = new BetCRUD();
        Bet bet1 = new Bet(0,100, 0, 2, 2);
        Bet bet2 = new Bet(0,100, 280, 3, 3);
        betCRUD.create(bet1);
        betCRUD.create(bet2);
    }

    private void fulfillEvents() throws SQLException {
        EventCRUD eventCRUD = new EventCRUD();
        Event w1 = new Event(0, "first hamster wins", 3.2, 1);
        Event w2 = new Event(0, "second hamster wins", 2.2, 1);
        Event w3 = new Event(0, "first rabbit wins", 2.8, 2);
        Event w4 = new Event(0, "third hamster wins", 4.2, 2);
        eventCRUD.create(w1);
        eventCRUD.create(w2);
        eventCRUD.create(w3);
        eventCRUD.create(w4);
    }

    private void fulfillRaces() throws SQLException {
        RaceCRUD raceCRUD = new RaceCRUD();
        Timestamp time1 = Timestamp.valueOf("2019-03-03 18:00:00");
        Timestamp time2 = Timestamp.valueOf("2019-03-03 19:00:00");
        Race first = new Race(0, time1, "round race track", "race of humsters");
        Race second = new Race(0, time2, "square race track", "race of rabbits");
        raceCRUD.create(first);
        raceCRUD.create(second);
    }

    private void fulfillUsers() throws SQLException {
        UserCRUD userCRUD = new UserCRUD();
        User admin = new User(0, "admin", "admin@mail.ru",
                "adminpass", 0, 1);
        User gambler1 = new User(0, "gambler1", "gambler1@mail.ru",
                "gambler1pass", 1000, 2);
        User gambler2 = new User(0, "gambler2", "gambler2@mail.ru",
                "gambler2pass", 1000, 2);
        userCRUD.create(admin);
        userCRUD.create(gambler1);
        userCRUD.create(gambler2);
    }

    private void fulfillRoles() throws SQLException {
        RoleCRUD roleCRUD = new RoleCRUD();
        Role administrator = new Role(0, "admin");
        Role gambler = new Role(0, "gambler");
        roleCRUD.create(administrator);
        roleCRUD.create(gambler);
    }
}

