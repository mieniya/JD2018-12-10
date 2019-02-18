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
-- Table `yarmolenka`.`bets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`bets` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`bets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NULL,
  `payout` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yarmolenka`.`events`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`events` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`events` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `discription` VARCHAR(500) NULL,
  `odds` DOUBLE NULL,
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
-- Table `yarmolenka`.`cashiers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `yarmolenka`.`cashiers` ;

CREATE TABLE IF NOT EXISTS `yarmolenka`.`cashiers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `overall` DOUBLE NULL,
  `available` DOUBLE NULL,
  `in_bets` DOUBLE NULL,
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
