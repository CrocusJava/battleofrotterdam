-- phpMyAdmin SQL Dump
-- version 4.0.6deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 23, 2013 at 07:57 PM
-- Server version: 5.5.34-0ubuntu0.13.10.1
-- PHP Version: 5.5.3-1ubuntu2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `battledb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Address`
--

CREATE TABLE IF NOT EXISTS `Address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `town` varchar(45) NOT NULL,
  `postcode` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `houseNumber` varchar(45) NOT NULL,
  `apartment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Address`
--

INSERT INTO `Address` (`id`, `town`, `postcode`, `street`, `houseNumber`, `apartment`) VALUES
(1, 'town 10', 'postcode 15', 'street 20', 'houseNumber 30', 'apartment 40');

-- --------------------------------------------------------

--
-- Table structure for table `Comment`
--

CREATE TABLE IF NOT EXISTS `Comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentText` varchar(45) NOT NULL,
  `commentDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `project_id` (`project_id`),
  KEY `photo_id` (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Competition`
--

CREATE TABLE IF NOT EXISTS `Competition` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` mediumtext NOT NULL,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  `registerDeadline` date DEFAULT NULL,
  `type_id` bigint(20) NOT NULL,
  `winner_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `winner_id` (`winner_id`),
  KEY `Competition_ibfk_2` (`type_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Competition`
--

INSERT INTO `Competition` (`id`, `name`, `description`, `dateStart`, `dateEnd`, `registerDeadline`, `type_id`, `winner_id`) VALUES
(1, 'Year Competition Name', 'description of Year Competition', '2013-12-01', '2014-12-01', '2014-01-01', 1, NULL),
(2, 'First Month Competition Name', 'description of First Month Competition', '2013-12-01', '2014-01-01', '2013-12-10', 2, NULL),
(3, 'Second Month Competition Name', 'description of Second Month Competition', '2014-01-01', '2014-02-01', '2014-01-10', 2, NULL),
(4, 'Third Month Competition Name', 'description of Third Month Competition', '2014-02-01', '2014-03-01', '2014-02-10', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `CompetitionType`
--

CREATE TABLE IF NOT EXISTS `CompetitionType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `CompetitionType`
--

INSERT INTO `CompetitionType` (`id`, `name`) VALUES
(1, 'year'),
(2, 'month');

-- --------------------------------------------------------

--
-- Table structure for table `Photo`
--

CREATE TABLE IF NOT EXISTS `Photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(45) NOT NULL,
  `loadDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` mediumtext,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Project`
--

CREATE TABLE IF NOT EXISTS `Project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` mediumtext NOT NULL,
  `creationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint(20) NOT NULL,
  `competition_id` bigint(20) NOT NULL,
  `approved` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `competition_id` (`competition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE IF NOT EXISTS `Role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'user'),
(3, 'guest');

-- --------------------------------------------------------

--
-- Table structure for table `Text`
--

CREATE TABLE IF NOT EXISTS `Text` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `keyval` bigint(20) NOT NULL,
  `valueEn` longtext NOT NULL,
  `valueNl` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `keyval` (`keyval`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `Text`
--

INSERT INTO `Text` (`id`, `keyval`, `valueEn`, `valueNl`) VALUES
(1, 100, 'Your new password will be sent to your email', 'Uw nieuwe wachtwoord zal naar uw e-mail worden verzonden'),
(2, 200, 'Please check your email to complete your registration', 'Controleer uw e-mail om uw registratie te voltooien'),
(3, 300, 'Thank you! Now you can login and try create your first project', 'Dank je wel! Nu kunt u inloggen en probeer maak uw eerste project'),
(4, 310, 'Something WRONG. Please check your email again', 'Iets mis. Controleer uw e-mail opnieuw'),
(5, 500, 'Some general information about the site', 'Wat algemene informatie over de site'),
(6, 510, 'Some description of the video', 'Enkele beschrijving van de video'),
(7, 210, 'Dear, user thank you for registration on the Battle of Rotterdam site, please click on the link to complete your registration','Geachte, gebruiker bedankt voor registratie op de Battle of Rotterdam site, klik op de link om uw registratie te voltooien'),
(8, 110,'Your login: ','Uw loginnaam: '),
(9, 111,'Your new password: ','Uw nieuwe wachtwoord: ');

-- --------------------------------------------------------

--
-- Table structure for table `URL`
--

CREATE TABLE IF NOT EXISTS `URL` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `keyval` bigint(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `value` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `keyval` (`keyval`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `URL`
--

INSERT INTO `URL` (`id`, `keyval`, `name`, `value`) VALUES
(1, 100, 'Name of Battle video url', 'Value of Battle video url'),
(2, 110, 'Name of Link1 on Home-page', 'Value of Link1 on Home-page'),
(3, 120, 'Name of Link2 on Home-page', 'Value of Link2 on Home-page'),
(4, 130, 'Name of Link3 on Home-page', 'Value of Link3 on Home-page'),
(5, 140, 'Name of Link4 on Home-page', 'Value of Link4 on Home-page');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `middlename` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `photoPath` varchar(65) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `commentAble` tinyint(1) NOT NULL DEFAULT '0',
  `active` tinyint(1) NOT NULL DEFAULT '0',
  `approveregistration` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `address_id` (`address_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`id`, `firstname`, `middlename`, `lastname`, `login`, `password`, `photoPath`, `email`, `phone`, `birthday`, `address_id`, `role_id`, `commentAble`, `active`, `approveregistration`) VALUES
(1, 'Test', 'Test', 'Test', 'test', '098f6bcd4621d373cade4e832627b4f6', 'path', 'test@gmail.com', '0501010101', '1960-01-01', 1, 2, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Voice`
--

CREATE TABLE IF NOT EXISTS `Voice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `voiceDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Comment`
--
ALTER TABLE `Comment`
  ADD CONSTRAINT `Comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  ADD CONSTRAINT `Comment_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `Project` (`id`),
  ADD CONSTRAINT `Comment_ibfk_3` FOREIGN KEY (`photo_id`) REFERENCES `Photo` (`id`);

--
-- Constraints for table `Competition`
--
ALTER TABLE `Competition`
  ADD CONSTRAINT `Competition_ibfk_1` FOREIGN KEY (`winner_id`) REFERENCES `User` (`id`),
  ADD CONSTRAINT `Competition_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `CompetitionType` (`id`);

--
-- Constraints for table `Photo`
--
ALTER TABLE `Photo`
  ADD CONSTRAINT `Photo_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `Project` (`id`);

--
-- Constraints for table `Project`
--
ALTER TABLE `Project`
  ADD CONSTRAINT `Project_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  ADD CONSTRAINT `Project_ibfk_2` FOREIGN KEY (`competition_id`) REFERENCES `Competition` (`id`);

--
-- Constraints for table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `User_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `Role` (`id`),
  ADD CONSTRAINT `User_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `Address` (`id`);

--
-- Constraints for table `Voice`
--
ALTER TABLE `Voice`
  ADD CONSTRAINT `Voice_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  ADD CONSTRAINT `Voice_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `Project` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
