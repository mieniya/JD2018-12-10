-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema skosirskiy
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `skosirskiy` ;

-- -----------------------------------------------------
-- Schema skosirskiy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `skosirskiy` DEFAULT CHARACTER SET utf8 ;
USE `skosirskiy` ;

-- -----------------------------------------------------
-- Table `skosirskiy`.`dispatchers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`dispatchers` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`dispatchers` (
  `id_dispatcher` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `access_level` VARCHAR(45) NULL,
  PRIMARY KEY (`id_dispatcher`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`brigades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`brigades` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`brigades` (
  `id_brigade` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(45) NULL,
  PRIMARY KEY (`id_brigade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`workers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`workers` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`workers` (
  `id_worker` INT NOT NULL AUTO_INCREMENT,
  `post` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `brigades_id_brigade` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_worker`),
  INDEX `fk_workers_brigades1_idx` (`brigades_id_brigade` ASC),
  CONSTRAINT `fk_workers_brigades1`
    FOREIGN KEY (`brigades_id_brigade`)
    REFERENCES `skosirskiy`.`brigades` (`id_brigade`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`adress`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`adress` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`adress` (
  `id_client` INT NOT NULL,
  `city` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `number_house` VARCHAR(45) NULL,
  `number_flat` VARCHAR(45) NULL,
  PRIMARY KEY (`id_client`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`clients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`clients` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`clients` (
  `id_client` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `adress_id_client` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_client`),
  INDEX `fk_clients_adress1_idx` (`adress_id_client` ASC),
  CONSTRAINT `fk_clients_adress1`
    FOREIGN KEY (`adress_id_client`)
    REFERENCES `skosirskiy`.`adress` (`id_client`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`status` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`status` (
  `id_status` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(45) NULL,
  PRIMARY KEY (`id_status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skosirskiy`.`requests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skosirskiy`.`requests` ;

CREATE TABLE IF NOT EXISTS `skosirskiy`.`requests` (
  `id_request` INT NOT NULL AUTO_INCREMENT,
  `date_create` DATE NULL,
  `date_complete` DATE NULL,
  `type_request` VARCHAR(100) NULL,
  `dispatchers_id_dispatcher` INT NOT NULL,
  `workers_id_worker` INT NOT NULL,
  `clients_id_client` INT NOT NULL,
  `status_id_status` INT NOT NULL,
  PRIMARY KEY (`id_request`),
  INDEX `fk_requests_dispatchers_idx` (`dispatchers_id_dispatcher` ASC),
  INDEX `fk_requests_workers1_idx` (`workers_id_worker` ASC),
  INDEX `fk_requests_clients1_idx` (`clients_id_client` ASC),
  INDEX `fk_requests_status1_idx` (`status_id_status` ASC),
  CONSTRAINT `fk_requests_dispatchers`
    FOREIGN KEY (`dispatchers_id_dispatcher`)
    REFERENCES `skosirskiy`.`dispatchers` (`id_dispatcher`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_requests_workers1`
    FOREIGN KEY (`workers_id_worker`)
    REFERENCES `skosirskiy`.`workers` (`id_worker`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_requests_clients1`
    FOREIGN KEY (`clients_id_client`)
    REFERENCES `skosirskiy`.`clients` (`id_client`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_requests_status1`
    FOREIGN KEY (`status_id_status`)
    REFERENCES `skosirskiy`.`status` (`id_status`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `skosirskiy`.`dispatchers`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`dispatchers` (`id_dispatcher`, `login`, `password`, `email`, `access_level`) VALUES (1, 'petrov', 'petrovpass', 'petrov@ya.ru', '1');
INSERT INTO `skosirskiy`.`dispatchers` (`id_dispatcher`, `login`, `password`, `email`, `access_level`) VALUES (2, 'sidorov', 'sidorovpass', 'sidorov@ya.ru', '2');
INSERT INTO `skosirskiy`.`dispatchers` (`id_dispatcher`, `login`, `password`, `email`, `access_level`) VALUES (3, 'ivanov', 'ivanovpass', 'ivanov@ya.ru', '3');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`brigades`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`brigades` (`id_brigade`, `value`) VALUES (1, 'first');
INSERT INTO `skosirskiy`.`brigades` (`id_brigade`, `value`) VALUES (2, 'second');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`workers`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`workers` (`id_worker`, `post`, `phone`, `brigades_id_brigade`, `name`) VALUES (1, 'brigadier', '2233556', 1, 'semen');
INSERT INTO `skosirskiy`.`workers` (`id_worker`, `post`, `phone`, `brigades_id_brigade`, `name`) VALUES (2, 'locksmith', '3344567', 1, 'sergei');
INSERT INTO `skosirskiy`.`workers` (`id_worker`, `post`, `phone`, `brigades_id_brigade`, `name`) VALUES (3, 'brigadier', '2233123', 2, 'ivan');
INSERT INTO `skosirskiy`.`workers` (`id_worker`, `post`, `phone`, `brigades_id_brigade`, `name`) VALUES (4, 'Mechanic', '1234556', 2, 'petr');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`adress`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`adress` (`id_client`, `city`, `street`, `number_house`, `number_flat`) VALUES (1, 'minsk', 'lenina', '5', '12');
INSERT INTO `skosirskiy`.`adress` (`id_client`, `city`, `street`, `number_house`, `number_flat`) VALUES (2, 'grodno', 'sadovaya', '1', '66');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`clients`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`clients` (`id_client`, `login`, `password`, `email`, `adress_id_client`, `name`) VALUES (1, 'vasya', 'vasyapass', 'vasya@ya.ru', 1, 'vasilii ivanich');
INSERT INTO `skosirskiy`.`clients` (`id_client`, `login`, `password`, `email`, `adress_id_client`, `name`) VALUES (2, 'petya', 'petyapass', 'petya@ya.ru', 2, 'petr sergeevich');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`status`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`status` (`id_status`, `value`) VALUES (1, 'in work');
INSERT INTO `skosirskiy`.`status` (`id_status`, `value`) VALUES (2, 'complete');
INSERT INTO `skosirskiy`.`status` (`id_status`, `value`) VALUES (3, 'canceled');

COMMIT;


-- -----------------------------------------------------
-- Data for table `skosirskiy`.`requests`
-- -----------------------------------------------------
START TRANSACTION;
USE `skosirskiy`;
INSERT INTO `skosirskiy`.`requests` (`id_request`, `date_create`, `date_complete`, `type_request`, `dispatchers_id_dispatcher`, `workers_id_worker`, `clients_id_client`, `status_id_status`) VALUES (1, '02.02.2019', '22.02.2019', 'burst pipe', 2, 2, 2, 2);
INSERT INTO `skosirskiy`.`requests` (`id_request`, `date_create`, `date_complete`, `type_request`, `dispatchers_id_dispatcher`, `workers_id_worker`, `clients_id_client`, `status_id_status`) VALUES (2, '02.01.2019', '12.01.2019', 'no water', 1, 1, 1, 1);

COMMIT;

