package by.it.dziomin.jd03_01.SQL_queries;

public interface CreateTables {
    String DROP_TABLES = "DROP SCHEMA IF EXISTS `dziomin` ;";
    String CREATE_SCHEMA = "CREATE SCHEMA IF NOT EXISTS `dziomin` DEFAULT CHARACTER SET utf8 ;";
    String CREATE_USERS = "CREATE TABLE IF NOT EXISTS `dziomin`.`users` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(100) NULL,\n" +
            "  `passport` VARCHAR(100) NULL,\n" +
            "  `phone` VARCHAR(100) NULL,\n" +
            "  `roles_id` INT NOT NULL DEFAULT 2,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
            "  CONSTRAINT `fk_users_roles`\n" +
            "    FOREIGN KEY (`roles_id`)\n" +
            "    REFERENCES `dziomin`.`roles` (`id`)\n" +
            "    ON DELETE RESTRICT\n" +
            "    ON UPDATE RESTRICT)";
    String CREATE_ROLES = "CREATE TABLE IF NOT EXISTS `dziomin`.`roles` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `role` VARCHAR(100) NULL,\n" +
            "  PRIMARY KEY (`id`))";
    String CREATE_RENTS = "CREATE TABLE IF NOT EXISTS `dziomin`.`rents` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `date` INT NULL,\n" +
            "  `price` DECIMAL(10,2) NULL,\n" +
            "  `isopen` TINYINT(1) NOT NULL,\n" +
            "  `users_id` INT NOT NULL,\n" +
            "  `cars_id` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_rents_users_idx` (`users_id` ASC),\n" +
            "  INDEX `fk_rents_cars_idx` (`cars_id` ASC),\n" +
            "  CONSTRAINT `fk_rents_users`\n" +
            "    FOREIGN KEY (`users_id`)\n" +
            "    REFERENCES `dziomin`.`users` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION,\n" +
            "  CONSTRAINT `fk_rents_cars`\n" +
            "    FOREIGN KEY (`cars_id`)\n" +
            "    REFERENCES `dziomin`.`cars` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)";
    String CREATE_CARS = "CREATE TABLE IF NOT EXISTS `dziomin`.`cars` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NULL,\n" +
            "  `number` VARCHAR(45) NULL,\n" +
            "  `engine` VARCHAR(45) NULL,\n" +
            "  `transmission` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`id`))";

//    String

}
