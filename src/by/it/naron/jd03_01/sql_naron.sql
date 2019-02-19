-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema naron
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `naron` ;

-- -----------------------------------------------------
-- Schema naron
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `naron` DEFAULT CHARACTER SET utf8 ;
USE `naron` ;

-- -----------------------------------------------------
-- Table `naron`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naron`.`roles` ;

CREATE TABLE IF NOT EXISTS `naron`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `naron`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naron`.`users` ;

CREATE TABLE IF NOT EXISTS `naron`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(50) NULL,
  `password` VARCHAR(50) NULL,
  `e-mail` VARCHAR(50) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `naron`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `naron`.`goods_flower`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naron`.`goods_flower` ;

CREATE TABLE IF NOT EXISTS `naron`.`goods_flower` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL,
  `color` VARCHAR(45) NULL,
  `size` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `naron`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naron`.`orders` ;

CREATE TABLE IF NOT EXISTS `naron`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NULL,
  `time_delivery` DOUBLE NULL,
  `price` DOUBLE NULL,
  `users_id` INT NOT NULL,
  `goods_flower_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orders_users1_idx` (`users_id` ASC),
  INDEX `fk_orders_goods_flower1_idx` (`goods_flower_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `naron`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_orders_goods_flower1`
    FOREIGN KEY (`goods_flower_id`)
    REFERENCES `naron`.`goods_flower` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `naron`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `naron`;
INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');
INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `naron`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `naron`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `naron`;
INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'vasia', 'pvasia', 'vasia@it.by', 1);
INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'petia', 'ppetia', 'petia@it.by', 2);
INSERT INTO `naron`.`users` (`id`, `login`, `password`, `e-mail`, `roles_id`) VALUES (DEFAULT, 'kolia', 'pkolia', 'kolia@it.by', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `naron`.`goods_flower`
-- -----------------------------------------------------
START TRANSACTION;
USE `naron`;
INSERT INTO `naron`.`goods_flower` (`id`, `name`, `color`, `size`) VALUES (DEFAULT, 'rose', 'red', 70);
INSERT INTO `naron`.`goods_flower` (`id`, `name`, `color`, `size`) VALUES (DEFAULT, 'orchid', 'white', 50);
INSERT INTO `naron`.`goods_flower` (`id`, `name`, `color`, `size`) VALUES (DEFAULT, 'begonia', 'pink', 30);

COMMIT;


-- -----------------------------------------------------
-- Data for table `naron`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `naron`;
INSERT INTO `naron`.`orders` (`id`, `amount`, `time_delivery`, `price`, `users_id`, `goods_flower_id`) VALUES (DEFAULT, 3, 5000000, 20, 1, 1);
INSERT INTO `naron`.`orders` (`id`, `amount`, `time_delivery`, `price`, `users_id`, `goods_flower_id`) VALUES (DEFAULT, 5, 6000000, 65, 2, 2);

COMMIT;

