-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

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
-- Table `yarmolenka`.`gamblers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`gamblers` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`gamblers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`sports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`sports` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`sports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sport` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`match_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`match_status` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`match_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `finished` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`admins`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`admins` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`admins` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`matches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`matches` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`matches` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NULL,
  `discription` VARCHAR(500) NULL,
  `result` VARCHAR(45) NULL,
  `fk_sports` INT NOT NULL,
  `fk_match_status` INT NOT NULL,
  `fk_admins` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_matches_sports_idx` (`fk_sports` ASC),
  INDEX `fk_matches_match_status1_idx` (`fk_match_status` ASC),
  INDEX `fk_matches_admins1_idx` (`fk_admins` ASC),
  CONSTRAINT `fk_matches_sports`
    FOREIGN KEY (`fk_sports`)
    REFERENCES `yarmolenka`.`sports` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_matches_match_status1`
    FOREIGN KEY (`fk_match_status`)
    REFERENCES `yarmolenka`.`match_status` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_matches_admins1`
    FOREIGN KEY (`fk_admins`)
    REFERENCES `yarmolenka`.`admins` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`events`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`events` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`events` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `discription` VARCHAR(500) NULL,
  `odds` DOUBLE NULL,
  `fk_matches` INT NOT NULL,
  `fk_admins` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_events_matches1_idx` (`fk_matches` ASC),
  INDEX `fk_events_admins1_idx` (`fk_admins` ASC),
  CONSTRAINT `fk_events_matches1`
    FOREIGN KEY (`fk_matches`)
    REFERENCES `yarmolenka`.`matches` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_events_admins1`
    FOREIGN KEY (`fk_admins`)
    REFERENCES `yarmolenka`.`admins` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`cashiers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`cashiers` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`cashiers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `overall` DOUBLE NULL,
  `available` DOUBLE NULL,
  `in_bets` DOUBLE NULL,
  `fk_gamblers` INT NOT NULL,
  `fk_admins` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cashiers_gamblers1_idx` (`fk_gamblers` ASC),
  INDEX `fk_cashiers_admins1_idx` (`fk_admins` ASC),
  CONSTRAINT `fk_cashiers_gamblers1`
    FOREIGN KEY (`fk_gamblers`)
    REFERENCES `yarmolenka`.`gamblers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_cashiers_admins1`
    FOREIGN KEY (`fk_admins`)
    REFERENCES `yarmolenka`.`admins` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`bets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`bets` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`bets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NULL,
  `payout` DOUBLE NULL,
  `fk_events` INT NOT NULL,
  `fk_gamblers` INT NOT NULL,
  `fk_cashiers` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bets_events1_idx` (`fk_events` ASC),
  INDEX `fk_bets_gamblers1_idx` (`fk_gamblers` ASC),
  INDEX `fk_bets_cashiers1_idx` (`fk_cashiers` ASC),
  CONSTRAINT `fk_bets_events1`
    FOREIGN KEY (`fk_events`)
    REFERENCES `yarmolenka`.`events` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_bets_gamblers1`
    FOREIGN KEY (`fk_gamblers`)
    REFERENCES `yarmolenka`.`gamblers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_bets_cashiers1`
    FOREIGN KEY (`fk_cashiers`)
    REFERENCES `yarmolenka`.`cashiers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `yarmolenka`.`gamblers`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `email`, `password`) VALUES (DEFAULT, 'gambler1', 'gambler1@mail.ru', 'gambler1pass');
INSERT INTO `yarmolenka`.`gamblers` (`id`, `login`, `email`, `password`) VALUES (DEFAULT, 'gambler2', 'gambler2@mail.ru', 'gambler2pass');

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`sports`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`sports` (`id`, `sport`) VALUES (DEFAULT, 'soccer');
INSERT INTO `yarmolenka`.`sports` (`id`, `sport`) VALUES (DEFAULT, 'hockey');

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`match_status`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`match_status` (`id`, `finished`) VALUES (DEFAULT, true);
INSERT INTO `yarmolenka`.`match_status` (`id`, `finished`) VALUES (DEFAULT, false);

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`admins`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`admins` (`id`, `login`, `email`, `password`) VALUES (DEFAULT, 'admin1', 'admin1@mail.ru', 'admin1pass');
INSERT INTO `yarmolenka`.`admins` (`id`, `login`, `email`, `password`) VALUES (DEFAULT, 'admin2', 'admin2@mail.ru', 'admin2pass');

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`matches`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`matches` (`id`, `date`, `discription`, `result`, `fk_sports`, `fk_match_status`, `fk_admins`) VALUES (DEFAULT, '10.05.2019', 'BATE - Dinamo', NULL, 1, 2, 1);
INSERT INTO `yarmolenka`.`matches` (`id`, `date`, `discription`, `result`, `fk_sports`, `fk_match_status`, `fk_admins`) VALUES (DEFAULT, '05.05.2019', 'SKA - CSKA', NULL, 2, 2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`events`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, `fk_admins`) VALUES (DEFAULT, 'W1', 2.2, 1, 1);
INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, `fk_admins`) VALUES (DEFAULT, 'X', 2.8, 1, 1);
INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, `fk_admins`) VALUES (DEFAULT, 'W2', 3.6, 1, 1);
INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, `fk_admins`) VALUES (DEFAULT, 'W1', 2.4, 2, 2);
INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, `fk_admins`) VALUES (DEFAULT, 'X', 4.0, 2, 2);
INSERT INTO `yarmolenka`.`events` (`id`, `discription`, `odds`, `fk_matches`, `fk_admins`) VALUES (DEFAULT, 'W2', 1.8, 2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`cashiers`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`cashiers` (`id`, `overall`, `available`, `in_bets`, `fk_gamblers`, `fk_admins`) VALUES (DEFAULT, 1000, 900, 100, 1, 1);
INSERT INTO `yarmolenka`.`cashiers` (`id`, `overall`, `available`, `in_bets`, `fk_gamblers`, `fk_admins`) VALUES (DEFAULT, 2000, 1800, 200, 2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `yarmolenka`.`bets`
-- -----------------------------------------------------
START TRANSACTION;
USE `yarmolenka`;
INSERT INTO `yarmolenka`.`bets` (`id`, `amount`, `payout`, `fk_events`, `fk_gamblers`, `fk_cashiers`) VALUES (DEFAULT, 100, NULL, 1, 1, 1);
INSERT INTO `yarmolenka`.`bets` (`id`, `amount`, `payout`, `fk_events`, `fk_gamblers`, `fk_cashiers`) VALUES (DEFAULT, 200, NULL, 4, 2, 2);

COMMIT;

