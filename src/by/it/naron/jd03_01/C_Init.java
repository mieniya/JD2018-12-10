package by.it.naron.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    protected void createDB() {

        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/"+
                                     "?useUnicode=true&characterEncoding=UTF-8",
                             "root",
                             "");
             Statement statement = connection.createStatement()
        ) {

 //           statement.executeUpdate("DROP SCHEMA IF EXISTS `naron` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `naron` DEFAULT CHARACTER SET utf8 ;");
 //           statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
 //           statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`users` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(50) NULL,\n" +
                    "  `password` VARCHAR(50) NULL,\n" +
                    "  `e-mail` VARCHAR(50) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `naron`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`goods_flower` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`goods_flower` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(60) NULL,\n" +
                    "  `color` VARCHAR(45) NULL,\n" +
                    "  `size` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
//            statement.executeUpdate("DROP TABLE IF EXISTS `naron`.`orders` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `naron`.`orders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `amount` DOUBLE NULL,\n" +
                    "  `time_delivery` DOUBLE NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  `goods_flower_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_orders_users1_idx` (`users_id` ASC),\n" +
                    "  INDEX `fk_orders_goods_flower1_idx` (`goods_flower_id` ASC),\n" +
                    "  CONSTRAINT `fk_orders_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `naron`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_orders_goods_flower1`\n" +
                    "    FOREIGN KEY (`goods_flower_id`)\n" +
                    "    REFERENCES `naron`.`goods_flower` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');");
            statement.executeUpdate("INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");

            statement.executeUpdate("INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'vasia', 'pvasia', 'vasia@it.by', 1);");
            statement.executeUpdate("INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'petia', 'ppetia', 'petia@it.by', 2);");
            statement.executeUpdate("INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'kolia', 'pkolia', 'kolia@it.by', 3);");

            statement.executeUpdate("INSERT INTO `naron`.`goods_flower` (`id`, `name`, `color`, `size`) VALUES (DEFAULT, 'rose', 'red', 70);");
            statement.executeUpdate("INSERT INTO `naron`.`goods_flower` (`id`, `name`, `color`, `size`) VALUES (DEFAULT, 'orchid', 'white', 50);");
            statement.executeUpdate("INSERT INTO `naron`.`goods_flower` (`id`, `name`, `color`, `size`) VALUES (DEFAULT, 'begonia', 'pink', 30);");

            statement.executeUpdate("INSERT INTO `naron`.`orders` (`id`, `amount`, order_date, `price`, `users_id`, `goods_flower_id`) VALUES (DEFAULT, 3, 5000000, 20, 1, 1);");
            statement.executeUpdate("INSERT INTO `naron`.`orders` (`id`, `amount`, order_date, `price`, `users_id`, `goods_flower_id`) VALUES (DEFAULT, 5, 6000000, 65, 2, 2);");

            } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
