CREATE SCHEMA IF NOT EXISTS `news_service_2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `news_service_2` ;news_service

-- -----------------------------------------------------
-- Table `news_service_2`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_service_2`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `email` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = Indaoh_testnoDB;


-- -----------------------------------------------------
-- Table `news_service_2`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_service_2`.`news` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `topic` VARCHAR(45) NULL COMMENT '',
  `publication_date` DATETIME(6) NULL COMMENT '',
  `news_text` LONGTEXT NULL COMMENT '',
  `users_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`, `users_id`)  COMMENT '',
  INDEX `fk_news_users1_idx` (`users_id` ASC)  COMMENT '',
  CONSTRAINT `fk_news_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `news_service_2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news_service_2`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_service_2`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `role_name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news_service_2`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_service_2`.`user_role` (
  `users_id` INT NOT NULL COMMENT '',
  `roles_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`users_id`, `roles_id`)  COMMENT '',
  INDEX `fk_users_has_roles_roles1_idx` (`roles_id` ASC)  COMMENT '',
  INDEX `fk_users_has_roles_users1_idx` (`users_id` ASC)  COMMENT '',
  CONSTRAINT `fk_users_has_roles_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `news_service_2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_roles_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `news_service_2`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news_service_2`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_service_2`.`tag` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `tag_name` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news_service_2`.`news_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_service_2`.`news_tag` (
  `news_id` INT NOT NULL COMMENT '',
  `tag_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`news_id`, `tag_id`)  COMMENT '',
  INDEX `fk_news_has_tag_tag1_idx` (`tag_id` ASC)  COMMENT '',
  INDEX `fk_news_has_tag_news1_idx` (`news_id` ASC)  COMMENT '',
  CONSTRAINT `fk_news_has_tag_news1`
    FOREIGN KEY (`news_id`)
    REFERENCES `news_service_2`.`news` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_news_has_tag_tag1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `news_service_2`.`tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news_service_2`.`user_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_service_2`.`user_details` (
  `first_name` VARCHAR(45) NULL COMMENT '',
  `last_name` VARCHAR(45) NULL COMMENT '',
  `phone` VARCHAR(45) NULL COMMENT '',
  `user_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`user_id`)  COMMENT '',
  CONSTRAINT `fk_user_details_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `news_service_2`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
