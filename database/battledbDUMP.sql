-- phpMyAdmin SQL Dump
-- version 4.0.6deb1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Фев 11 2014 г., 09:02
-- Версия сервера: 5.5.34-0ubuntu0.13.10.1
-- Версия PHP: 5.5.3-1ubuntu2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `battledb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Address`
--

CREATE TABLE IF NOT EXISTS `Address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `town` varchar(45) NOT NULL,
  `postcode` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `houseNumber` varchar(45) NOT NULL,
  `apartment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=79 ;

--
-- Дамп данных таблицы `Address`
--

INSERT INTO `Address` (`id`, `town`, `postcode`, `street`, `houseNumber`, `apartment`) VALUES
(1, 'town 10', 'postcode 15', 'street 20', 'houseNumber 330', 'apartment 40'),
(2, 'towntest', '080808', 'streettest', '5', NULL),
(28, 'test100', 'test100', 'test100', '43', NULL),
(29, '', '', '', '', NULL),
(30, 'test100', 'test100500', 'test100500', '43', NULL),
(31, 'test55', 'test55', 'test55', '32', NULL),
(32, 'ss', '23232', 'ss', '23s', NULL),
(33, 'rotterdam', '13', 'dont know', '13', NULL),
(34, 'mmm', '12', 'mmm', '12', NULL),
(35, 'mmm', '12', 'mmm', '12', NULL),
(41, 'eeee', '124123', 'dfrr', '1234', NULL),
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
(52, 'mmm', '12', 'mmm', '12', NULL),
(53, 'Naaldwijk', '123', 'Koraal 43', '1', NULL),
(54, 'mmm', '122222', 'mmm', '12', NULL),
(55, 'vvv', '23425', 'mmmm', '234', NULL),
(56, 'dsfsd', '23425', 'mmmm', '234', NULL),
(57, 'dfree', '080808', 'mmm', '5', NULL),
(58, 'dert', '080808', 'mmmm', '5', NULL),
(59, 'test2', '432', 'test2', '43', NULL),
(60, 'Rotterdam', '007', 'Wood', '13', NULL),
(61, 'Rotterdam', '12', 'str', '12', NULL),
(62, 'TTTT', '12', 'str', '12', NULL),
(63, 'test100', '456', 'test100', '231', NULL),
(64, 'ttt', '22', 'ttt', '2', NULL),
(65, 'm', '1', 'm', 'v', NULL),
(66, 'w', '123231', 'w', 'wq', NULL),
(67, '1', '1', '1', '1', NULL),
(68, 'Kiev', '03203', 'Vyborgskaya', '3', NULL),
(69, 'a', '4', 'a', 'a', NULL),
(70, 'Rot', '232342', 'str 1', '1', NULL),
(71, 'nnn', '12', 'nnn', '12', NULL),
(72, 'mm', '12', 'm', '12', NULL),
(73, '?', '5', '?', '?', NULL),
(74, 'z', '1', 'z', '1', NULL),
(75, 'newMAn', '1', 'newMAn', 'newMAn', NULL),
(76, 'z', '1', 'z', '1', NULL),
(77, 's', '32', 's', 's', NULL),
(78, 'm', '1', 'm', '1', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `Comment`
--

CREATE TABLE IF NOT EXISTS `Comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentText` varchar(21000) NOT NULL,
  `commentDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `project_id` (`project_id`),
  KEY `photo_id` (`photo_id`),
  FULLTEXT KEY `commentText` (`commentText`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=42 ;

--
-- Дамп данных таблицы `Comment`
--

INSERT INTO `Comment` (`id`, `commentText`, `commentDate`, `user_id`, `project_id`, `photo_id`) VALUES
(3, 'It will be something... :)', '2014-01-04 00:00:00', 12, 3, 3),
(4, 'Hello!!!!!!!!!!!!', '2014-01-04 00:00:00', 12, 4, 4),
(5, 'Nice try!', '2014-01-05 00:00:00', 13, 5, 5),
(6, 'I hope it is possible...', '2014-01-06 00:00:00', 14, 6, 6),
(27, 'I put comment for this project? about me', '2014-02-02 12:56:22', 1, 32, NULL),
(26, 'Help find!!!', '2014-01-31 17:30:43', 44, 26, NULL),
(25, 'Help me!!!', '2014-01-31 15:46:35', 43, 23, NULL),
(11, 'blabla555', '2014-01-26 02:27:22', 14, 2, 5),
(12, 'blabla666', '2014-01-27 02:27:22', 1, 2, 5),
(14, 'blabla777', '2014-01-27 04:27:22', 11, 2, 5),
(21, 'Ostavil otziv dljja proverki chto kak', '2014-01-29 18:23:20', 1, 2, NULL),
(22, 'nice', '2014-01-31 08:47:22', 42, 2, NULL),
(23, 'Comments works?', '2014-01-31 09:03:45', 36, 2, NULL),
(24, 'gvbhxnhzgnz', '2014-01-31 12:42:00', 43, 2, NULL),
(28, 'BLA_BLA_BLA', '2014-02-02 17:20:55', 5, 35, NULL),
(29, 'Such a bad project I have not seen', '2014-02-02 17:25:06', 45, 35, NULL),
(41, 'ooooooooo uuuuuuuuu eto kruto очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий очень большой комментарий ', '2014-02-07 20:40:33', 1, 42, NULL),
(34, 'Looks very nice!', '2014-02-05 12:31:13', 44, 1, NULL),
(40, 'My test comment', '2014-02-07 20:39:54', 53, 5, NULL),
(39, 'hello this is TEST USER, hi =)', '2014-02-07 20:39:48', 1, 42, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `Competition`
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
  KEY `type_id` (`type_id`),
  FULLTEXT KEY `name` (`name`,`description`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Дамп данных таблицы `Competition`
--

INSERT INTO `Competition` (`id`, `name`, `description`, `dateStart`, `dateEnd`, `registerDeadline`, `type_id`, `user_id`) VALUES
(1, 'Year Competition Name', 'Description of Year Competition. Description of Year Competition. Description of Year Competition. Description of Year Competition. Description of Year Competition. Description of Year Competition. Description of Year Competition. ', '2014-01-01', '2014-12-01', '2014-11-14', 1, NULL),
(2, 'First Month Competition Name', 'Description of First Month Competition. Description of First Month Competition. Description of First Month Competition. Description of First Month Competition. Description of First Month Competition. Description of First Month Competition. ', '2013-12-01', '2014-01-01', '2013-12-10', 2, NULL),
(3, 'Second Month Competition Name', 'description of Second Month Competition. description of Second Month Competition. description of Second Month Competition. description of Second Month Competition. description of Second Month Competition. description of Second Month Competition. ', '2014-01-01', '2014-01-29', '2014-01-10', 2, NULL),
(4, 'Third Month Competition Name', 'Description of Third Month Competition. Description of Third Month Competition. Description of Third Month Competition. Description of Third Month Competition. Description of Third Month Competition. Description of Third Month Competition. ', '2014-01-30', '2014-03-15', '2014-03-10', 2, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `CompetitionType`
--

CREATE TABLE IF NOT EXISTS `CompetitionType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `CompetitionType`
--

INSERT INTO `CompetitionType` (`id`, `name`) VALUES
(1, 'year'),
(2, 'month');

-- --------------------------------------------------------

--
-- Структура таблицы `News`
--

CREATE TABLE IF NOT EXISTS `News` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `photoPath` varchar(65) NOT NULL,
  `loadDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `titleEn` varchar(5000) NOT NULL,
  `titleNl` varchar(5000) NOT NULL,
  `valueEn` longtext NOT NULL,
  `valueNl` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `text_id` (`titleEn`(255))
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `News`
--

INSERT INTO `News` (`id`, `photoPath`, `loadDate`, `titleEn`, `titleNl`, `valueEn`, `valueNl`) VALUES
(1, 'img/news1.jpg', '2014-01-15 08:00:00', 'Battle of Rotterdam will start soon!', 'Battle of Rotterdam zal binnenkort beginnen!', 'Battle of Rotterdam will start soon!&nbsp;Text &nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text<div>Text&nbsp;<span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text</span></div>', 'Battle of Rotterdam zal binnenkort beginnen!&nbsp;Text &nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text<div>Text&nbsp;<span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text</span></div>'),
(2, 'img/news2.jpg', '2014-01-16 08:00:00', 'Celebration in honor of the opening of the "Battle of Rotterdam!"', 'Viering ter ere van de opening van de "Slag van Rotterdam!"', 'Celebration in honor of the opening of the "Battle of Rotterdam!"&nbsp;Text &nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text<div>Text&nbsp;<span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text</span></div>', 'Viering ter ere van de opening van de "Slag van Rotterdam!"&nbsp;Text &nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text<div>Text&nbsp;<span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text</span></div>'),
(3, 'img/news3.jpg', '2014-01-17 08:00:00', 'Lets make our city more beautiful!', 'Laten we onze stad mooier!', 'Lets make our city more beautiful! Text &nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text<div>Text&nbsp;<span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text</span></div>', 'Laten we onze stad mooier!&nbsp;Text &nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text&nbsp;Text<div>Text&nbsp;<span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text&nbsp;</span><span style="font-size: 10pt;">Text</span></div>');

-- --------------------------------------------------------

--
-- Структура таблицы `Photo`
--

CREATE TABLE IF NOT EXISTS `Photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(300) NOT NULL,
  `loadDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` mediumtext,
  `project_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`),
  FULLTEXT KEY `description` (`description`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=68 ;

--
-- Дамп данных таблицы `Photo`
--

INSERT INTO `Photo` (`id`, `path`, `loadDate`, `description`, `project_id`) VALUES
(3, 'img/remont3.jpg', '2014-01-04 00:00:00', 'Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. ', 3),
(4, 'img/remont5.jpg', '2014-01-04 00:00:00', 'Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. ', 4),
(5, 'img/remont13.jpg', '2014-01-05 00:00:00', 'Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. ', 5),
(6, 'img/remont14.jpg', '2014-01-06 00:00:00', 'Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. ', 6),
(9, 'img/remont2.jpg', '2014-01-08 16:00:00', 'Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. ', 3),
(10, 'img/remont4.jpg', '2014-01-09 16:00:00', 'JoesJoes year project photo description. JoesJoes year project photo description. JoesJoes year project photo description. JoesJoes year project photo description. JoesJoes year project photo description. JoesJoes year project photo description. JoesJoes year project photo description. JoesJoes year project photo description. ', 4),
(11, 'img/remont9.jpg', '2014-01-10 16:00:00', 'Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. Description of Jennys year project photo. ', 5),
(12, 'img/remont10.jpg', '2014-01-11 16:00:00', 'Description of Lupes month project photo.Description of Lupes month project photo.Description of Lupes month project photo.Description of Lupes month project photo.Description of Lupes month project photo.Description of Lupes month project photo.Description of Lupes month project photo.Description of Lupes month project photo.', 6),
(14, 'img/remont16.jpg', '2014-01-12 16:00:00', 'Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. ', 3),
(15, 'img/remont17.jpg', '2014-01-13 16:00:00', 'Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. Description of JoesJoes year project photo. ', 4),
(16, 'img/remont18.jpg', '2014-01-14 16:00:00', 'Description of Jennys_year_project_photo. Description of Jennys_year_project_photo. Description of Jennys_year_project_photo. Description of Jennys_year_project_photo. Description of Jennys_year_project_photo. Description of Jennys_year_project_photo. ', 5),
(17, 'img/remont19.gif', '2014-01-15 16:00:00', 'Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. Description of Lupes month project photo. ', 6),
(32, 'controller?command=getphoto&photoname=photo43_1_month.jpg', '2014-01-31 15:43:46', 'Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. ', 22),
(37, 'controller?command=getphoto&photoname=photo1_2_month.png', '2014-02-01 14:46:08', 'Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. ', 27),
(33, 'controller?command=getphoto&photoname=photo43_1_month.jpg', '2014-01-31 15:45:43', 'Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. ', 23),
(38, 'controller?command=getphoto&photoname=photo1_3_month.png', '2014-02-01 14:58:53', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 27),
(39, 'controller?command=getphoto&photoname=photo1_4_month.png', '2014-02-01 14:59:43', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 27),
(40, 'controller?command=getphoto&photoname=photo1_5_month.png', '2014-02-01 15:28:36', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 27),
(41, 'controller?command=getphoto&photoname=photo1_6_month.png', '2014-02-01 15:30:42', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 27),
(42, 'controller?command=getphoto&photoname=photo1_1_month.jpg', '2014-02-01 21:23:20', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 29),
(43, 'controller?command=getphoto&photoname=photo1_2_month.jpg', '2014-02-01 21:27:10', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 29),
(44, 'controller?command=getphoto&photoname=photo1_3_month.png', '2014-02-01 21:30:43', 'Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. ', 29),
(45, 'controller?command=getphoto&photoname=photo1_4_month.png', '2014-02-01 21:32:33', 'Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. ', 29),
(46, 'controller?command=getphoto&photoname=photo1_1_month.png', '2014-02-01 21:45:25', 'Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. ', 30),
(47, 'controller?command=getphoto&photoname=photo42_1_month.jpg', '2014-02-02 01:03:27', 'Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. ', 31),
(48, 'controller?command=getphoto&photoname=photo42_2_month.jpg', '2014-02-02 01:04:14', 'Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. Description of project photo. ', 31),
(49, 'controller?command=getphoto&photoname=photo1_1_month.png', '2014-02-02 11:26:19', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 32),
(51, 'controller?command=getphoto&photoname=photo11_1_month.jpg', '2014-02-02 16:04:36', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 35),
(52, 'controller?command=getphoto&photoname=photo45_1_year.png', '2014-02-02 17:26:12', 'Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. Description your photo. ', 36),
(65, 'controller?command=getphoto&photoname=photo1_1_month.png', '2014-02-10 21:10:34', 'Description your photo', 43),
(66, 'controller?command=getphoto&photoname=photo1_2_month.jpg', '2014-02-10 21:10:45', 'Description your photo', 43),
(67, 'controller?command=getphoto&photoname=photo1_3_month.jpg', '2014-02-10 21:10:57', 'Description your photo', 43),
(53, 'controller?command=getphoto&photoname=photo50_1_year.jpeg', '2014-02-04 13:48:23', '', 37),
(54, 'controller?command=getphoto&photoname=photo42_1_year.jpg', '2014-02-04 18:29:41', 'Description your photo', 38),
(55, 'controller?command=getphoto&photoname=photo40_1_month.jpg', '2014-02-04 18:34:12', 'It''s best apartment, that I''ve never seen before', 39),
(56, 'controller?command=getphoto&photoname=photo53_1_month.jpg', '2014-02-05 10:36:29', 'Description your photo', 40),
(57, 'controller?command=getphoto&photoname=photo53_1_year.jpg', '2014-02-05 10:44:54', 'Description your photo', 41);

-- --------------------------------------------------------

--
-- Структура таблицы `Project`
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
  KEY `competition_id` (`competition_id`),
  FULLTEXT KEY `name` (`name`,`description`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=44 ;

--
-- Дамп данных таблицы `Project`
--

INSERT INTO `Project` (`id`, `name`, `description`, `creationDate`, `user_id`, `competition_id`, `approved`) VALUES
(3, 'Joes month project', 'Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. Description of Joes month project. ', '2014-01-04 00:00:00', 12, 4, 1),
(4, 'Joes year project', 'Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. Description of Joes year project. ', '2014-01-04 00:00:00', 12, 1, 1),
(5, 'Jennys year project', 'Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. Description of Jennys year project. ', '2014-01-05 00:00:00', 13, 1, 1),
(6, 'Lupes month project', 'description of Lupes month project. description of Lupes month project. description of Lupes month project. description of Lupes month project. description of Lupes month project. description of Lupes month project. ', '2014-01-06 00:00:00', 14, 4, 1),
(31, 'yeah', 'My month project description. My month project description. My month project description. My month project description. My month project description. My month project description. My month project description. My month project description. My month project description. ', '2014-02-02 00:59:39', 42, 4, 1),
(39, 'My first monthly project', 'My first monthly project. I hope it''s will be one of the better project in your web site. I plan apartment renovation.', '2014-02-04 18:31:59', 40, 4, 1),
(25, '', 'My month project description. My month project description. My month project description. My month project description. My month project description. My month project description. My month project description. ', '2014-01-31 17:29:00', 44, 4, 0),
(35, 'Description month project', 'Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. Description month project. ', '2014-02-02 16:04:11', 11, 4, 1),
(36, 'TEST', 'My year project description. My year project description. My year project description. My year project description. My year project description. My year project description. My year project description. My year project description. My year project description. My year project description. My year project description. ', '2014-02-02 17:25:53', 45, 1, 1),
(38, 'final', ' DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescription', '2014-02-04 18:24:41', 42, 1, 1),
(43, 'tt', 'rrr', '2014-02-10 21:09:50', 1, 4, 1),
(37, 'Death Star', 'We are trying to build the Death Star in open space in order to prevail over the humanity. Join the dark side.', '2014-02-04 13:46:43', 50, 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `Role`
--

CREATE TABLE IF NOT EXISTS `Role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `Role`
--

INSERT INTO `Role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'user'),
(3, 'guest');

-- --------------------------------------------------------

--
-- Структура таблицы `Text`
--

CREATE TABLE IF NOT EXISTS `Text` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `keyval` bigint(20) NOT NULL,
  `valueEn` longtext NOT NULL,
  `valueNl` longtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `keyval` (`keyval`),
  FULLTEXT KEY `valueEn` (`valueEn`,`valueNl`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=70 ;

--
-- Дамп данных таблицы `Text`
--

INSERT INTO `Text` (`id`, `keyval`, `valueEn`, `valueNl`) VALUES
(1, 100, 'Your new password will be sent to your email', 'Uw nieuwe wachtwoord zal naar uw e-mail worden verzonden'),
(2, 200, 'Please check your email to complete your registration', 'Controleer uw e-mail om uw registratie te voltooien'),
(3, 300, 'Thank you! Now you can login and try create your first project', 'Dank je wel! Nu kunt u inloggen en probeer maak uw eerste project'),
(4, 310, 'Something WRONG. Please check your email again', 'Iets mis. Controleer uw e-mail opnieuw'),
(5, 500, 'Welcome to the website of the Battle of Rotterdam.\r\n On this website you can upload pictures of the renovation and you could win a cash prize!\r\nAfter you have created an account, you can upload photos and view the current position on the ranking page.\r\nShould you have any questions, please look first at the FAQ page.\r\nUnder "Links" you will find a variety of relevant websites to make your renovation a success.\r\n Good luck with the Battle of Rotterdam!', 'Welkom op de website van de Battle of Rotterdam. Op deze website kunt u uw foto’s van de verbouwing insturen en maakt u kans op een geldprijs!\r\nNadat u een account aangemaakt heeft kunt u foto’s uploaden en de huidige plaats bekijken op de ranking page.\r\nMocht u nog vragen hebben kijkt u dan eerst even bij de FAQ pagina.\r\nOnder “links” vind u diverse relevante websites om uw verbouwing tot een succes te maken.\r\n Veel succes met de Battle of Rotterdam!'),
(6, 510, 'Some description of the video', 'Enkele beschrijving van de video'),
(7, 210, 'Dear user, thank you for registration on the Battle of Rotterdam site, please click on the link to complete your registration', 'Geachte, gebruiker bedankt voor registratie op de Battle of Rotterdam site, klik op de link om uw registratie te voltooien'),
(8, 110, 'Your login: ', 'Uw loginnaam: '),
(9, 111, 'Your new password: ', 'Uw nieuwe wachtwoord: '),
(10, 120, 'Email not exist in the database', 'E-mail niet in de database'),
(11, 520, 'If you participate in the Battle of Rotterdam the remodelling you submit should be done by yourself. When it turns out that this is not the case, you will be disqualified and you will not be able to participate in the future.\nYou can only participate once in the battle of Rotterdam with a certain renovation. If this is not the case it will be seen as fraud and you’ll be disqualified.', 'Als u deelneemt aan de Battle of Rotterdam moet de verbouwing door uzelf gedaan zijn. Wanneer blijkt dat dit niet het geval is zal u gediskwalificeerd worden en u zal in de toekomst ook niet meer deel kunnen nemen. \r\nU kan slechts eenmaal deelnemen aan de Battle of Rotterdam met een betreffende verbouwing. Als dit niet het geval is zal dit worden gezien als fraude. '),
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
(28, 550, 'On this website you can upload pictures of the renovation and you could win a cash prize!\r\nAfter you have created an account, you can upload photos and view the current position on the ranking page.\r\nShould you have any questions, please look first at the FAQ page.\r\nUnder "Links" you will find a variety of relevant websites to make your renovation a success.bfbfb', 'Op deze website kunt u uw foto’s van de verbouwing insturen en maakt u kans op een geldprijs!\r\nNadat u een account aangemaakt heeft kunt u foto’s uploaden en de huidige plaats bekijken op de ranking page.\r\nMocht u nog vragen hebben kijkt u dan eerst even bij de FAQ pagina.\r\nOnder “links” vind u diverse relevante websites om uw verbouwing tot een succes te maken.'),
(29, 700, 'Some short text "about us"', 'Sommige korte tekst "over ons"'),
(30, 710, 'Bergselaan 30, 3011 MZ Rotterdam', 'Bergselaan 30, 3011 MZ Rotterdam'),
(34, 720, 'mail@must.be.here ', 'mail@must.be.here '),
(35, 730, 'phone: +1 (44) 123-45-67 ', 'telefoon: +1 (44) 123-45-67'),
(36, 740, 'fax: +1 (44) 123-45-63 ', 'fax: +1 (44) 123-45-63 '),
(37, 750, 'Skype Me ', 'Skype Me '),
(38, 800, 'Your project is registered', 'Uw project is geregistreerd'),
(46, 1000, 'e-mail sent', 'e-mail verzonden'),
(47, 1010, 'Сhanges are made', 'Wijzigingen worden aangebracht'),
(48, 560, 'PLEASE READ THE FOLLOWING TERMS AND CONDITIONS CAREFULLY BEFORE USING THIS SITE. By using this site, you signify your agreement to these Terms and Conditions. If you do not agree to these Terms and Conditions, do not use this site. TheBattleOfRotterdam may modify these Terms and Conditions at anytime. \nRestrictions On Use of Materials \nThis site is copyright protected. Any textual or graphic material you copy, print, or download is licensed to you by Hasbro, Inc. and/or its subsidiaries ("TheBattleOfRotterdam") for your personal, non-commercial home use only, provided that you do not change or delete any copyright, trademark or other proprietary notices. \nTHE MATERIALS IN THIS SITE ARE PROVIDED "AS IS" AND WITHOUT WARRANTIES OF ANY KIND EITHER EXPRESS OR IMPLIED. TheBattleOfRotterdam DOES NOT WARRANT OR MAKE ANY REPRESENTATIONS REGARDING THE USE OR THE RESULTS OF THE USE OF THE CONTENT OR OTHER MATERIALS IN THIS SITE IN TERMS OF THEIR CORRECTNESS, ACCURACY, RELIABILITY, OR OTHERWISE.', 'LEES DE VOLGENDE VOORWAARDEN, VOORDAT U DEZE SITE. Door het gebruik van deze site gaat u akkoord met deze algemene voorwaarden. Indien u niet akkoord gaat met deze voorwaarden, deze site niet te gebruiken. TheBattleOfRotterdam kan deze voorwaarden op elk moment wijzigen.\r\nBeperkingen op het gebruik van materialen\r\nDeze site is auteursrechtelijk beschermd. Tekstuele of grafische materiaal dat u kopieert, wordt afdrukken of downloaden in licentie gegeven aan u door Hasbro, Inc en / of haar dochterondernemingen ("TheBattleOfRotterdam") voor uw persoonlijk, niet-commercieel thuisgebruik uitsluitend gebruik, op voorwaarde dat u niet wijzigen of verwijderen een auteursrecht, handelsmerk of andere eigendomsrechten.\r\nHET MATERIAAL OP DEZE SITE WORDEN "AS IS", ZONDER ENIGE GARANTIE OOK uitdrukkelijk noch stilzwijgend. TheBattleOfRotterdam GEEN GARANTIE OF HET GEBIED VAN HET GEBRUIK OF DE RESULTATEN VAN HET GEBRUIK VAN DE INHOUD OF ANDER MATERIAAL OP DEZE SITE IN ALGEMENE juistheid, nauwkeurigheid, betrouwbaarheid, OF ANDERS.'),
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
(62, 1100, 'Your opportunity to comment on disabled. Please contact the administration', 'Uw kans om opmerkingen te maken over een handicap. Neem contact op met de administratie'),
(63, 1110, 'Your account is blocked. Please contact the administration.', 'Uw account is geblokkeerd. Neem contact op met de administratie'),
(64, 1120, 'Wrong login or password', 'Verkeerde login of wachtwoord'),
(65, 220, 'Account is not updated. Mail exist. Please enter your correct mail!', 'Account is niet bijgewerkt. Mail bestaan​​. Vul je e-mail!'),
(66, 230, 'Account is not updated. Incorrect password. Please enter your correct password!', 'Account is niet bijgewerkt. Onjuist wachtwoord. Vul je wachtwoord in!'),
(67, 240, 'Account was successfully updated.', 'Account is bijgewerkt.'),
(68, 250, 'Data was deleted successfully', 'Data is verwijderd'),
(69, 260, 'Access Error!', 'Access Error!');

-- --------------------------------------------------------

--
-- Структура таблицы `URL`
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
-- Дамп данных таблицы `URL`
--

INSERT INTO `URL` (`id`, `keyval`, `name`, `value`) VALUES
(1, 100, '//www.youtube.com/embed/5L96q7Gg9wE?feature=p', '//www.youtube.com/embed/5L96q7Gg9wE?feature=player_detailpage'),
(2, 110, 'Municipality of Rotterdam', 'http://www.rotterdam.nl/gemeenterotterdam'),
(3, 120, 'BIONIC University', 'http://tech.bionic-university.com/en/about_bionic_university/'),
(4, 130, 'Neighborhoods', 'http://happy.demoon.org/dev/'),
(5, 140, 'Test your own house', 'http://sweet-home.jelastic.regruhosting.ru/');

-- --------------------------------------------------------

--
-- Структура таблицы `User`
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=60 ;

--
-- Дамп данных таблицы `User`
--

INSERT INTO `User` (`id`, `firstname`, `middlename`, `lastname`, `login`, `password`, `photoPath`, `email`, `phone`, `birthday`, `address_id`, `role_id`, `commentAble`, `active`, `approveregistration`) VALUES
(1, 'Test', 'Test', 'Test', 'test', '098f6bcd4621d373cade4e832627b4f6', 'controller?command=getphoto&avatarname=avatar1.jpg', 'test@gmail.com', '0501010101', '2014-01-01', 1, 2, 1, 1, 1),
(2, 'Root', 'r', 'Rttt', 'root', 'root', 'default', 'rer@ukr.net', '0974324324324', NULL, 28, 1, 1, 1, 1),
(3, '', '', '', 'i', 'd41d8cd98f00b204e9800998ecf8427e', 'default', 'i@i.i', '', NULL, 29, 2, 0, 0, 0),
(4, 'test100500', 'test100500', 'test100500', 'test100500', '019fb0f5329189e23737b7e93b3d5576', 'default', 'hovrah_boom@ukr.net', '0974324324324', NULL, 30, 2, 0, 0, 0),
(5, 'test55', 'test55', 'test55', 'test55', '7e39cfce74d155294619613f42484f18', 'controller?command=getphoto&avatarname=avatar5.png', 'dsad@ukr.net', '32421', NULL, 31, 2, 1, 0, 0),
(11, 'Ray', 'O’', 'Suny', 'ray_login', 'b59c67bf196a4758191e42f76670ceba', 'controller?command=getphoto&avatarname=avatar11.jpg', 'ray@gmail.com', '0501012020', '1985-02-02', 1, 2, 1, 1, 1),
(12, 'Joe', '', 'Morton', 'joe_login', 'b59c67bf196a4758191e42f76670ceba', 'controller?command=getphoto&avatarname=avatar12.jpg', 'joe@gmail.com', '0501013030', '1979-03-03', 1, 2, 1, 1, 1),
(13, 'Jenny', '', 'Flex', 'jenny_login', 'b59c67bf196a4758191e42f76670ceba', 'controller?command=getphoto&avatarname=avatar13.jpg', 'jenny@gmail.com', '0501014040', '1988-04-04', 1, 2, 1, 1, 1),
(14, 'Lupe', '', 'Lamora', 'lupe_login', 'b59c67bf196a4758191e42f76670ceba', 'controller?command=getphoto&avatarname=avatar14.jpg', 'lupe@gmail.com', '0501015050', '1977-05-05', 1, 2, 1, 1, 1),
(15, 'ss', 'ss', 'ss', 'sss', '3691308f2a4c2f6983f2880d32e29c84', 'controller?command=getphoto&avatarname=avatar15.jpg', 's@s.com', '3(099)123 456 789', '2012-12-01', 32, 2, 1, 1, 0),
(16, 'O_o', 'O_O', 'o_O', 'agent008', '59739de02f972041fbab2123eb047cf7', 'controller?command=getphoto&avatarname=avatar16.jpg', 'zernovagg@gmail.com', '13', NULL, 33, 2, 1, 1, 1),
(29, 'Gerard', 'Test', 'Boot', 'GerardBoot', '855889a1a0c753e2fb6e825a4195d674', 'controller?command=getphoto&avatarname=avatar29.jpg', 'gerard.boot3@gmail.com', '+31683697708', '1990-03-12', 47, 2, 1, 1, 1),
(33, 'Rob', 'van der', 'kroef', 'rob', 'a117768239df9c97cc0ab15b70fd248b', 'controller?command=getphoto&avatarname=avatar33.jpeg', '0852575@hr.nl', '012015454', '1992-11-02', 51, 2, 1, 1, 1),
(35, 'Max', 'van', 'Dop', 'maxvandop', '25f9e794323b453885f5181f1b624d0b', 'controller?command=getphoto&avatarname=avatar35.jpeg', 'maxvandop@hotmail.com', '123', '1997-02-01', 53, 2, 1, 1, 1),
(36, 'mmm m', '', 'mmm', 'mmm', 'c4efd5020cb49b9d3257ffa0fbccc0ae', 'controller?command=getphoto&avatarname=avatar36.jpg', 'marink@gmail.com', '12545455221313', '1222-12-12', 54, 2, 1, 0, 1),
(39, 'm', 'mmmm', 'mmm', 'AAA', '0d1b08c34858921bc7c662b228acb7ba', 'default', 'test5@gmadial.com', '0980101010', '1991-01-01', 57, 2, 0, 0, 0),
(40, 'Vid', 'Mad', 'Sad', 'hgjjgh', '0d1b08c34858921bc7c662b228acb7ba', 'controller?command=getphoto&avatarname=avatar40.jpg', 'test5@gmsadial.com', '0980101010', '1991-01-01', 58, 2, 1, 0, 0),
(41, 'test2', 'test2', 'test2', 'test2', 'ad0234829205b9033196ba818f7a872b', 'controller?command=getphoto&avatarname=avatar41.png', 'crocusid@ukr.net', '342343312', '1000-10-10', 59, 2, 0, 0, 1),
(42, 'Very', 'Cunning', 'Fox', 'fox', 'c4ca4238a0b923820dcc509a6f75849b', 'controller?command=getphoto&avatarname=avatar42.jpg', 'fox@fox.nl', 'nophone', '1001-01-01', 60, 2, 1, 0, 1),
(44, 'mmm', 'm', 'mmm', 'Masha', 'c4efd5020cb49b9d3257ffa0fbccc0ae', 'controller?command=getphoto&avatarname=avatar44.jpg', 'masha@ukr.net', '+3(099)121314', '1212-12-12', 62, 2, 1, 1, 1),
(45, 'test100', 'test100', 'test102', 'test100', 'f5f97c92ae39d49a4fa87d97eb3d89ff', 'img/nophoto.png', 'crocusjava@gmail.com', '+3(099)123 456 789', '1091-10-01', 63, 2, 0, 0, 0),
(48, 'h', '', 'h', 'd', '1f28e49f34e2406fdb6d6158eebd793b', 'img/nophoto.png', 'q@q.q', 'weqweqwe', '1212-12-12', 66, 2, 1, 1, 0),
(49, 'd', '', 'd', 'sss', 'd1457b72c3fb323a2671125aef3eab5d', 'img/nophoto.png', 'q@xn--q-hub.q', '1', NULL, 67, 2, 1, 1, 0),
(50, 'Vladimir', 'Ololo', 'Dmitruk', 'nyker', 'd8da2ce32284372293176cf9d8693ba4', 'controller?command=getphoto&avatarname=avatar50.jpg', 'nyker@ukr.net', '+3(095)754 36 19', '1993-01-09', 68, 2, 0, 0, 1),
(51, 'a', '', 'a', 'a', '0cc175b9c0f1b6a831c399e269772661', 'img/nophoto.png', 'as@sa.r', '4', NULL, 69, 2, 1, 1, 0),
(52, 'qwer', 'rewq', 'rewq', 'qwer', '962012d09b8170d912f0669f6d7d9d07', 'controller?command=getphoto&avatarname=avatar52.jpg', 'lujack@mail.ru', '+3(099)123 456 789', '2000-12-12', 70, 2, 0, 1, 1),
(53, 'Marina', 'm', 'mmm', 'Marina', 'c4efd5020cb49b9d3257ffa0fbccc0ae', 'controller?command=getphoto&avatarname=avatar53.jpg', 'makmarserg@ukr.net', '12', NULL, 72, 2, 1, 1, 1),
(54, '?', '', '?', '?', 'd1457b72c3fb323a2671125aef3eab5d', 'img/nophoto.png', 'q@xn--q-3tb.q', '5', NULL, 73, 2, 1, 1, 0),
(55, 'zzz', '', 'zzz', 'zzz', 'f3abb86bd34cf4d52698f14c0da1dc60', 'img/nophoto.png', 'zzz@z.z', '1', NULL, 74, 2, 1, 1, 0),
(56, 'newMAn', '', 'newMAn', 'newMAn', 'c4ca4238a0b923820dcc509a6f75849b', 'img/nophoto.png', 'newMAn@newMAn.newMAn', '1', NULL, 75, 2, 1, 1, 0),
(57, 'zzz', '', 'zzz', 'z', 'f3abb86bd34cf4d52698f14c0da1dc60', 'img/nophoto.png', 'g@ukr.net', '1', NULL, 76, 2, 1, 1, 0),
(58, 's', '', 's', 'testa', '03c7c0ace395d80182db07ae2c30f034', 'img/nophoto.png', 'q@qs.q', '23', NULL, 77, 2, 1, 1, 1),
(59, 'm', 'm', 'm', 'm', '6f8f57715090da2632453988d9a1501b', 'controller?command=getphoto&avatarname=avatar59.jpg', 'm@m.m', '1', NULL, 78, 2, 1, 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `Voice`
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Дамп данных таблицы `Voice`
--

INSERT INTO `Voice` (`id`, `level`, `voiceDate`, `user_id`, `project_id`) VALUES
(3, 1, '2014-01-21 06:20:23', 2, 3),
(6, 1, '2014-01-31 08:00:00', 42, 19),
(9, 1, '2014-01-31 08:00:00', 41, 24),
(11, 1, '2014-01-31 08:00:00', 44, 24),
(12, 1, '2014-02-01 08:00:00', 42, 31),
(13, 1, '2014-02-02 08:00:00', 1, 32),
(14, 1, '2014-02-02 08:00:00', 1, 35),
(15, 1, '2014-02-03 08:00:00', 44, 36);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
