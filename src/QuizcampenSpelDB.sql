CREATE USER 'quizdbuser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'quizdbuser'@'localhost' WITH GRANT OPTION;

CREATE SCHEMA `quizcampenSpelDB`;

DROP TABLE IF EXISTS `quizcampenSpelDB`;
CREATE TABLE `quizcampenSpelDB` (
 id int(11) NOT NULL AUTO_INCREMENT,
 question varchar(255) DEFAULT NULL,
 answer varchar(255) DEFAULT NULL,
 answer1 varchar(255) DEFAULT NULL,
 answer11 varchar(255) DEFAULT NULL,
 correctAns varchar(255) DEFAULT NULL,
 PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `quizcampenSpelDB` (`id`, `question`, `answer`, `answer1`, `answer11`, `correctAns`) VALUES ('1', 'question1', 'answer', 'answer1', 'answer11', 'correctAns');
INSERT INTO `quizcampenSpelDB` (`id`, `question`, `answer`, `answer1`, `answer11`, `correctAns`) VALUES ('2', 'question2', 'answer', 'answer1', 'answer11', 'correctAns');
INSERT INTO `quizcampenSpelDB` (`id`, `question`, `answer`, `answer1`, `answer11`, `correctAns`) VALUES ('3', 'question3', 'answer', 'answer1', 'answer11', 'correctAns');
INSERT INTO `quizcampenSpelDB` (`id`, `question`, `answer`, `answer1`, `answer11`, `correctAns`) VALUES ('4', 'question4', 'answer', 'answer1', 'answer11', 'correctAns');
INSERT INTO `quizcampenSpelDB` (`id`, `question`, `answer`, `answer1`, `answer11`, `correctAns`) VALUES ('5', 'question5', 'answer', 'answer1', 'answer11', 'correctAns');
INSERT INTO `quizcampenSpelDB` (`id`, `question`, `answer`, `answer1`, `answer11`, `correctAns`) VALUES ('6', 'question6', 'answer', 'answer1', 'answer11', 'correctAns');