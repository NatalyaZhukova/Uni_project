-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Июн 21 2015 г., 19:26
-- Версия сервера: 5.6.21
-- Версия PHP: 5.6.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `abitur`
--

-- --------------------------------------------------------

--
-- Структура таблицы `abiturients`
--

CREATE TABLE IF NOT EXISTS `abiturients` (
  `id` int(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `discipline1_score` int(3) NOT NULL,
  `discipline2_score` int(3) NOT NULL,
  `discipline3_score` int(3) NOT NULL,
  `school_score` int(3) NOT NULL,
  `score_sum` int(3) NOT NULL,
  `chosen_faculty` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `chosen_faculty` (`chosen_faculty`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `disciplines`
--

CREATE TABLE IF NOT EXISTS `disciplines` (
  `id_discipline` int(3) NOT NULL,
  `discipline_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_discipline`),
  UNIQUE KEY `id_discipline` (`id_discipline`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `disciplines`
--

INSERT INTO `disciplines` (`id_discipline`, `discipline_name`) VALUES
(1, 'Русский язык'),
(2, 'Белорусский язык'),
(3, 'Иностранный язык'),
(4, 'Математика'),
(5, 'Физика'),
(6, 'Химия'),
(7, 'Биология'),
(8, 'История Беларуси'),
(9, 'География'),
(10, 'Обществоведение'),
(11, 'Всемирная история новейшего времени');

-- --------------------------------------------------------

--
-- Структура таблицы `faculties`
--

CREATE TABLE IF NOT EXISTS `faculties` (
  `id_faculty` int(2) NOT NULL,
  `faculty_name` varchar(100) NOT NULL,
  `faculty_plan` int(3) NOT NULL,
  `discipline_1` int(3) NOT NULL,
  `discipline_2` int(3) NOT NULL,
  `discipline_3` int(3) NOT NULL,
  PRIMARY KEY (`id_faculty`),
  KEY `discipline_1` (`discipline_1`),
  KEY `discipline_2` (`discipline_2`),
  KEY `discipline_3` (`discipline_3`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `faculties`
--

INSERT INTO `faculties` (`id_faculty`, `faculty_name`, `faculty_plan`, `discipline_1`, `discipline_2`, `discipline_3`) VALUES
(1, 'Экономический', 14, 1, 3, 4),
(2, 'Филологический', 20, 1, 2, 3),
(3, 'Медицинский', 15, 1, 6, 7),
(4, 'Химический', 10, 1, 4, 6),
(5, 'Физический', 15, 1, 4, 5),
(6, 'Исторический', 15, 2, 8, 11),
(7, 'Географический', 10, 2, 4, 9),
(8, 'КСИС', 10, 1, 4, 5),
(9, 'Юридический', 8, 2, 4, 10);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user_type` enum('abiturient','admin') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `user_type`) VALUES
(1, 'admin@localhost.ru', '5ebe2294ecd0e0f08eab7690d2a6ee69', 'admin');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `abiturients`
--
ALTER TABLE `abiturients`
  ADD CONSTRAINT `abiturients_ibfk_2` FOREIGN KEY (`chosen_faculty`) REFERENCES `faculties` (`id_faculty`);

--
-- Ограничения внешнего ключа таблицы `faculties`
--
ALTER TABLE `faculties`
  ADD CONSTRAINT `faculties_ibfk_1` FOREIGN KEY (`discipline_1`) REFERENCES `disciplines` (`id_discipline`) ON UPDATE CASCADE,
  ADD CONSTRAINT `faculties_ibfk_2` FOREIGN KEY (`discipline_2`) REFERENCES `disciplines` (`id_discipline`) ON UPDATE CASCADE,
  ADD CONSTRAINT `faculties_ibfk_3` FOREIGN KEY (`discipline_3`) REFERENCES `disciplines` (`id_discipline`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
