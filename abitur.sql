-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Июл 09 2015 г., 23:08
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
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `discipline1_score` int(3) NOT NULL,
  `discipline2_score` int(3) NOT NULL,
  `discipline3_score` int(3) NOT NULL,
  `school_score` double(2,1) NOT NULL,
  `score_sum` int(3) NOT NULL,
  `chosen_faculty` int(2) NOT NULL,
  `status` enum('approved','waiting','denied') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `chosen_faculty` (`chosen_faculty`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

--
-- Дамп данных таблицы `abiturients`
--

INSERT INTO `abiturients` (`id`, `username`, `first_name`, `middle_name`, `last_name`, `discipline1_score`, `discipline2_score`, `discipline3_score`, `school_score`, `score_sum`, `chosen_faculty`, `status`) VALUES
(1, 'student', 'Наталья', 'Леонидовна', 'Жукова', 94, 64, 63, 9.3, 314, 1, 'approved'),
(2, 'abiturient1', 'Мария', 'Александровна', 'Малиновская', 89, 78, 63, 8.4, 314, 1, 'approved'),
(3, 'abiturient2', 'Анастасия', 'Федоровна', 'Мамонова', 68, 56, 63, 7.9, 266, 1, 'approved'),
(4, 'abiturient3', 'Ольга', 'Владимировна', 'Снежина', 89, 63, 67, 8.6, 305, 1, 'approved'),
(5, 'abiturient4', 'Павел', 'Александрович', 'Верховский', 68, 76, 67, 8.4, 295, 1, 'approved'),
(6, 'abiturient5', 'Екатерина', 'Васильевна', 'Воропаева', 87, 96, 80, 8.8, 351, 2, 'approved'),
(7, 'abiturient6', 'Егор', 'Викторович', 'Соколов', 79, 80, 100, 9.1, 350, 4, 'approved'),
(8, 'abiturient7', 'Алина', 'Васильевна', 'Зубарева', 80, 69, 60, 8.2, 291, 1, 'approved'),
(9, 'abiturient8', 'Мария', 'Александровна', 'Марчук', 89, 90, 79, 9.1, 349, 8, 'approved'),
(10, 'abiturient9', 'Олег', 'Владимирович', 'Журавлев', 80, 96, 89, 9.4, 359, 1, 'approved'),
(11, 'abiturient10', 'Антон', 'Михайлович', 'Федоров', 78, 70, 86, 8.1, 315, 1, 'approved'),
(12, 'abiturient11', 'Ирина', 'Григорьевна', 'Василевская', 90, 69, 100, 8.9, 348, 1, 'approved'),
(13, 'abiturient12', 'Александра', 'Васильевна', 'Лебедева', 84, 58, 90, 7.9, 311, 1, 'approved'),
(14, 'abiturient13', 'Екатерина', 'Евгеньевна', 'Шипулина', 79, 74, 80, 8.3, 316, 1, 'approved'),
(15, 'abiturient15', 'Анастасия', 'Владимировна', 'Кузьмина', 70, 67, 90, 7.9, 306, 1, 'approved'),
(16, 'abiturient16', 'Татьяна', 'Валерьевна', 'Троина', 96, 87, 68, 8.5, 336, 1, 'approved'),
(17, 'abiturient17', 'Анна', 'Владимировна', 'Маслова', 69, 83, 57, 7.8, 287, 1, 'approved'),
(18, 'abiturient18', 'Михаил', 'Олегович', 'Слепов', 79, 85, 57, 7.8, 299, 1, 'approved'),
(20, 'abiturient2012', 'Аыдажфшуа', 'Ауыафвыа', 'Мважыфжауы', 43, 74, 84, 6.6, 267, 7, 'denied'),
(21, 'newstudent', 'Леонид', 'Федорович', 'Савичев', 97, 74, 84, 7.8, 333, 4, 'waiting');

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
(2, 'Филологический', 10, 1, 2, 3),
(3, 'Медицинский', 15, 1, 6, 7),
(4, 'Химический', 10, 1, 4, 6),
(5, 'Физический', 15, 1, 4, 5),
(6, 'Исторический', 15, 2, 8, 11),
(7, 'Географический', 10, 2, 4, 9),
(8, 'КСИС', 10, 1, 4, 5),
(9, 'Юридический', 8, 2, 4, 10),
(10, 'Тестовый', 12, 6, 5, 9);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user_type` enum('abiturient','admin') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=23 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `user_type`) VALUES
(1, 'admin', '5ebe2294ecd0e0f08eab7690d2a6ee69', 'admin'),
(2, 'student', 'e10adc3949ba59abbe56e057f20f883e', 'abiturient'),
(3, 'abiturient1', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(4, 'abiturient2', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(5, 'abiturient3', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(6, 'abiturient4', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(7, 'abiturient5', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(8, 'abiturient6', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(9, 'abiturient7', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(10, 'abiturient8', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(11, 'abiturient9', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(12, 'abiturient10', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(13, 'abiturient11', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(14, 'abiturient12', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(15, 'abiturient13', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(16, 'abiturient14', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(17, 'abiturient15', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(18, 'abiturient16', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(19, 'abiturient17', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(20, 'abiturient18', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(21, 'newstudent', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient'),
(22, 'abiturient2012', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `abiturients`
--
ALTER TABLE `abiturients`
  ADD CONSTRAINT `abiturients_ibfk_2` FOREIGN KEY (`chosen_faculty`) REFERENCES `faculties` (`id_faculty`),
  ADD CONSTRAINT `abiturients_ibfk_3` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

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
