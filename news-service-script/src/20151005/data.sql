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
  `topic` varchar(255) DEFAULT NULL,
  `publication_date` datetime DEFAULT NULL,
  `news_text` longtext,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_news_user1` (`user_id`),
  CONSTRAINT `fk_news_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.news: ~8 rows (приблизительно)
DELETE FROM `news`;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `topic`, `publication_date`, `news_text`, `user_id`) VALUES
	(1, 'In Boston speech, Obama to unveil executive', '2015-09-07 10:49:54', 'President Obama will sign an executive order Monday requiring federal contractors to offer employees up to seven paid sick days a year, a move that could benefit more than 300,000 workers, White House officials said.', 2),
	(2, 'Pope calls on Europe’s Catholics to take', '2015-08-07 10:50:59', 'Issuing a broad appeal to Europe’s Catholics, Pope Francis on Sunday called on “every” parish, religious community, monastery and sanctuary to take in one refugee family — an appeal that, if honored, would offer shelter to tens of thousands.', 4),
	(3, 'Rep. Jason Chaffetz launches bid for House speaker, shaking up GOP leadership race', '2015-01-05 11:34:23', 'The Republican chairman of a high-profile House committee on Sunday shook up the race to succeed outgoing Speaker John A. Boehner, launching a challenge to the heavy favorite, Majority Leader Kevin McCarthy.', 2),
	(4, 'Austerity campaign pays off as Portugal’s centre-right edges into new term', '2015-02-06 02:32:31', 'Portugal’s centre-right coalition government under Prime Minister Pedro Passos Coelho has won another four-year term.\r\nIn what was seen as a test of tough austerity measures, he’s the first leader in Europe to be re-elected after having imposed hardships on voters under international bailout deals.\r\nHowever, Passos Coelho has lost his overall parliamentary majority.\r\nSpeaking to supporters Portugal’s prime minister said he had already spoken with his coalition partner to organise as quickly as possible national meetings to formalise their coalition agreement.', 4),
	(5, 'Palmyra arch ‘destroyed’ by ISIL', '2014-10-03 17:22:12', 'Islamic militants have reportedly destroyed the Arch of Triumph which is a major monument in the 2,000-year-old Roman city of Palmyra.', 4),
	(6, 'Typhoon Mujigae rips through Southern China', '2013-10-05 11:06:44', 'A powerful typhoon has battered southern China, leaving four dead and sixteen others missing.\r\n\r\nTyphoon Mujigae made landfall near the coastal city of Zhanjiang on Sunday afternoon and has mainly affected the Guangdong and Guanxi provinces.\r\n\r\nWinds of up to 180 km/h left a trail of destruction, and authorities issued the highest ‘red alert’ emergency response.\r\nSome 117 fishermen were rescued according to local maritime authorities, after being caught at sea in the storm.\r\n\r\nThe typhoon came as millions of Chinese took holidays to celebrate the October 1st national day.\r\n\r\nMugijae marks the 22nd typhoon to hit China in the last year.', 6),
	(7, 'Russian air strike hits terrorist training camp in Syria, say defence officials', '2015-03-17 22:45:13', 'Russia says it’s struck ten more ISIL targets in Syria, after vowing to step up its aerial bombardment', 6),
	(8, 'Brussels refugee camp cleared', '2015-10-05 11:09:29', 'A refugee camp in Brussels is being cleared after the volunteers who ran it pulled their support.', 4);
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

-- Дамп данных таблицы news_service_2.news_tag: ~18 rows (приблизительно)
DELETE FROM `news_tag`;
/*!40000 ALTER TABLE `news_tag` DISABLE KEYS */;
INSERT INTO `news_tag` (`news_id`, `tag_id`) VALUES
	(1, 1),
	(1, 8),
	(2, 4),
	(2, 2),
	(2, 5),
	(2, 6),
	(3, 6),
	(4, 3),
	(4, 7),
	(5, 5),
	(5, 2),
	(6, 4),
	(6, 8),
	(6, 6),
	(7, 8),
	(8, 3),
	(8, 8),
	(8, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.tag: ~8 rows (приблизительно)
DELETE FROM `tag`;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` (`id`, `tag_name`) VALUES
	(1, 'politics'),
	(2, 'sport'),
	(3, 'people'),
	(4, 'economy'),
	(5, 'technology'),
	(6, 'nature'),
	(7, 'humor'),
	(8, 'events');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;


-- Дамп структуры для таблица news_service_2.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_user_user_detail1` (`user_detail_id`),
  CONSTRAINT `fk_user_user_detail1` FOREIGN KEY (`user_detail_id`) REFERENCES `user_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.user: ~6 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `password`, `user_detail_id`) VALUES
	(1, 'user@user', '$2a$10$5kuUFbyNvY2WD1LndmhuIexPzzI2X0Xy08ObPZLlIpShkKXyPe5iC', 1),
	(2, 'root@root', '$2a$10$zkxN7ESwO05iZlj29KI0SOJ3HDv3z3W9SYKgGsl37kpXz50M2dR.K', 2),
	(3, 'yui123@mail.ru', '$2a$10$8ka/21nFaIt85KQbnEa/EeKOseIUqTEoDblOhBFO2/U7THzNEkJgu', 3),
	(4, 'udebman@gmail.com', '$2a$10$fzrThGmSe3rOmudECcABFOIKeF3ngufb65loNn03d4ddWLyqIkWry', 4),
	(5, 'operator@rbcmail.ru', '$2a$10$33RjZ2IYAOovHl9TwmdNVuZhOXHBkl70M7mkO1mLVCIVVTfJGhIl2', 5),
	(6, 'moder@moder', '$2a$10$suo0KFSW29koInWYD1RvD.GJlWZVHI1Cz.F2Q8lYlJJ9SDMXZccay', 6),
	(7, '1212@shashj', '$2a$10$hyey8BdWHft7csDCuxuxpuOd5syNiqr47FOEprf.U1WzLTAdHd8Pi', 7),
	(8, '222@222rer', '$2a$10$3n0DxW58i44CNu/2LllZF.l6Bj3g8LBi/ogYL6zn8YIfiGNaDUH7i', 8);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры для таблица news_service_2.user_detail
CREATE TABLE IF NOT EXISTS `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `cellphone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service_2.user_detail: ~6 rows (приблизительно)
DELETE FROM `user_detail`;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `cellphone`) VALUES
	(1, 'Petiya', 'Sidorov', '12345323'),
	(2, 'Admin', 'Petrovich', '19292323'),
	(3, 'Petra', 'Tolstova', '26323278'),
	(4, 'Troyan', 'Petrov', '64747333'),
	(5, 'Jon', 'Higgens', '72783823'),
	(6, 'Moderator', 'Moder', '1231234'),
	(7, 'assasa', 'sasa', '1211'),
	(8, 'sds', 'dsds', '3232');
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

-- Дамп данных таблицы news_service_2.user_role: ~6 rows (приблизительно)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`role_id`, `user_id`) VALUES
	(3, 1),
	(1, 2),
	(3, 3),
	(2, 4),
	(2, 5),
	(2, 6),
	(3, 7),
	(3, 8);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
