-- MySQL Script generated by MySQL Workbench
-- 04/20/16 17:45:57
-- Model: New Model    Version: 1.0
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
-- -----------------------------------------------------
-- Schema aes
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `aes` ;

-- -----------------------------------------------------
-- Schema aes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aes` DEFAULT CHARACTER SET latin1 ;
USE `mydb` ;
USE `aes` ;

-- -----------------------------------------------------
-- Table `aes`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`address` ;

CREATE TABLE IF NOT EXISTS `aes`.`address` (
  `ADDRESS_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ADDRESSLINE1` VARCHAR(30) NULL DEFAULT NULL,
  `ADDRESSLINE2` VARCHAR(30) NULL DEFAULT NULL,
  `ADDRESSLINE3` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aes`.`address_pk`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`address_pk` ;

CREATE TABLE IF NOT EXISTS `aes`.`address_pk` (
  `ADRESS_PK` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aes`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`person` ;

CREATE TABLE IF NOT EXISTS `aes`.`person` (
  `PERSON_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS_ID` INT(11) NOT NULL,
  `NAME` VARCHAR(30) NULL DEFAULT NULL,
  `SURNAME` VARCHAR(30) NULL DEFAULT NULL,
  `TITLE` VARCHAR(30) NULL DEFAULT NULL,
  `BIRTHDAY` DATE NULL DEFAULT NULL,
  `SEX` CHAR(1) NULL DEFAULT NULL,
  `PHONE` VARCHAR(15) NULL DEFAULT NULL,
  `WORKPHONE` VARCHAR(15) NULL DEFAULT NULL,
  `CELLPHONE` VARCHAR(15) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(30) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(255) NOT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`),
  CONSTRAINT `FK_PERSON_ADDRESS_ADDRESS_ID`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `aes`.`address` (`ADDRESS_ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `FK_PERSON_ADDRESS_ADDRESS_ID` ON `aes`.`person` (`ADDRESS_ID` ASC);


-- -----------------------------------------------------
-- Table `aes`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`client` ;

CREATE TABLE IF NOT EXISTS `aes`.`client` (
  `CLIENT_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CLIENT_NAME` VARCHAR(30) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(40) NULL DEFAULT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  `CONTACT_PERSON_ID` INT(11) NOT NULL,
  `ADDRESS_ID` INT(11) NOT NULL,
  PRIMARY KEY (`CLIENT_ID`),
  CONSTRAINT `fk_CLIENT_person1`
    FOREIGN KEY (`CONTACT_PERSON_ID`)
    REFERENCES `aes`.`person` (`PERSON_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CLIENT_address1`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `aes`.`address` (`ADDRESS_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_CLIENT_person1_idx` ON `aes`.`client` (`CONTACT_PERSON_ID` ASC);

CREATE INDEX `fk_CLIENT_address1_idx` ON `aes`.`client` (`ADDRESS_ID` ASC);


-- -----------------------------------------------------
-- Table `aes`.`dbsettings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`dbsettings` ;

CREATE TABLE IF NOT EXISTS `aes`.`dbsettings` (
  `ID` INT(11) NOT NULL DEFAULT '0',
  `TYPE` INT(11) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aes`.`member_pk`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`member_pk` ;

CREATE TABLE IF NOT EXISTS `aes`.`member_pk` (
  `MEMBER_PK` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aes`.`person_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`person_role` ;

CREATE TABLE IF NOT EXISTS `aes`.`person_role` (
  `PERSONROLE_ID` INT(11) NULL DEFAULT NULL,
  `PERSON_ID` INT(11) NULL DEFAULT NULL,
  `ROLE_ID` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aes`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`role` ;

CREATE TABLE IF NOT EXISTS `aes`.`role` (
  `ROLE_NAME` VARCHAR(45) NOT NULL,
  `ROLE_DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`ROLE_NAME`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `aes`.`survey`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`survey` ;

CREATE TABLE IF NOT EXISTS `aes`.`survey` (
  `SURVEY_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `SURVEY_NAME` VARCHAR(100) NULL DEFAULT NULL,
  `SURVEY_TYPE` VARCHAR(40) NULL DEFAULT NULL,
  `WORK_SUMMARY` VARCHAR(500) NULL DEFAULT NULL,
  `SURVEY_REQUESTED_DATE` VARCHAR(45) NULL DEFAULT NULL,
  `SURVEY_DATE` VARCHAR(45) NULL DEFAULT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  `STATUS` VARCHAR(45) NULL DEFAULT NULL,
  `USERNAME` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`SURVEY_ID`),
  CONSTRAINT `fk_survey_user1`
    FOREIGN KEY (`USERNAME`)
    REFERENCES `mydb`.`user` (`USERNAME`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX `SURVEY_NAME_UNIQUE` ON `aes`.`survey` (`SURVEY_NAME` ASC);

CREATE INDEX `fk_survey_user1_idx` ON `aes`.`survey` (`USERNAME` ASC);


-- -----------------------------------------------------
-- Table `aes`.`survey_client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`survey_client` ;

CREATE TABLE IF NOT EXISTS `aes`.`survey_client` (
  `SURVEY_ID` INT(11) NOT NULL,
  `CLIENT_ID` INT(11) NOT NULL,
  PRIMARY KEY (`SURVEY_ID`, `CLIENT_ID`),
  CONSTRAINT `fk_survey_has_CLIENT_survey1`
    FOREIGN KEY (`SURVEY_ID`)
    REFERENCES `aes`.`survey` (`SURVEY_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_survey_has_CLIENT_CLIENT1`
    FOREIGN KEY (`CLIENT_ID`)
    REFERENCES `aes`.`client` (`CLIENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_survey_has_CLIENT_CLIENT1_idx` ON `aes`.`survey_client` (`CLIENT_ID` ASC);

CREATE INDEX `fk_survey_has_CLIENT_survey1_idx` ON `aes`.`survey_client` (`SURVEY_ID` ASC);


-- -----------------------------------------------------
-- Table `aes`.`survey_readings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`survey_readings` ;

CREATE TABLE IF NOT EXISTS `aes`.`survey_readings` (
  `READING_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `SURVEY_ID` INT(11) NOT NULL,
  `LOCATION` VARCHAR(45) NULL DEFAULT NULL,
  `READING_TYPE` VARCHAR(45) NULL DEFAULT NULL,
  `UNIT` VARCHAR(45) NULL DEFAULT NULL,
  `VALUE` VARCHAR(45) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(45) NULL DEFAULT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`READING_ID`),
  CONSTRAINT `fk_survey_readings_survey1`
    FOREIGN KEY (`SURVEY_ID`)
    REFERENCES `aes`.`survey` (`SURVEY_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_survey_readings_survey1_idx` ON `aes`.`survey_readings` (`SURVEY_ID` ASC);


-- -----------------------------------------------------
-- Table `aes`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`user` ;

CREATE TABLE IF NOT EXISTS `aes`.`user` (
  `USERNAME` VARCHAR(30) NOT NULL,
  `PASSWORD` VARCHAR(30) NOT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  `PERSON_ID` INT(11) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  CONSTRAINT `fk_user_person`
    FOREIGN KEY (`PERSON_ID`)
    REFERENCES `aes`.`person` (`PERSON_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_user_person` ON `aes`.`user` (`PERSON_ID` ASC);


-- -----------------------------------------------------
-- Table `aes`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `aes`.`user_role` ;

CREATE TABLE IF NOT EXISTS `aes`.`user_role` (
  `username` VARCHAR(30) NOT NULL,
  `role_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`username`, `role_name`),
  CONSTRAINT `tomcat_user_role_fk_username`
    FOREIGN KEY (`username`)
    REFERENCES `aes`.`user` (`USERNAME`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tomcat_user_role_fk_role_name`
    FOREIGN KEY (`role_name`)
    REFERENCES `aes`.`role` (`ROLE_NAME`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `tomcat_user_role_fk_role_name_idx` ON `aes`.`user_role` (`role_name` ASC);

CREATE UNIQUE INDEX `username_UNIQUE` ON `aes`.`user_role` (`username` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
