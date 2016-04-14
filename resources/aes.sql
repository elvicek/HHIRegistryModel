-- MySQL Script generated by MySQL Workbench
-- 04/14/16 12:05:53
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema registry
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `ADDRESS_ID` INT(11) NOT NULL DEFAULT '0',
  `ADDRESSLINE1` VARCHAR(30) NULL DEFAULT NULL,
  `ADDRESSLINE2` VARCHAR(30) NULL DEFAULT NULL,
  `ADDRESSLINE3` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`ADDRESS_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `person` ;

CREATE TABLE IF NOT EXISTS `person` (
  `PERSON_ID` INT(11) NOT NULL DEFAULT '0',
  `ADDRESS_ID` INT(11) NOT NULL,
  `NAME` VARCHAR(30) NULL DEFAULT NULL,
  `SURNAME` VARCHAR(30) NULL DEFAULT NULL,
  `TITLE` VARCHAR(30) NULL,
  `BIRTHDAY` DATE NULL DEFAULT NULL,
  `SEX` CHAR(1) NULL DEFAULT NULL,
  `PHONE` VARCHAR(15) NULL,
  `WORKPHONE` VARCHAR(15) NULL DEFAULT NULL,
  `CELLPHONE` VARCHAR(15) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(30) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(255) NOT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`PERSON_ID`),
  CONSTRAINT `FK_PERSON_ADDRESS_ADDRESS_ID`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `address` (`ADDRESS_ID`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `FK_PERSON_ADDRESS_ADDRESS_ID` ON `person` (`ADDRESS_ID` ASC);


-- -----------------------------------------------------
-- Table `role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role` ;

CREATE TABLE IF NOT EXISTS `role` (
  `ROLE_NAME` VARCHAR(30) NOT NULL DEFAULT '',
  `ROLE_DESCRIPTION` VARCHAR(255) NULL,
  `ROLE_ID` INT(11) NOT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `USERNAME` (16) NOT NULL,
  `PASSWORD` (32) NOT NULL,
  `CREATED_BY` VARCHAR(30) NULL,
  `CREATED_DATE` DATE NULL,
  `PERSON_ID` INT(11) NOT NULL,
  `ROLE_ID` INT(11) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  CONSTRAINT `fk_user_person`
    FOREIGN KEY (`PERSON_ID`)
    REFERENCES `registry`.`person` (`PERSON_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role1`
    FOREIGN KEY (`ROLE_ID`)
    REFERENCES `registry`.`role` (`ROLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE INDEX `fk_user_role1_idx` ON `user` (`ROLE_ID` ASC);


-- -----------------------------------------------------
-- Table `survey`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `survey` ;

CREATE TABLE IF NOT EXISTS `survey` (
  `SURVEY_ID` INT(11) NOT NULL,
  `SURVEY_NAME` VARCHAR(100) NULL,
  `SURVEY_TYPE` VARCHAR(40) NULL DEFAULT NULL,
  `WORK_SUMMARY` VARCHAR(500) NULL,
  `SURVEY_REQUESTED_DATE` VARCHAR(45) NULL,
  `SURVEY_DATE` VARCHAR(45) NULL,
  `CREATED_BY` VARCHAR(30) NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  `STATUS` VARCHAR(45) NULL,
  `USERNAME` (16) NOT NULL,
  PRIMARY KEY (`SURVEY_ID`),
  CONSTRAINT `fk_survey_user1`
    FOREIGN KEY (`USERNAME`)
    REFERENCES `mydb`.`user` (`USERNAME`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE UNIQUE INDEX `SURVEY_NAME_UNIQUE` ON `survey` (`SURVEY_NAME` ASC);

CREATE INDEX `fk_survey_user1_idx` ON `survey` (`USERNAME` ASC);


-- -----------------------------------------------------
-- Table `survey_readings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `survey_readings` ;

CREATE TABLE IF NOT EXISTS `survey_readings` (
  `READING_ID` INT NOT NULL,
  `SURVEY_ID` INT(11) NOT NULL,
  `LOCATION` VARCHAR(45) NULL,
  `READING_TYPE` VARCHAR(45) NULL,
  `UNIT` VARCHAR(45) NULL,
  `VALUE` VARCHAR(45) NULL,
  `DESCRIPTION` VARCHAR(45) NULL,
  `CREATED_BY` VARCHAR(30) NULL,
  `CREATED_DATE` DATE NULL,
  PRIMARY KEY (`READING_ID`),
  CONSTRAINT `fk_survey_readings_survey1`
    FOREIGN KEY (`SURVEY_ID`)
    REFERENCES `registry`.`survey` (`SURVEY_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_survey_readings_survey1_idx` ON `survey_readings` (`SURVEY_ID` ASC);


-- -----------------------------------------------------
-- Table `address_pk`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address_pk` ;

CREATE TABLE IF NOT EXISTS `address_pk` (
  `ADRESS_PK` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `dbsettings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbsettings` ;

CREATE TABLE IF NOT EXISTS `dbsettings` (
  `ID` INT(11) NOT NULL DEFAULT '0',
  `TYPE` INT(11) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `person_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `person_role` ;

CREATE TABLE IF NOT EXISTS `person_role` (
  `PERSONROLE_ID` INT(11) NULL DEFAULT NULL,
  `PERSON_ID` INT(11) NULL DEFAULT NULL,
  `ROLE_ID` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `member_pk`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `member_pk` ;

CREATE TABLE IF NOT EXISTS `member_pk` (
  `MEMBER_PK` INT(11) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `client` ;

CREATE TABLE IF NOT EXISTS `client` (
  `CLIENT_ID` INT(11) NOT NULL DEFAULT '0',
  `CLIENT_NAME` VARCHAR(30) NULL,
  `DESCRIPTION` VARCHAR(40) NULL DEFAULT NULL,
  `CREATED_BY` VARCHAR(30) NULL DEFAULT NULL,
  `CREATED_DATE` DATE NULL DEFAULT NULL,
  `PERSON_ID` INT(11) NOT NULL,
  `ADDRESS_ID` INT(11) NOT NULL,
  PRIMARY KEY (`CLIENT_ID`),
  CONSTRAINT `fk_CLIENT_person1`
    FOREIGN KEY (`PERSON_ID`)
    REFERENCES `person` (`PERSON_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CLIENT_address1`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `address` (`ADDRESS_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_CLIENT_person1_idx` ON `client` (`PERSON_ID` ASC);

CREATE INDEX `fk_CLIENT_address1_idx` ON `client` (`ADDRESS_ID` ASC);


-- -----------------------------------------------------
-- Table `survey_client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `survey_client` ;

CREATE TABLE IF NOT EXISTS `survey_client` (
  `SURVEY_ID` INT(11) NOT NULL,
  `CLIENT_ID` INT(11) NOT NULL,
  PRIMARY KEY (`SURVEY_ID`, `CLIENT_ID`),
  CONSTRAINT `fk_survey_has_CLIENT_survey1`
    FOREIGN KEY (`SURVEY_ID`)
    REFERENCES `survey` (`SURVEY_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_survey_has_CLIENT_CLIENT1`
    FOREIGN KEY (`CLIENT_ID`)
    REFERENCES `client` (`CLIENT_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE INDEX `fk_survey_has_CLIENT_CLIENT1_idx` ON `survey_client` (`CLIENT_ID` ASC);

CREATE INDEX `fk_survey_has_CLIENT_survey1_idx` ON `survey_client` (`SURVEY_ID` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
