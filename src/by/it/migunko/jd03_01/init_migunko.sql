-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema migunko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `migunko` ;

-- -----------------------------------------------------
-- Schema migunko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `migunko` DEFAULT CHARACTER SET utf8 ;
USE `migunko` ;

-- -----------------------------------------------------
-- Table `migunko`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `migunko`.`roles` ;

CREATE TABLE IF NOT EXISTS `migunko`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `migunko`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `migunko`.`users` ;

CREATE TABLE IF NOT EXISTS `migunko`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `migunko`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `migunko`.`tours`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `migunko`.`tours` ;

CREATE TABLE IF NOT EXISTS `migunko`.`tours` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(100) NULL,
  `TypeOfTravel` VARCHAR(45) NULL,
  `Destination` VARCHAR(45) NULL,
  `Hotel` VARCHAR(45) NULL,
  `CountOfNights` INT NULL,
  `Price` DOUBLE NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_tours_users1_idx` (`users_ID` ASC),
  CONSTRAINT `fk_tours_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `migunko`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `migunko`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `migunko`;
INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Agent');
INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Buyer');

COMMIT;


-- -----------------------------------------------------
-- Data for table `migunko`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `migunko`;
INSERT INTO `migunko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'afasf', 'admin@gmail.com', 1);
INSERT INTO `migunko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'tatiana', 'afdasfafasf', 'tanya@gmail.com', 2);
INSERT INTO `migunko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'evgeniya', 'afetrs', 'zhenya@gmail.com', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `migunko`.`tours`
-- -----------------------------------------------------
START TRANSACTION;
USE `migunko`;
INSERT INTO `migunko`.`tours` (`ID`, `Description`, `TypeOfTravel`, `Destination`, `Hotel`, `CountOfNights`, `Price`, `users_ID`) VALUES (DEFAULT, 'bus tour for 3 days', 'excursion', 'Saint-Petersburg', 'Station Hotel', 2, 300, 3);

COMMIT;

