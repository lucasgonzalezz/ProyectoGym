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
 (6, 'Jordi', 'Postigo Humedo', 19, 1.20, 38.0),
 (7, 'Lola', 'Gonzalez Ruiz', 88, 1.60, 89.0),
 (8, 'Fer', 'Lopez Marin', 75, 1.10, 110.5);

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
 
-- -----------------------------------------------------
-- Table `gym`.`entrenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym`.`entrenador` (
  `idEntrenador` INT NOT NULL AUTO_INCREMENT,
  `nombreEntrenador` VARCHAR(60) NOT NULL,
  `apellidosEntrenador` VARCHAR(120) NOT NULL,
  `edad` INT NOT NULL,
  `titulacion` VARCHAR(60) NOT NULL,
  `contraseña` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idEntrenador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

INSERT INTO `entrenador` VALUES
(1, 'Juan', 'González', 34, 'Educación Física', 'pass123'),
(2, 'María', 'López', 28, 'Máster Entrenamiento', 'pass'),
(3, 'Pedro', 'Martínez', 42, 'Ciencias Deporte', '12345'),
(4, 'Laura', 'García', 31, 'Fisiología', 'passw123'),
(5, 'Carlos', 'Sánchez', 26, 'Educación Física', 'sec123'),
(6, 'Ana', 'Rodríguez', 35, 'Entr. Personal', 'pass1234'),
(7, 'Javier', 'Fernández', 29, 'Ciencias Deporte', 'qwerty'),
(8, 'Sara', 'Pérez', 33, 'Entr. Personal', 'abc123');
 
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
 (1, 'Zumba', 'Sala Z01', 25),
 (2, 'Pilates', 'Exterior P01', 50),
 (3, 'Body Combat', 'Sala B01', 15),
 (4, 'Body Combat', 'Sala B02', 10),
 (5, 'Body Pump', 'Sala B03', 25),
 (6, 'Spinning', 'Sala S01', 20),
 (7, 'Xcore', 'Exterior X01', 10),
 (8, 'CrossFit', 'Sala C01', 33);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;