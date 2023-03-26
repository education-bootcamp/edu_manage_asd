DROP DATABASE edu_manage;
CREATE SCHEMA IF NOT EXISTS `edu_manage` DEFAULT CHARACTER SET utf8 ;
USE `edu_manage` ;

-- -----------------------------------------------------
-- Table `edu_manage`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edu_manage`.`student` (
    `student_id` VARCHAR(45) NOT NULL,
    `full_name` VARCHAR(45) NULL,
    `dob` DATE NOT NULL,
    `address` VARCHAR(45) NULL,
    PRIMARY KEY (`student_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `edu_manage`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edu_manage`.`teacher` (
    `teacher_code` VARCHAR(45) NOT NULL,
    `name` VARCHAR(45) NULL,
    `address` VARCHAR(45) NULL,
    `contact` VARCHAR(45) NULL,
    PRIMARY KEY (`teacher_code`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `edu_manage`.`program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edu_manage`.`program` (
    `program_code` VARCHAR(45) NOT NULL,
    `program_name` VARCHAR(45) NULL,
    `cost` DOUBLE NULL,
    `teacher_code` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`program_code`),
    CONSTRAINT `fk_program_teacher`
    FOREIGN KEY (`teacher_code`)
    REFERENCES `edu_manage`.`teacher` (`teacher_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `edu_manage`.`intake`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edu_manage`.`intake` (
    `intake_id` VARCHAR(45) NOT NULL,
    `intake_name` VARCHAR(45) NULL,
    `start_date` DATE NULL,
    `intake_completeness` TINYINT NULL,
    `program_code` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`intake_id`),
    CONSTRAINT `fk_intake_program1`
    FOREIGN KEY (`program_code`)
    REFERENCES `edu_manage`.`program` (`program_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `edu_manage`.`technology`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edu_manage`.`technology` (
    `tech_id` VARCHAR(45) NOT NULL,
    `name` VARCHAR(45) NULL,
    `program_code` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`tech_id`),
    CONSTRAINT `fk_technology_program1`
    FOREIGN KEY (`program_code`)
    REFERENCES `edu_manage`.`program` (`program_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `edu_manage`.`registration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edu_manage`.`registration` (
    `register_id` VARCHAR(45) NOT NULL,
    `register_date` DATE NULL,
    `payment_completeness` TINYINT NULL,
    `student_id` VARCHAR(45) NOT NULL,
    `intake_id` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`register_id`),
    CONSTRAINT `fk_registration_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `edu_manage`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_registration_intake1`
    FOREIGN KEY (`intake_id`)
    REFERENCES `edu_manage`.`intake` (`intake_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `edu_manage`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `edu_manage`.`user` (
    `email` VARCHAR(100) NOT NULL,
    `first_name` VARCHAR(45) NULL,
    `last_name` VARCHAR(45) NULL,
    `password` LONGBLOB NULL,
    PRIMARY KEY (`email`))
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
