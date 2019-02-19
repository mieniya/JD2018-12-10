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
  `status` VARCHAR(100) NULL,
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
  `description` VARCHAR(500) NULL,
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
  `description` VARCHAR(500) NULL,
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
-- Table `yarmolenka`.`bets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`bets` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`bets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NULL,
  `payout` DOUBLE NULL,
  `fk_events` INT NOT NULL,
  `fk_gamblers` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_bets_events1_idx` (`fk_events` ASC),
  INDEX `fk_bets_gamblers1_idx` (`fk_gamblers` ASC),
  CONSTRAINT `fk_bets_events1`
    FOREIGN KEY (`fk_events`)
    REFERENCES `yarmolenka`.`events` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_bets_gamblers1`
    FOREIGN KEY (`fk_gamblers`)
    REFERENCES `yarmolenka`.`gamblers` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
