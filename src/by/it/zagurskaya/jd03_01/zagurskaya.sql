-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema zagurskaya
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `zagurskaya` ;

-- -----------------------------------------------------
-- Schema zagurskaya
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zagurskaya` DEFAULT CHARACTER SET utf8 ;
USE `zagurskaya` ;

-- -----------------------------------------------------
-- Table `zagurskaya`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `zagurskaya`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NULL,
  `addres` VARCHAR(45) NULL,
  `floor` VARCHAR(45) NULL,
  `adscol` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `zagurskaya`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `zagurskaya`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `zagurskaya`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'ivanov', 'ivaniov@mail.ru', 'ivanov', 1);
INSERT INTO `zagurskaya`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'petrov', 'petrov@mail.ru', 'petrov', 2);
INSERT INTO `zagurskaya`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'guest', 'guest@mail.ru', 'guest', 2);

COMMIT;

