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
 (6, 'Jordi', 'Postigo Humedo', 9, 1.20, 38.0);

-- -----------------------------------------------------
-- Table `gym`.`ejercicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gym`.`ejercicio` (
  `idEjercicio` INT NOT NULL AUTO_INCREMENT,
  `nombreEjercicio` VARCHAR(255) COLLATE 'utf8mb3_bin' NOT NULL,
  `numeroSeries` INT NOT NULL,
  `numeroRepeticiones` INT NOT NULL,
  `cargaKg` INT NULL DEFAULT 0 NULL,
  PRIMARY KEY (`idEjercicio`))
ENGINE = InnoDB;

INSERT INTO `ejercicio` VALUES
 (1, 'Sentadillas con barra', 4, 8, 5),
 (2, 'Prensa máquina', 4, 8, 5),
 (3, 'Extensión gemelos', 4, 10, 5),
 (4, 'Press banco', 4, 8, 5),
 (5, 'Peso muerto rumano', 4, 10, 5),
 (6, 'Elevacion piernas', 4, 20, default),
 (7, 'Elevaciones laterales', 4, 8, 2),
 (8, 'Fondos tríceps', 4, 10, 4);

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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;