-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema yarmolenka
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `yarmolenka` ;

-- -----------------------------------------------------
-- Schema yarmolenka
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `yarmolenka` DEFAULT CHARACTER SET utf8 ;
USE `yarmolenka` ;

-- -----------------------------------------------------
-- Table `yarmolenka`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`roles` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`gamblers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`gamblers` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`gamblers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `fk_roles` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_gamblers_roles_idx` (`fk_roles` ASC),
  CONSTRAINT `fk_gamblers_roles`
    FOREIGN KEY (`fk_roles`)
    REFERENCES `yarmolenka`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`bets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`bets` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`bets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sport` VARCHAR(100) NULL,
  `event` VARCHAR(100) NULL,
  `actual_bet` VARCHAR(100) NULL,
  `odds` DOUBLE NULL,
  `actual_result` VARCHAR(100) NULL,
  `bet_amount` DOUBLE NULL,
  `payout` DOUBLE NULL,
  `gamblers_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bets_gamblers1_idx` (`gamblers_id` ASC),
  CONSTRAINT `fk_bets_gamblers1`
    FOREIGN KEY (`gamblers_id`)
    REFERENCES `yarmolenka`.`gamblers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `yarmolenka`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `yarmolenka`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`gamblers`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) VALUES (DEFAULT, 'admin', 'admin', 'admin@mail.ru', 1);
INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) VALUES (DEFAULT, 'first_gambler', 'password1', 'gambler1@mail.ru', 2);
INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `password`, `email`, `fk_roles`) VALUES (DEFAULT, 'second_gambler', 'password2', 'gambler2@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`bets`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`bets` (`id`, `sport`, `event`, `actual_bet`, `odds`, `actual_result`, `bet_amount`, `payout`, `gamblers_id`) VALUES (DEFAULT, 'soccer', 'match1', 'W1', 2.4, 'X', 100, 0, 2);
INSERT INTO `yarmolenka`.`bets` (`id`, `sport`, `event`, `actual_bet`, `odds`, `actual_result`, `bet_amount`, `payout`, `gamblers_id`) VALUES (DEFAULT, 'soccer', 'match2', 'W2', 2.1, 'W2', 100, 210, 2);
INSERT INTO `yarmolenka`.`bets` (`id`, `sport`, `event`, `actual_bet`, `odds`, `actual_result`, `bet_amount`, `payout`, `gamblers_id`) VALUES (DEFAULT, 'hockey', 'match3', 'W1', 3.7, 'W1', 100, 370, 3);

COMMIT;

