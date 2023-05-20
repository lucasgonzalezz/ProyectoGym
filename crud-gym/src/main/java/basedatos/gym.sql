-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gym
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gym
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gym` ;
USE `gym` ;

-- -----------------------------------------------------
-- Table `gym`.`clase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym`.`clase` (
  `idClase` INT NOT NULL AUTO_INCREMENT,
  `nombreClase` VARCHAR(60) NOT NULL,
  `lugar` VARCHAR(60) NOT NULL,
  `tope` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idClase`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

INSERT INTO `clase` VALUES
 (1, 'Zumba', 'Sala 01', 25),
 (2, 'Pilates', 'Sala Especial 1', 50),
 (3, 'Punchimba', 'Exterior 1', 10);

-- -----------------------------------------------------
-- Table `gym`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombreCliente` VARCHAR(255) COLLATE 'utf8mb3_bin' NOT NULL,
  `apellidos` VARCHAR(255) COLLATE 'utf8mb3_bin' NOT NULL,
  `edad` INT NOT NULL,
  `altura` DOUBLE NOT NULL,
  `peso` DOUBLE NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;

INSERT INTO `cliente` VALUES
 (1, 'Maria', 'Fernandez Marco', 19, 1.65, 50.0),
 (2, 'Pepe', 'Angir Carmilo', 29, 1.75, 65.2),
 (3, 'Marcos', 'Angresola Rodriguez', 39, 1.89, 70.8),
 (4, 'Raquel', 'Munoz Esteve', 49, 1.80, 80.0),
 (5, 'Pepa', 'Gonzalez Rius', 59, 1.70, 72.2),
 (6, 'Jordi', 'Postigo Humedo', 9, 1.20, 38.0);

-- -----------------------------------------------------
-- Table `gym`.`ejercicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym`.`ejercicio` (
  `idEjercicio` INT NOT NULL AUTO_INCREMENT,
  `tipoMuscular` VARCHAR(255) NOT NULL,
  `nombreEjercicio` VARCHAR(255) COLLATE 'utf8mb3_bin' NOT NULL,
  `numeroSeries` INT NOT NULL,
  `numeroRepeticiones` INT NOT NULL,
  `cargaKg` INT NULL DEFAULT 0 NULL,
  PRIMARY KEY (`idEjercicio`))
ENGINE = InnoDB;

INSERT INTO `ejercicio` VALUES
 (1, 'Hombros','Press militar', 4, 8, 5),
 (2, 'Espalda', 'Dominadas', 5, 20, DEFAULT),
 (3, 'Espalda', 'Remo', 4, 10, 3),
 (4, 'Pectoral', 'Press banca', 6, 10, 20),
 (5, 'Cuádriceps', 'Sentadillas', 5, 15, 3),
 (6, 'Femorales', 'Peso muerto', 5, 10, 20),
 (7, 'Bíceps', 'Curl de bícps con barra Z', 5, 15, 10),
 (8, 'Tríceps', 'Press francés con barra Z', 5, 15, 10);
 
/*
-- -----------------------------------------------------
-- Table `gym`.`rutina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym`.`rutina` (
  `fk_idCliente` INT NOT NULL,
  `fk_idEjercicio` INT NOT NULL,
  PRIMARY KEY (`fk_idCliente`, `fk_idEjercicio`),
  INDEX `fk_cliente_has_ejercicio_ejercicio1_idx` (`fk_idEjercicio` ASC) VISIBLE,
  INDEX `fk_cliente_has_ejercicio_cliente_idx` (`fk_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_has_ejercicio_cliente`
    FOREIGN KEY (`fk_idCliente`)
    REFERENCES `gym`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_ejercicio_ejercicio1`
    FOREIGN KEY (`fk_idEjercicio`)
    REFERENCES `gym`.`ejercicio` (`idEjercicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
*/

-- -----------------------------------------------------
-- Table `gym`.`entrenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym`.`entrenador` (
  `idEntrenador` INT NOT NULL AUTO_INCREMENT,
  `nombreEntrenador` VARCHAR(60) NOT NULL,
  `apellidosEntrenador` VARCHAR(120) NOT NULL,
  `edad` VARCHAR(60) NOT NULL,
  `titulacion` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idEntrenador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

INSERT INTO `entrenador` VALUES
 (1, 'Maria', 'Fernandez Marco', 19, 'Entrenador Personal'),
 (2, 'Pepe', 'Angir Carmilo', 29, 'Magisterio'),
 (3, 'Marcos', 'Angresola Rodriguez', 39, 'Nada'),
 (4, 'Raquel', 'Munoz Esteve', 49, 'Entrenador Personal');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;