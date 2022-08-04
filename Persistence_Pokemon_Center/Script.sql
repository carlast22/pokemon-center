-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pokemon_center
-- -----------------------------------------------------
-- Database schema for learning squad project
DROP SCHEMA IF EXISTS `pokemon_center` ;

-- -----------------------------------------------------
-- Schema pokemon_center
--
-- Database schema for learning squad project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokemon_center` ;
USE `pokemon_center` ;

-- -----------------------------------------------------
-- Table `pokemon_center`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Role` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Role` (
  `rol_id` INT NOT NULL AUTO_INCREMENT,
  `rol_name` VARCHAR(75) NULL,
  `rol_description` VARCHAR(300) NULL,
  `rol_active` TINYINT NULL,
  PRIMARY KEY (`rol_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon_center`.`Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Person` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Person` (
  `per_id` INT NOT NULL AUTO_INCREMENT,
  `per_name` VARCHAR(75) NULL,
  `per_last_name` VARCHAR(75) NULL,
  `per_identification` VARCHAR(15) NULL,
  `per_email` VARCHAR(75) NULL,
  `per_active` TINYINT NULL,
  `per_created_at` DATETIME NULL,
  `per_date_of_birth` DATE NULL,
  `per_password` VARCHAR(45) NULL,
  `per_rol_id` INT NOT NULL,
  PRIMARY KEY (`per_id`),
  UNIQUE INDEX `per_identification_UNIQUE` (`per_identification` ASC) VISIBLE,
  INDEX `fk_Person_Role1_idx` (`per_rol_id` ASC) VISIBLE,
  CONSTRAINT `fk_Person_Role1`
    FOREIGN KEY (`per_rol_id`)
    REFERENCES `pokemon_center`.`Role` (`rol_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon_center`.`Pokemon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Pokemon` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Pokemon` (
  `pok_id` INT NOT NULL AUTO_INCREMENT,
  `pok_api_id` INT NULL,
  `pok_name` VARCHAR(75) NULL,
  `pok_gender` VARCHAR(75) NULL,
  `pok_image` VARCHAR(150) NULL COMMENT 'Mantengamos como url\n',
  `pok_species` VARCHAR(75) NULL,
  `pok_colors` VARCHAR(75) NULL,
  `pok_habitat` VARCHAR(75) NULL,
  `pok_shape` VARCHAR(75) NULL,
  PRIMARY KEY (`pok_id`),
  UNIQUE INDEX `pok_api_id_UNIQUE` (`pok_api_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon_center`.`Pokemon_Person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Pokemon_Person` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Pokemon_Person` (
  `pok_per_id` INT NOT NULL AUTO_INCREMENT,
  `pok_per_nickname` VARCHAR(75) NULL,
  `pok_per_height` DOUBLE NULL,
  `pok_per_weight` DOUBLE NULL,
  `pok_per_active` TINYINT NULL,
  `pok_per_created_at` DATETIME NULL,
  `pok_per_pok_id` INT NOT NULL,
  `pok_per_per_id` INT NOT NULL,
  PRIMARY KEY (`pok_per_id`),
  INDEX `fk_Pokemon_Person_Pokemon1_idx` (`pok_per_pok_id` ASC) VISIBLE,
  INDEX `fk_Pokemon_Person_Person1_idx` (`pok_per_per_id` ASC) VISIBLE,
  CONSTRAINT `fk_Pokemon_Person_Pokemon1`
    FOREIGN KEY (`pok_per_pok_id`)
    REFERENCES `pokemon_center`.`Pokemon` (`pok_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pokemon_Person_Person1`
    FOREIGN KEY (`pok_per_per_id`)
    REFERENCES `pokemon_center`.`Person` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon_center`.`Symptom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Symptom` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Symptom` (
  `sym_id` INT NOT NULL AUTO_INCREMENT,
  `sym_name` VARCHAR(75) NULL,
  `sym_description` VARCHAR(150) NULL,
  PRIMARY KEY (`sym_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon_center`.`Medical_Record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Medical_Record` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Medical_Record` (
  `med_rec_id` INT NOT NULL AUTO_INCREMENT,
  `med_rec_arrival_date` DATETIME NULL,
  `med_rec_diagnostic` VARCHAR(300) NULL,
  `med_rec_follow_up_date` DATETIME NULL,
  `med_rec_end_date` DATETIME NULL,
  `med_rec_observation` VARCHAR(150) NULL,
  `med_rec_per_id` INT NOT NULL COMMENT 'Id for doctor',
  `med_rec_pok_per_id` INT NOT NULL,
  PRIMARY KEY (`med_rec_id`),
  INDEX `fk_Medical_Record_Person1_idx` (`med_rec_per_id` ASC) VISIBLE,
  INDEX `fk_Medical_Record_Pokemon_Person1_idx` (`med_rec_pok_per_id` ASC) VISIBLE,
  CONSTRAINT `fk_Medical_Record_Person1`
    FOREIGN KEY (`med_rec_per_id`)
    REFERENCES `pokemon_center`.`Person` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medical_Record_Pokemon_Person1`
    FOREIGN KEY (`med_rec_pok_per_id`)
    REFERENCES `pokemon_center`.`Pokemon_Person` (`pok_per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon_center`.`Medical_Record_Symptom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Medical_Record_Symptom` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Medical_Record_Symptom` (
  `med_rec_sym_id` INT NOT NULL AUTO_INCREMENT,
  `med_rec_sym_active` TINYINT NULL,
  `med_rec_sym_created_at` DATETIME NULL,
  `med_rec_sym_diagnostics_period` DOUBLE NULL COMMENT 'Para registrar el tiempo que tuvo el sintoma, en dias\n\n',
  `med_rec_sym_sym_id` INT NOT NULL,
  `med_rec_sym_med_rec_id` INT NOT NULL,
  PRIMARY KEY (`med_rec_sym_id`),
  INDEX `fk_Medical_Record_Symptom_Symptom1_idx` (`med_rec_sym_sym_id` ASC) VISIBLE,
  INDEX `fk_Medical_Record_Symptom_Medical_Record1_idx` (`med_rec_sym_med_rec_id` ASC) VISIBLE,
  CONSTRAINT `fk_Medical_Record_Symptom_Symptom1`
    FOREIGN KEY (`med_rec_sym_sym_id`)
    REFERENCES `pokemon_center`.`Symptom` (`sym_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medical_Record_Symptom_Medical_Record1`
    FOREIGN KEY (`med_rec_sym_med_rec_id`)
    REFERENCES `pokemon_center`.`Medical_Record` (`med_rec_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon_center`.`Treatment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Treatment` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Treatment` (
  `tre_id` INT NOT NULL AUTO_INCREMENT,
  `tre_name` VARCHAR(75) NULL,
  `tre_description` VARCHAR(150) NULL,
  PRIMARY KEY (`tre_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon_center`.`Medical_Record_Treatment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pokemon_center`.`Medical_Record_Treatment` ;

CREATE TABLE IF NOT EXISTS `pokemon_center`.`Medical_Record_Treatment` (
  `med_rec_tre_id` INT NOT NULL AUTO_INCREMENT,
  `med_rec_tre_created_at` DATETIME NULL,
  `med_rec_tre_active` TINYINT NULL,
  `med_rec_medicine` VARCHAR(150) NULL,
  `med_rec_tre_tre_id` INT NOT NULL,
  `med_rec_tre_med_rec_id` INT NOT NULL,
  PRIMARY KEY (`med_rec_tre_id`),
  INDEX `fk_Medical_Record_Treatment_Treatment1_idx` (`med_rec_tre_tre_id` ASC) VISIBLE,
  INDEX `fk_Medical_Record_Treatment_Medical_Record1_idx` (`med_rec_tre_med_rec_id` ASC) VISIBLE,
  CONSTRAINT `fk_Medical_Record_Treatment_Treatment1`
    FOREIGN KEY (`med_rec_tre_tre_id`)
    REFERENCES `pokemon_center`.`Treatment` (`tre_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medical_Record_Treatment_Medical_Record1`
    FOREIGN KEY (`med_rec_tre_med_rec_id`)
    REFERENCES `pokemon_center`.`Medical_Record` (`med_rec_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
