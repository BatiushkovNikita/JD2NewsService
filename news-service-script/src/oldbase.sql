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

-- Дамп структуры базы данных news_service
CREATE DATABASE IF NOT EXISTS `news_service` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `news_service`;


-- Дамп структуры для таблица news_service.news
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) DEFAULT NULL,
  `publication_date` datetime DEFAULT NULL,
  `news_text` text,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service.news: ~9 rows (приблизительно)
DELETE FROM `news`;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `topic`, `publication_date`, `news_text`, `user_id`) VALUES
	(1, 'topic1', '2015-12-08 00:00:00', 'News text1', 1),
	(2, 'topic2', '2015-12-08 00:00:00', 'News text2', 2),
	(3, 'topic3', '2015-12-08 00:00:00', 'News text3', 2),
	(4, 'topic4', '2015-12-08 00:00:00', 'News text4', 5),
	(5, 'dsds', '2015-08-17 09:56:48', 'dsds', 1),
	(6, 'wewwwwwwwwwwwwwww', '2015-08-17 10:06:38', 'ewewe', 1),
	(7, 'ZZZZZZZZZZZZZZZZZZZZZ', '2015-08-18 04:39:34', 'ZZZZZZZZZZZZZZZZZZZ', 1),
	(8, 'ewwe', '2015-08-18 05:02:25', 'wewew', 1),
	(9, 'ds', '2015-09-08 02:35:42', 'ds', 1);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


-- Дамп структуры для таблица news_service.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service.roles: ~3 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `role_name`) VALUES
	(1, 'admin'),
	(2, 'moderator'),
	(3, 'user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Дамп структуры для таблица news_service.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service.users: ~20 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `email`, `password`, `first_name`, `last_name`) VALUES
	(1, 'aaa@gmail.com', '1a1dc91c907325c69271ddf0c944bc72', 'Sergey', 'Katabin'),
	(2, 'bbb@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 'Nikita', 'Petrov'),
	(3, 'ccc@gmail.com', '202cb962ac59075b964b07152d234b70', 'Ivan', 'Ivanov'),
	(4, 'ggg@gmail.com', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'Irina', 'Smernova'),
	(5, 'fff@gmail.com', '827ccb0eea8a706c4c34a16891f84e7b', 'Antom', 'Kryglo'),
	(6, '123@123.com', '12345', 'dsds', 'dsds'),
	(7, '123@123.com', '12345', 'ewew', 'ewew'),
	(8, '123@123.com', '12345', '34343', '434'),
	(9, '123@123.com', '12345', '4343', '4334'),
	(10, 'ggg@gmail.com', 'qwerty', 'ewewe', 'ewewe'),
	(11, 'ggg@gmail.com', 'qwerty', 'ewewe', 'ewewe'),
	(12, 'ggg@gmail.com', 'qwerty', 'ewewe', 'ewewe'),
	(13, 'ggg@gmail.com', 'qwerty', 'ewewe', 'ewewe'),
	(14, 'ggg@gmail.com', 'qwerty', 'ewewe', 'ewewe'),
	(15, 'ggg@gmail.com', 'qwerty', 'ewewe', 'ewewe'),
	(16, '123@123.com', '827ccb0eea8a706c4c34a16891f84e7b', '21212', '12121'),
	(17, '123@123.com', '827ccb0eea8a706c4c34a16891f84e7b', '12121', '212121'),
	(18, '123@123.com', '827ccb0eea8a706c4c34a16891f84e7b', '1111111111111', '21212111111111'),
	(19, '123@123.com', '827ccb0eea8a706c4c34a16891f84e7b', 'ewew', 'ewew'),
	(20, 'AAAA', 'DDDD', 'DDDDD', 'DSDSSD');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Дамп структуры для таблица news_service.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  KEY `role_id` (`role_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_service.users_roles: ~4 rows (приблизительно)
DELETE FROM `users_roles`;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`role_id`, `user_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 3),
	(3, 4);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
