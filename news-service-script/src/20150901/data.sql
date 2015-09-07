-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.25-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных news_service_2
CREATE DATABASE IF NOT EXISTS `news_service_2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `news_service_2`;


-- Дамп структуры для таблица news_service_2.news
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(45) DEFAULT NULL,
  `publication_date` datetime DEFAULT NULL,
  `news_text` longtext,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_news_user1` (`user_id`),
  CONSTRAINT `fk_news_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.news: ~2 rows (приблизительно)
DELETE FROM `news`;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `topic`, `publication_date`, `news_text`, `user_id`) VALUES
	(1, 'In Boston speech, Obama to unveil executive', '2015-09-07 10:49:54', 'President Obama will sign an executive order Monday requiring federal contractors to offer employees up to seven paid sick days a year, a move that could benefit more than 300,000 workers, White House officials said.', 2),
	(2, 'Pope calls on Europe’s Catholics to take', '2015-08-07 10:50:59', 'MUNICH — Issuing a broad appeal to Europe’s Catholics, Pope Francis on Sunday called on “every” parish, religious community, monastery and sanctuary to take in one refugee family — an appeal that, if honored, would offer shelter to tens of thousands.', 1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


-- Дамп структуры для таблица news_service_2.news_tag
CREATE TABLE IF NOT EXISTS `news_tag` (
  `news_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  KEY `fk_news_has_tag_news1` (`news_id`),
  KEY `fk_news_has_tag_tag1` (`tag_id`),
  CONSTRAINT `fk_news_has_tag_news1` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_news_has_tag_tag1` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.news_tag: ~0 rows (приблизительно)
DELETE FROM `news_tag`;
/*!40000 ALTER TABLE `news_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `news_tag` ENABLE KEYS */;


-- Дамп структуры для таблица news_service_2.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.role: ~3 rows (приблизительно)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `role_name`) VALUES
	(1, 'admin'),
	(2, 'moderator'),
	(3, 'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Дамп структуры для таблица news_service_2.tag
CREATE TABLE IF NOT EXISTS `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.tag: ~0 rows (приблизительно)
DELETE FROM `tag`;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;


-- Дамп структуры для таблица news_service_2.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `user_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_user_detail1` (`user_detail_id`),
  CONSTRAINT `fk_user_user_detail1` FOREIGN KEY (`user_detail_id`) REFERENCES `user_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.user: ~2 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `password`, `user_detail_id`) VALUES
	(1, 'user@user', 'user', 1),
	(2, 'root@root', 'root', 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры для таблица news_service_2.user_detail
CREATE TABLE IF NOT EXISTS `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.user_detail: ~2 rows (приблизительно)
DELETE FROM `user_detail`;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `cellphone`) VALUES
	(1, 'Petiya', 'Sidorov', '12345'),
	(2, 'Admin', 'Petrovich', '19292');
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;


-- Дамп структуры для таблица news_service_2.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `fk_role_has_user_role1` (`role_id`),
  KEY `fk_role_has_user_user1` (`user_id`),
  CONSTRAINT `fk_role_has_user_role1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.user_role: ~2 rows (приблизительно)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`role_id`, `user_id`) VALUES
	(3, 1),
	(1, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
