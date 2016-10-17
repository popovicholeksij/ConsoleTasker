-- --------------------------------------------------------
-- Сервер:                       127.0.0.1
-- Версія сервера:               5.6.30-0ubuntu0.14.04.1 - (Ubuntu)
-- ОС сервера:                   debian-linux-gnu
-- HeidiSQL Версія:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for Tasker
CREATE DATABASE IF NOT EXISTS `Tasker` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `Tasker`;


-- Dumping structure for таблиця Tasker.priority
CREATE TABLE IF NOT EXISTS `priority` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `priority_name` varchar(15) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дані для експорту не вибрані


-- Dumping structure for таблиця Tasker.status
CREATE TABLE IF NOT EXISTS `status` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(15) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дані для експорту не вибрані


-- Dumping structure for таблиця Tasker.task
CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `task_name` varchar(60) COLLATE utf8_bin NOT NULL,
  `goal_time` date NOT NULL,
  `priority` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_task_priority` (`priority`),
  KEY `FK_task_status` (`status`),
  CONSTRAINT `FK_task_priority` FOREIGN KEY (`priority`) REFERENCES `priority` (`id`),
  CONSTRAINT `FK_task_status` FOREIGN KEY (`status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Дані для експорту не вибрані
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
