package by.it.yarmolenka.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class C_Init {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void initializeSQL() {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_PACKAGE, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(
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
            statement.executeUpdate("INSERT INTO `yarmolenka`.`roles` (`id`, `role`) " +
                    "VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`roles` (`id`, `role`) " +
                    "VALUES (DEFAULT, 'gambler');");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'admin','admin','admin@mail.ru',1);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'first_gambler','password1','gambler1@mail.ru',2);");
            statement.executeUpdate("INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) " +
                    "VALUES (DEFAULT, 'second_gambler','password2','gambler2@mail.ru',2);");
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
