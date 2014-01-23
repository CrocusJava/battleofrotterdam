﻿-- phpMyAdmin SQL Dump
-- version 4.0.6deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 23, 2014 at 01:04 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=53 ;

--
-- Dumping data for table `Address`
--

INSERT INTO `Address` (`id`, `town`, `postcode`, `street`, `houseNumber`, `apartment`) VALUES
(1, 'town 10', 'postcode 15', 'street 20', 'houseNumber 30', 'apartment 40'),
(2, 'towntest', '080808', 'streettest', '5', NULL),
(28, 'test100', 'test100', 'test100', '43', NULL),
(29, '', '', '', '', NULL),
(30, 'test100', 'test100500', 'test100500', '43', NULL),
(31, 'test55', 'test55', 'test55', '32', NULL),
(32, 'ss', '23232', 'ss', '23s', NULL),
(33, 'rotterdam', '13', 'dont know', '13', NULL),
(34, 'mmm', '12', 'mmm', '12', NULL),
(35, 'mmm', '12', 'mmm', '12', NULL),
(41, 'Ð¹Ñ?Ñ?Ð¹Ðº', '124123', 'Ð¹Ñ?Ñ?Ð¹Ðº', '1234', NULL),
(42, 'mmm', '12', 'mmm', '12', NULL),
(43, 'mmm', '12', 'mmm', '12', NULL),
(44, 'm', '12', 'm', '12', NULL),
(45, 'Rotterdam', '3021', 'Nieuwe Binnenweg', '295A', NULL),
(46, 'Rotterdam', '3021', 'Nieuwe Binnenweg', '295A', NULL),
(47, 'Rotterdam', '3021', 'Nieuwe Binnenweg', '295A', NULL),
(48, 'Rotterdam', '3021', 'Nieuwe Binnenweg', '295A', NULL),
(49, 'Rotterdam', '3021', 'Nieuwe Binnenweg', '295A', NULL),
(50, 'Rotterdam', '3021', 'Nieuwe Binnenweg', '295A', NULL),
(51, 'Rotterdam', '3002', 'Wilbetoord', '43', NULL),
(52, 'mmm', '12', 'mmm', '12', NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `Comment`
--

INSERT INTO `Comment` (`id`, `commentText`, `commentDate`, `user_id`, `project_id`, `photo_id`) VALUES
(1, 'Lets go!', '2014-01-01 16:00:00', 11, 1, 1),
(2, 'Do it!', '2014-01-01 16:00:00', 11, 2, 2),
(3, 'It will be something... :)', '2014-01-03 16:00:00', 12, 3, 3),
(4, 'Hello!!!!!!!!!!!!', '2014-01-03 16:00:00', 12, 4, 4),
(5, 'Nice try!', '2014-01-04 16:00:00', 13, 5, 5),
(6, 'I hope it is possible...', '2014-01-05 16:00:00', 14, 6, 6),
(7, 'blabla111', '2014-01-22 18:27:22', 1, 2, 5);

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
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `type_id` (`type_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Competition`
--

INSERT INTO `Competition` (`id`, `name`, `description`, `dateStart`, `dateEnd`, `registerDeadline`, `type_id`, `user_id`) VALUES
(1, 'Year Competition Name', 'description of Year Competition', '2013-12-01', '2014-12-01', '2014-11-01', 1, NULL),
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
-- Table structure for table `News`
--

CREATE TABLE IF NOT EXISTS `News` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `keyval` bigint(20) NOT NULL,
  `photoPath` varchar(65) NOT NULL,
  `loadDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `text_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `keyval` (`keyval`),
  KEY `text_id` (`text_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `News`
--

INSERT INTO `News` (`id`, `keyval`, `photoPath`, `loadDate`, `text_id`) VALUES
(1, 10, 'img/news1.jpg', '2014-01-15 08:00:00', 39),
(2, 20, 'img/news2.jpg', '2014-01-16 08:00:00', 40),
(3, 30, 'img/news3.jpg', '2014-01-17 08:00:00', 41),
(4, 40, '', '0000-00-00 00:00:00', 42),
(5, 50, '', '0000-00-00 00:00:00', 43),
(6, 60, '', '0000-00-00 00:00:00', 44),
(7, 70, '', '0000-00-00 00:00:00', 45),
(8, 80, '', '0000-00-00 00:00:00', 60),
(9, 90, '', '0000-00-00 00:00:00', 61);

-- --------------------------------------------------------

--
-- Table structure for table `Photo`
--

CREATE TABLE IF NOT EXISTS `Photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(300) NOT NULL,
  `loadDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` mediumtext,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `Photo`
--

INSERT INTO `Photo` (`id`, `path`, `loadDate`, `description`, `project_id`) VALUES
(1, 'img/remont1.jpg', '2014-01-01 16:00:00', 'description of Rays_month_project_photo', 1),
(2, 'img/remont11.jpg', '2014-01-01 16:00:00', 'description of Rays_year_project_photo', 2),
(3, 'img/remont3.jpg', '2014-01-03 16:00:00', 'description of Joes month project', 3),
(4, 'img/remont5.jpg', '2014-01-03 16:00:00', 'description of JoesJoes_year_project_photo', 4),
(5, 'img/remont13.jpg', '2014-01-04 16:00:00', 'description of Jennys_year_project_photo', 5),
(6, 'img/remont14.jpg', '2014-01-05 16:00:00', 'description of Lupes_year_project_photo', 6),
(7, 'img/remont8.jpg', '2014-01-06 08:00:00', 'description of Rays_month_project_photo', 1),
(8, 'img/remont12.jpg', '2014-01-07 08:00:00', 'description of Rays_year_project_photo', 2),
(9, 'img/remont2.jpg', '2014-01-08 08:00:00', 'description of Joes month project', 3),
(10, 'img/remont4.jpg', '2014-01-09 08:00:00', 'description of JoesJoes_year_project_photo', 4),
(11, 'img/remont9.jpg', '2014-01-10 08:00:00', 'description of Jennys_year_project_photo', 5),
(12, 'img/remont10.jpg', '2014-01-11 08:00:00', 'description of Lupes_year_project_photo', 6),
(13, 'img/remont15.jpg', '2014-01-11 08:00:00', 'description of Rays_year_project_photo', 2),
(14, 'img/remont16.jpg', '2014-01-12 08:00:00', 'description of Joes month project', 3),
(15, 'img/remont17.jpg', '2014-01-13 08:00:00', 'description of JoesJoes_year_project_photo', 4),
(16, 'img/remont18.jpg', '2014-01-14 08:00:00', 'description of Jennys_year_project_photo', 5),
(17, 'img/remont19.gif', '2014-01-15 08:00:00', 'description of Lupes_year_project_photo', 6),
(18, 'controller?command=getphoto&photoname=photo114year.jpg', '2014-01-18 18:12:38', 'photo114year.jpg', 2),
(19, 'controller?command=getphoto&photoname=photo115year.jpg', '2014-01-18 18:26:00', 'photo115year.jpg', 2),
(21, 'controller?command=getphoto&photoname=photo117year.jpg', '2014-01-19 21:34:45', 'photo117year.jpg', 2),
(22, 'controller?command=getphoto&photoname=photo117year.jpg', '2014-01-19 21:44:39', 'photo117year.jpg', 2),
(23, 'controller?command=getphoto&photoname=photo118year.jpg', '2014-01-19 21:45:15', 'photo118year.jpg', 2),
(24, 'controller?command=getphoto&photoname=photo119year.jpg', '2014-01-19 21:45:42', 'photo119year.jpg', 2);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `Project`
--

INSERT INTO `Project` (`id`, `name`, `description`, `creationDate`, `user_id`, `competition_id`, `approved`) VALUES
(1, 'Rays month project', 'description of Rays month project', '2014-01-01 16:00:00', 11, 3, 1),
(2, 'Rays year project', 'description of Rays year project', '2014-01-01 16:00:00', 11, 1, 1),
(3, 'Joes month project', 'description of Joes month project', '2014-01-03 16:00:00', 12, 3, 1),
(4, 'Joes year project', 'description of Joes year project', '2014-01-03 16:00:00', 12, 1, 1),
(5, 'Jennys year project', 'description of Jennys year project', '2014-01-04 16:00:00', 13, 1, 1),
(6, 'Lupes year project', 'description of Lupes year project', '2014-01-05 16:00:00', 14, 1, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=62 ;

--
-- Dumping data for table `Text`
--

INSERT INTO `Text` (`id`, `keyval`, `valueEn`, `valueNl`) VALUES
(1, 100, 'Your new password will be sent to your email', 'Uw nieuwe wachtwoord zal naar uw e-mail worden verzonden'),
(2, 200, 'Please check your email to complete your registration', 'Controleer uw e-mail om uw registratie te voltooien'),
(3, 300, 'Thank you! Now you can login and try create your first project', 'Dank je wel! Nu kunt u inloggen en probeer maak uw eerste project'),
(4, 310, 'Something WRONG. Please check your email again', 'Iets mis. Controleer uw e-mail opnieuw'),
(5, 500, 'Welcome to the website of the Battle of Rotterdam. On this website you can upload pictures of the renovation and you could win a cash prize!\r\nAfter you have created an account, you can upload photos and view the current position on the ranking page.\r\nShould you have any questions, please look first at the FAQ page.\r\nUnder "Links" you will find a variety of relevant websites to make your renovation a success.\r\n Good luck with the Battle of Rotterdam!', 'Welkom op de website van de Battle of Rotterdam. Op deze website kunt u uw foto’s van de verbouwing insturen en maakt u kans op een geldprijs!\r\nNadat u een account aangemaakt heeft kunt u foto’s uploaden en de huidige plaats bekijken op de ranking page.\r\nMocht u nog vragen hebben kijkt u dan eerst even bij de FAQ pagina.\r\nOnder “links” vind u diverse relevante websites om uw verbouwing tot een succes te maken.\r\n Veel succes met de Battle of Rotterdam!'),
(6, 510, 'Some description of the video', 'Enkele beschrijving van de video'),
(7, 210, 'Dear, user thank you for registration on the Battle of Rotterdam site, please click on the link to complete your registration', 'Geachte, gebruiker bedankt voor registratie op de Battle of Rotterdam site, klik op de link om uw registratie te voltooien'),
(8, 110, 'Your login: ', 'Uw loginnaam: '),
(9, 111, 'Your new password: ', 'Uw nieuwe wachtwoord: '),
(10, 120, 'Email not exist in the database', 'E-mail niet in de database'),
(11, 520, 'If you participate in the Battle of Rotterdam the remodelling you submit should be done by yourself. When it turns out that this is not the case, you will be disqualified and you will not be able to participate in the future.\r\nYou can only participate once in the battle of Rotterdam with a certain renovation. If this is not the case it will be seen as fraud and you’ll be disqualified. ', 'Als u deelneemt aan de Battle of Rotterdam moet de verbouwing door uzelf gedaan zijn. Wanneer blijkt dat dit niet het geval is zal u gediskwalificeerd worden en u zal in de toekomst ook niet meer deel kunnen nemen. \r\nU kan slechts eenmaal deelnemen aan de Battle of Rotterdam met een betreffende verbouwing. Als dit niet het geval is zal dit worden gezien als fraude. '),
(12, 530, 'The city of Rotterdam is struggling with overdue maintenance of houses in the city. People often do not know how to redecorate their home and when they know it''s often been a problem. In addition, people do not see the need of redecorating their home, often because they do not live the rest of their lives in the same house. The consequence of this is that the houses remain. This damages the image of Rotterdam as a city and cost the municipality a lot of money.', 'De gemeente Rotterdam kampt met achterstallig onderhoud van huizen in de stad. Mensen weten vaak niet hoe ze hun huis moeten opknappen en wanneer ze het wel weten is tijd vaak een probleem. Daarnaast zien mensen de noodzaak niet van het opknappen van hun huis, vaak omdat ze er niet de rest van hun leven blijven wonen. Het gevolg hiervan is dat de huizen er lelijk bij blijven staan. Dit beschadigt het beeld van Rotterdam als stad en kost de gemeente ook een hoop geld, aangezien zij op het moment de huizen laten opknappen via makelaars.  '),
(13, 540, 'For these problems to get the municipality of Rotterdam teamed up with students from the Business IT & Management at University of Applied Sciences Rotterdam. The municipality wants to encourage the population to renovate their houses through a number of projects.', 'Om deze problemen toe te komen is de gemeente Rotterdam een samenwerking aangegaan met studenten van de opleiding Business IT & Management van de Hogeschool Rotterdam. De gemeente wil met verschillende projecten de huizen van Rotterdam in status verbeteren door ze op te laten knappen door de bevolking zelf. '),
(14, 600, 'Why would I compete?', 'Waarom zou ik meedoen met de Battle? '),
(15, 605, 'There are a number of reasons such as: sharing your remodelling with people from your neighbourhood, winning the prize money and the thrill of the competition.', 'Er zijn een aantal redenen zoals: het delen van uw verbouwing met mensen uit de buurt, het winnen van de geldprijs en de spanning van de strijd. '),
(16, 610, 'What can I win?', 'Wat kan ik winnen? '),
(17, 615, 'That depends on the competition. For the annual competition it is 10.000,- Euro and for the monthly 1.000,- Euro.', 'Dat verschilt aan de competitie waaraan in mee doet. Voor je jaarlijkse competitie is dit 10.000,- euro en voor de maandelijkse 1.000,- euro.'),
(18, 620, 'Who organises this competition?', 'Wie organiseert de competitie?'),
(19, 625, 'The Battle of Rotterdam organized by employees of the municipality of Rotterdam in collaboration with students of the University of Applied Sciences Rotterdam.', 'The Battle of Rotterdam wordt georganiseerd door medewerkers van de gemeente Rotterdam in samenwerking met studenten van de Hogeschool Rotterdam.'),
(20, 630, 'Where can I find information about renovation? ', 'Waar kan ik informatie vinden over verbouwen en renoveren? '),
(21, 635, 'On our website you can find several links that direct you to various informative site pages. ', 'Op onze website kunt u verschillende links vinden die u doorverwijzen naar diverse informatieve sites.'),
(22, 640, 'Where can I report fraud? ', 'Waar kan ik fraude vermelden?'),
(23, 645, 'You can mark an entry as fraud in the submission itself. ', 'U kunt een inzending markeren als fraude bij de inzending zelf. '),
(24, 521, 'Rules and regulations', 'Regels en voorschriften'),
(25, 531, 'Information about the Battle of Rotterdam ', 'Informatie over the Battle of Rotterdam'),
(26, 541, 'About those who made it', 'Over de ontwikkelaars'),
(27, 551, 'General Information', 'Algemene informatie'),
(28, 550, 'On this website you can upload pictures of the renovation and you could win a cash prize!\r\nAfter you have created an account, you can upload photos and view the current position on the ranking page.\r\nShould you have any questions, please look first at the FAQ page.\r\nUnder "Links" you will find a variety of relevant websites to make your renovation a success.', 'Op deze website kunt u uw foto’s van de verbouwing insturen en maakt u kans op een geldprijs!\r\nNadat u een account aangemaakt heeft kunt u foto’s uploaden en de huidige plaats bekijken op de ranking page.\r\nMocht u nog vragen hebben kijkt u dan eerst even bij de FAQ pagina.\r\nOnder “links” vind u diverse relevante websites om uw verbouwing tot een succes te maken.'),
(29, 700, 'Some short text "about us"', 'Sommige korte tekst "over ons"'),
(30, 710, '12345 / Some Street\r\nPortland, USA', '12345 / Sommige Straat\r\nPortland, USA'),
(34, 720, 'mail@must.be.here ', 'mail@must.be.here'),
(35, 730, 'phone: +1 (44) 123-45-67 ', 'telefoon: +1 (44) 123-45-67'),
(36, 740, 'fax: +1 (44) 123-45-63 ', 'fax: +1 (44) 123-45-63'),
(37, 750, 'Skype Me ', 'Skype Me'),
(38, 800, 'Your project is registered', 'Uw project is geregistreerd'),
(39, 10, 'Battle of Rotterdam will start soon!', 'Battle of Rotterdam zal binnenkort beginnen!'),
(40, 20, 'Celebration in honor of the opening of the "Battle of Rotterdam!"', 'Viering ter ere van de opening van de "Slag van Rotterdam!"'),
(41, 30, 'Lets make our city more beautiful!', 'Laten we onze stad mooier!'),
(42, 40, '', ''),
(43, 50, '', ''),
(44, 60, '', ''),
(45, 70, '', ''),
(46, 1000, 'e-mail sent', 'e-mail verzonden'),
(47, 1010, 'Сhanges are made', 'Wijzigingen worden aangebracht'),
(48, 560, 'PLEASE READ THE FOLLOWING TERMS AND CONDITIONS CAREFULLY BEFORE USING THIS SITE. By using this site, you signify your agreement to these Terms and Conditions. If you do not agree to these Terms and Conditions, do not use this site. TheBattleOfRotterdam may modify these Terms and Conditions at anytime. \r\nRestrictions On Use of Materials \r\nThis site is copyright protected. Any textual or graphic material you copy, print, or download is licensed to you by Hasbro, Inc. and/or its subsidiaries ("TheBattleOfRotterdam") for your personal, non-commercial home use only, provided that you do not change or delete any copyright, trademark or other proprietary notices. \r\nTHE MATERIALS IN THIS SITE ARE PROVIDED "AS IS" AND WITHOUT WARRANTIES OF ANY KIND EITHER EXPRESS OR IMPLIED. TheBattleOfRotterdam DOES NOT WARRANT OR MAKE ANY REPRESENTATIONS REGARDING THE USE OR THE RESULTS OF THE USE OF THE CONTENT OR OTHER MATERIALS IN THIS SITE IN TERMS OF THEIR CORRECTNESS, ACCURACY, RELIABILITY, OR OTHERWISE.', 'LEES DE VOLGENDE VOORWAARDEN, VOORDAT U DEZE SITE. Door het gebruik van deze site gaat u akkoord met deze algemene voorwaarden. Indien u niet akkoord gaat met deze voorwaarden, deze site niet te gebruiken. TheBattleOfRotterdam kan deze voorwaarden op elk moment wijzigen.\r\nBeperkingen op het gebruik van materialen\r\nDeze site is auteursrechtelijk beschermd. Tekstuele of grafische materiaal dat u kopieert, wordt afdrukken of downloaden in licentie gegeven aan u door Hasbro, Inc en / of haar dochterondernemingen ("TheBattleOfRotterdam") voor uw persoonlijk, niet-commercieel thuisgebruik uitsluitend gebruik, op voorwaarde dat u niet wijzigen of verwijderen een auteursrecht, handelsmerk of andere eigendomsrechten.\r\nHET MATERIAAL OP DEZE SITE WORDEN "AS IS", ZONDER ENIGE GARANTIE OOK uitdrukkelijk noch stilzwijgend. TheBattleOfRotterdam GEEN GARANTIE OF HET GEBIED VAN HET GEBRUIK OF DE RESULTATEN VAN HET GEBRUIK VAN DE INHOUD OF ANDER MATERIAAL OP DEZE SITE IN ALGEMENE juistheid, nauwkeurigheid, betrouwbaarheid, OF ANDERS.'),
(49, 561, 'Terms & Conditions ', 'Algemene Voorwaarden'),
(50, 650, '', ''),
(51, 655, '', ''),
(52, 660, '', ''),
(53, 665, '', ''),
(54, 670, '', ''),
(55, 675, '', ''),
(56, 680, '', ''),
(57, 685, '', ''),
(58, 690, '', ''),
(59, 695, '', ''),
(60, 80, '', ''),
(61, 90, '', '');
(62, 1100, 'Your opportunity to comment on disabled. Please contact the administration.', 'Uw kans om opmerkingen te maken over een handicap. Neem contact op met de administratie.');
(63, 1110, 'Your account is blocked. Please contact the administration.', 'Uw account is geblokkeerd. Neem contact op met de administratie.');
(64, 1120, 'Wrong login or password', 'Verkeerde login of wachtwoord');

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
(1, 100, '//www.youtube.com/embed/5L96q7Gg9wE?feature=p', '//www.youtube.com/embed/5L96q7Gg9wE?feature=player_detailpage'),
(2, 110, 'Municipality of Rotterdam', 'http://www.rotterdam.nl/gemeenterotterdam'),
(3, 120, 'BIONIC University', 'http://tech.bionic-university.com/en/about_bionic_university/'),
(4, 130, 'Neighborhoods', 'Value of Link3 on Home-page'),
(5, 140, 'Test your own house', 'Value of Link4 on Home-page');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`id`, `firstname`, `middlename`, `lastname`, `login`, `password`, `photoPath`, `email`, `phone`, `birthday`, `address_id`, `role_id`, `commentAble`, `active`, `approveregistration`) VALUES
(1, 'Test', 'Test', 'Test', 'test', '098f6bcd4621d373cade4e832627b4f6', 'img/test.jpg', 'test@gmail.com', '0501010101', '1960-01-01', 1, 2, 0, 0, 1),
(2, 'test100', 'test100', 'test100', 'test100', 'f5f97c92ae39d49a4fa87d97eb3d89ff', 'default', 'rer@ukr.net', '0974324324324', NULL, 28, 2, 1, 1, 0),
(3, '', '', '', 'i', 'd41d8cd98f00b204e9800998ecf8427e', 'default', 'i@i.i', '', NULL, 29, 2, 1, 1, 0),
(4, 'test100500', 'test100500', 'test100500', 'test100500', '019fb0f5329189e23737b7e93b3d5576', 'default', 'hovrah_boom@ukr.net', '0974324324324', NULL, 30, 2, 1, 1, 0),
(5, 'test55', 'test55', 'test55', 'test55', '7e39cfce74d155294619613f42484f18', 'default', 'dsad@ukr.net', '32421', NULL, 31, 2, 1, 1, 0),
(11, 'Ray', 'O’', 'Sun', 'ray_login', 'b59c67bf196a4758191e42f76670ceba', 'img/c1.jpg', 'ray@gmail.com', '0501012020', '1985-02-02', 1, 2, 1, 1, 1),
(12, 'Joe', '', 'Morton', 'joe_login', 'b59c67bf196a4758191e42f76670ceba', 'img/c2.jpg', 'joe@gmail.com', '0501013030', '1979-03-03', 1, 2, 1, 1, 1),
(13, 'Jenny', '', 'Flex', 'jenny_login', 'b59c67bf196a4758191e42f76670ceba', 'img/c3.jpg', 'jenny@gmail.com', '0501014040', '1988-04-04', 1, 2, 1, 1, 1),
(14, 'Lupe', '', 'Lamora', 'lupe_login', 'b59c67bf196a4758191e42f76670ceba', 'img/c4.jpg', 'lupe@gmail.com', '0501015050', '1977-05-05', 1, 2, 1, 1, 1),
(15, 'ss', 'ss', 'ss', 'sss', '3691308f2a4c2f6983f2880d32e29c84', 'default', 's@s.com', '3(099)123 456 789', '2012-12-01', 32, 2, 1, 1, 0),
(16, 'O_o', 'O_O', 'o_O', 'agent008', '59739de02f972041fbab2123eb047cf7', 'default', 'zernovagg@gmail.com', '13', NULL, 33, 2, 1, 1, 1),
(24, 'Ð¹Ñ?Ñ?', 'Ð¹Ñ?Ñ?', 'Ð¹Ñ?Ñ?', 'Ñ?Ñ?Ð²Ð°', '96263c660bc72a504fbbf673464c17de', 'default', 'lujack@mail.ru', '123412314', '1234-11-12', 41, 2, 1, 1, 0),
(29, 'Gerard', 'Test', 'Boot', 'GerardBoot', '855889a1a0c753e2fb6e825a4195d674', 'default', 'gerard.boot3@gmail.com', '+31683697708', '1990-03-12', 47, 2, 1, 1, 1),
(33, 'Rob', 'van der', 'kroef', 'rob', 'a117768239df9c97cc0ab15b70fd248b', 'default', '0852575@hr.nl', '012015454', '1992-11-02', 51, 2, 1, 1, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Voice`
--

INSERT INTO `Voice` (`id`, `level`, `voiceDate`, `user_id`, `project_id`) VALUES
(1, 1, '2014-01-20 22:13:53', 1, 1),
(2, 1, '2014-01-20 22:15:00', 2, 2),
(3, 1, '2014-01-20 22:20:23', 2, 3),
(4, 1, '2014-01-20 22:23:53', 2, 1);

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
  ADD CONSTRAINT `Competition_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`),
  ADD CONSTRAINT `Competition_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `CompetitionType` (`id`);

--
-- Constraints for table `News`
--
ALTER TABLE `News`
  ADD CONSTRAINT `News_ibfk_1` FOREIGN KEY (`text_id`) REFERENCES `Text` (`id`);

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
