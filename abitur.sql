-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Июл 05 2015 г., 10:41
-- Версия сервера: 5.6.24
-- Версия PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `chosen_faculty` int(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `abiturients`
--

INSERT INTO `abiturients` (`id`, `username`, `first_name`, `middle_name`, `last_name`, `discipline1_score`, `discipline2_score`, `discipline3_score`, `school_score`, `score_sum`, `chosen_faculty`) VALUES
(1, 'student', 'Наталья', 'Леонидовна', 'Жукова', 94, 64, 63, 93, 314, 1),
(2, 'abiturient1', 'Мария', 'Александровна', 'Малиновская', 89, 78, 63, 84, 314, 1),
(3, 'abiturient2', 'Анастасия', 'Федоровна', 'Мамонова', 68, 56, 63, 79, 266, 1),
(4, 'abiturient3', 'Ольга', 'Владимировна', 'Снежина', 89, 63, 67, 86, 305, 1),
(5, 'abiturient4', 'Павел', 'Александрович', 'Верховский', 68, 76, 67, 84, 295, 1),
(6, 'abiturient5', 'Екатерина', 'Васильевна', 'Воропаева', 87, 96, 80, 88, 351, 2),
(7, 'abiturient6', 'Егор', 'Викторович', 'Соколов', 79, 80, 100, 91, 350, 4),
(8, 'abiturient7', 'Алина', 'Васильевна', 'Зубарева', 80, 69, 60, 82, 291, 1),
(9, 'abiturient8', 'Мария', 'Александровна', 'Марчук', 89, 90, 79, 91, 349, 8),
(10, 'abiturient9', 'Олег', 'Владимирович', 'Журавлев', 80, 96, 89, 94, 359, 1),
(11, 'abiturient10', 'Антон', 'Михайлович', 'Федоров', 78, 70, 86, 81, 315, 1),
(12, 'abiturient11', 'Ирина', 'Григорьевна', 'Василевская', 90, 69, 100, 89, 348, 1),
(13, 'abiturient12', 'Александра', 'Васильевна', 'Лебедева', 84, 58, 90, 79, 311, 1),
(14, 'abiturient13', 'Екатерина', 'Евгеньевна', 'Шипулина', 79, 74, 80, 83, 316, 1),
(15, 'abiturient15', 'Анастасия', 'Владимировна', 'Кузьмина', 70, 67, 90, 79, 306, 1),
(16, 'abiturient16', 'Татьяна', 'Валерьевна', 'Троина', 96, 87, 68, 85, 336, 1),
(17, 'abiturient17', 'Анна', 'Владимировна', 'Маслова', 69, 83, 57, 78, 287, 1),
(18, 'abiturient18', 'Михаил', 'Олегович', 'Слепов', 79, 85, 57, 78, 299, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `disciplines`
--

CREATE TABLE IF NOT EXISTS `disciplines` (
  `id_discipline` int(3) NOT NULL,
  `discipline_name` varchar(100) NOT NULL
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
  `discipline_3` int(3) NOT NULL
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
(9, 'Юридический', 8, 2, 4, 10);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user_type` enum('abiturient','admin') NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

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
(20, 'abiturient18', '827ccb0eea8a706c4c34a16891f84e7b', 'abiturient');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `abiturients`
--
ALTER TABLE `abiturients`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `username` (`username`), ADD KEY `chosen_faculty` (`chosen_faculty`);

--
-- Индексы таблицы `disciplines`
--
ALTER TABLE `disciplines`
  ADD PRIMARY KEY (`id_discipline`), ADD UNIQUE KEY `id_discipline` (`id_discipline`);

--
-- Индексы таблицы `faculties`
--
ALTER TABLE `faculties`
  ADD PRIMARY KEY (`id_faculty`), ADD KEY `discipline_1` (`discipline_1`), ADD KEY `discipline_2` (`discipline_2`), ADD KEY `discipline_3` (`discipline_3`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `abiturients`
--
ALTER TABLE `abiturients`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
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
