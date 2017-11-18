-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`system_operator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`system_operator` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`system_operator` (
  `user_id` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `user_level` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`room_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`room_type` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`room_type` (
  `type_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `max_guests` INT NULL,
  `total_rooms` INT NULL,
  `room_price` DOUBLE NULL,
  `description` VARCHAR(200) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`type_id`),
  INDEX `fk_room_type_system_operator_idx` (`user_id` ASC),
  CONSTRAINT `fk_room_type_system_operator`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`system_operator` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`room`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`room` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`room` (
  `room_no` INT NOT NULL,
  `room_type` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`room_no`),
  INDEX `fk_room_system_operator1_idx` (`user_id` ASC),
  INDEX `fk_room_room_type1_idx` (`type_id` ASC),
  CONSTRAINT `fk_room_system_operator1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`system_operator` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_room_room_type1`
    FOREIGN KEY (`type_id`)
    REFERENCES `mydb`.`room_type` (`type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`customer` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`customer` (
  `customer_id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `home_no` VARCHAR(45) NULL,
  `zip_code` VARCHAR(45) NULL,
  `contact_no` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `credit_card_no` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`reservation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`reservation` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`reservation` (
  `reservation_id` INT NOT NULL,
  `guests_no` VARCHAR(45) NULL,
  `arrival_date` VARCHAR(45) NULL,
  `departure_date` VARCHAR(45) NULL,
  `reservation_status` VARCHAR(45) NULL,
  `room_no` INT NOT NULL,
  `user_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`reservation_id`),
  INDEX `fk_reservation_room1_idx` (`room_no` ASC),
  INDEX `fk_reservation_system_operator1_idx` (`user_id` ASC),
  INDEX `fk_reservation_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_reservation_room1`
    FOREIGN KEY (`room_no`)
    REFERENCES `mydb`.`room` (`room_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_system_operator1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`system_operator` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `mydb`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`payment` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`payment` (
  `payment_id` INT NOT NULL,
  `amount` VARCHAR(45) NULL,
  `customer_id` INT NOT NULL,
  `reservation_id` INT NOT NULL,
  PRIMARY KEY (`payment_id`),
  INDEX `fk_payment_customer1_idx` (`customer_id` ASC),
  INDEX `fk_payment_reservation1_idx` (`reservation_id` ASC),
  CONSTRAINT `fk_payment_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `mydb`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_reservation1`
    FOREIGN KEY (`reservation_id`)
    REFERENCES `mydb`.`reservation` (`reservation_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`cancelation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`cancelation` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`cancelation` (
  `raw_id` INT NOT NULL,
  `payment_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`raw_id`),
  INDEX `fk_cancelation_payment1_idx` (`payment_id` ASC),
  INDEX `fk_cancelation_customer1_idx` (`customer_id` ASC),
  CONSTRAINT `fk_cancelation_payment1`
    FOREIGN KEY (`payment_id`)
    REFERENCES `mydb`.`payment` (`payment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cancelation_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `mydb`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
