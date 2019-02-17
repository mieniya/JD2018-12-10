package by.it.moroz.jd03.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:2016/", "root", "");
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `moroz` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `moroz` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `moroz`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `moroz`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `adress` VARCHAR(100) NULL,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `surname` VARCHAR(100) NULL,\n" +
                    "  `numberphone` INT NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `moroz`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `moroz`.`orders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `count` INT NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `chek` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_orders_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_orders_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `moroz`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, " +
                    "`name`, `surname`, `numberphone`, `roles_id`) " +
                    "VALUES (DEFAULT, 'TrinzoA', 'qwerty123', 'trizzzno@gmail.com', 'Nezavisimosti, 54-84', " +
                    "'Andrei', 'Trizno', 375298564237, 2);\n");
            statement.executeUpdate("INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'BorokhaM', 'borokha', " +
                    "NULL, NULL, 'Maria', 'Borokha', NULL, 1);\n");
            statement.executeUpdate("INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `adress`, `name`, " +
                    "`surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, NULL, NULL, NULL, 'Kedishko, 3-1', " +
                    "'Vladislau', 'Makarevich', 375447568394, 3);\n");
            statement.executeUpdate("INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`)" +
                    " VALUES (DEFAULT, 'Pizza', 2, 28.35, 56.7, 1);\n");
            statement.executeUpdate("INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 'Spaghetti pepperoni', 1, 18.26, 18.26, 1);\n");
            statement.executeUpdate("INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 'Coffee', 2, 5.00, 5.00, 1);\n");
            statement.executeUpdate("INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 'Steak', 1, 35.85, 35.85, 3);\n");
            statement.executeUpdate("INSERT INTO `moroz`.`orders` (`id`, `name`, `count`, `price`, `chek`, `users_id`) " +
                    "VALUES (DEFAULT, 'Salad', 1, 13.25, 13.25, 3);\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
