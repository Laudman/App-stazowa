-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Wersja serwera:               5.7.9-log - MySQL Community Server (GPL)
-- Serwer OS:                    Win64
-- HeidiSQL Wersja:              9.3.0.5024
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Zrzut struktury bazy danych appdb
CREATE DATABASE IF NOT EXISTS `appdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `appdb`;


-- Zrzut struktury tabela appdb.answers
CREATE TABLE IF NOT EXISTS `answers` (
  `id_answer` int(11) NOT NULL AUTO_INCREMENT,
  `id_task` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `text_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_answer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Zrzut struktury tabela appdb.flaggeds
CREATE TABLE IF NOT EXISTS `flaggeds` (
  `id_user` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `flag` bit(1) NOT NULL,
  `id_answer` int(11) NOT NULL,
  `id_task` int(11) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Zrzut struktury tabela appdb.notifications
CREATE TABLE IF NOT EXISTS `notifications` (
  `id_notification` int(11) NOT NULL AUTO_INCREMENT,
  `id_task` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `notificat` bit(1) NOT NULL,
  PRIMARY KEY (`id_notification`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Zrzut struktury tabela appdb.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Zrzut struktury tabela appdb.tags
CREATE TABLE IF NOT EXISTS `tags` (
  `id_tag` int(11) NOT NULL AUTO_INCREMENT,
  `id_task` int(11) NOT NULL,
  `tag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Zrzut struktury tabela appdb.tasks
CREATE TABLE IF NOT EXISTS `tasks` (
  `id_task` int(11) NOT NULL AUTO_INCREMENT,
  `amount_answer` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `text` varchar(255) DEFAULT NULL,
  `type_of_job` varchar(255) DEFAULT NULL,
  `type_of_question` varchar(255) DEFAULT NULL,
  `type_of_speak` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_task`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Zrzut struktury tabela appdb.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Zrzut struktury tabela appdb.user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` int(6) NOT NULL,
  `role_id` int(6) NOT NULL,
  UNIQUE KEY `UK_g1uebn6mqk9qiaw45vnacmyo2` (`user_id`),
  KEY `user` (`user_id`),
  KEY `role` (`role_id`),
  CONSTRAINT `FK_5q4rc4fh1on6567qk69uesvyf` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FK_g1uebn6mqk9qiaw45vnacmyo2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Zrzut struktury tabela appdb.votes
CREATE TABLE IF NOT EXISTS `votes` (
  `id_vote` int(11) NOT NULL AUTO_INCREMENT,
  `id_answer` int(11) NOT NULL,
  `id_task` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `vote` int(11) NOT NULL,
  PRIMARY KEY (`id_vote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
