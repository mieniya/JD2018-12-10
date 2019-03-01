package by.it.lyakhova.jd03_01.SqlRequest;

public interface CreateTables {

    String CREATE_SCHEMA = "CREATEGOODSFLOWER SCHEMA IF NOT EXISTS `lyakhova` DEFAULT CHARACTER SET utf8 ;";

    String CREATE_ROLES = "CREATEGOODSFLOWER TABLE IF NOT EXISTS `lyakhova`.`roles` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `role` VARCHAR(100) NULL," +
            "  `description` VARCHAR(200) NULL," +
            "  PRIMARY KEY (`id`))";

    String CREATE_USERS = "CREATEGOODSFLOWER TABLE IF NOT EXISTS `lyakhova`.`users` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `login` VARCHAR(100) NULL," +
            "  `password` VARCHAR(100) NULL," +
            "  `email` VARCHAR(100) NULL," +
            "  `contacts` VARCHAR(150) NULL," +
            "  `roles_id` INT NOT NULL," +
            "  PRIMARY KEY (`id`)," +
            "  CONSTRAINT `fk_users_roles`" +
            "    FOREIGN KEY (`roles_id`)" +
            "    REFERENCES `lyakhova`.`roles` (`id`)" +
            "    ON DELETE RESTRICT" +
            "    ON UPDATE RESTRICT)";

    String CREATE_PLACE = "CREATEGOODSFLOWER TABLE IF NOT EXISTS `lyakhova`.`place` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `country` VARCHAR(100) NULL," +
            "  `town` VARCHAR(100) NULL," +
            "  PRIMARY KEY (`id`))";

    String CREATE_TRANSPORT = "CREATEGOODSFLOWER TABLE IF NOT EXISTS `lyakhova`.`transport` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `type` VARCHAR(100) NULL," +
            "  PRIMARY KEY (`id`))";

    String CREATE_HOUSING = "CREATEGOODSFLOWER TABLE IF NOT EXISTS `lyakhova`.`housing` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `type` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`id`))";

    String CREATE_TOURS = "CREATEGOODSFLOWER TABLE IF NOT EXISTS `lyakhova`.`tours` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(100) NULL," +
            "  `tour_type_id` VARCHAR(100) NOT NULL," +
            "  `place_id` INT NOT NULL," +
            "  `transport_id` INT NOT NULL," +
            "  `housing_id` INT NOT NULL," +
            "  `price` INT NULL," +
            "  `date` VARCHAR(100) NULL," +
            "  `duration` INT NULL," +
            "  `hot` TINYINT NULL DEFAULT 0," +
            "  `discount` INT NULL DEFAULT 0," +
            "  PRIMARY KEY (`id`)," +
            "  CONSTRAINT `fk_tours_place1`" +
            "    FOREIGN KEY (`place_id`)" +
            "    REFERENCES `lyakhova`.`place` (`id`)" +
            "    ON DELETE RESTRICT" +
            "    ON UPDATE RESTRICT," +
            "  CONSTRAINT `fk_tours_transport1`" +
            "    FOREIGN KEY (`transport_id`)" +
            "    REFERENCES `lyakhova`.`transport` (`id`)" +
            "    ON DELETE RESTRICT" +
            "    ON UPDATE RESTRICT," +
            "  CONSTRAINT `fk_tours_housing1`" +
            "    FOREIGN KEY (`housing_id`)" +
            "    REFERENCES `lyakhova`.`housing` (`id`)" +
            "    ON DELETE RESTRICT" +
            "    ON UPDATE RESTRICT)";

    String CREATE_TOURS_USERS = "CREATEGOODSFLOWER TABLE IF NOT EXISTS `lyakhova`.`tours_has_users` (\n" +
            "  `id` INT NOT NULL AUTO_INCREMENT,"+
            "  `tours_id` INT NOT NULL," +
            "  `users_id` INT NOT NULL," +
            "  PRIMARY KEY (`id`, `tours_id`, `users_id`)," +
            "  CONSTRAINT `fk_tours_has_users_tours1`" +
            "    FOREIGN KEY (`tours_id`)" +
            "    REFERENCES `lyakhova`.`tours` (`id`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION," +
            "  CONSTRAINT `fk_tours_has_users_users1`" +
            "    FOREIGN KEY (`users_id`)" +
            "    REFERENCES `lyakhova`.`users` (`id`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION)";
}
