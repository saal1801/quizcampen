USE quizcampenSpelDB;

DROP TABLE IF EXISTS `quizcampenSpelDB`.`QUIZCAPEN_QUES_ANS`;
CREATE TABLE `quizcampenSpelDB`.`QUIZCAPEN_QUES_ANS` (
 id int(11) NOT NULL AUTO_INCREMENT,
 question varchar(255) DEFAULT NULL,
 answer varchar(255) DEFAULT NULL,
 PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `QUIZCAPEN_QUES_ANS` (`id`, `question`, `answer`) VALUES ('1', 'question1', 'answer1');
INSERT INTO `QUIZCAPEN_QUES_ANS` (`id`, `question`, `answer`) VALUES ('2', 'question2', 'answer2');
INSERT INTO `QUIZCAPEN_QUES_ANS` (`id`, `question`, `answer`) VALUES ('3', 'question3', 'answer3');
INSERT INTO `QUIZCAPEN_QUES_ANS` (`id`, `question`, `answer`) VALUES ('4', 'question4', 'answer4');
INSERT INTO `QUIZCAPEN_QUES_ANS` (`id`, `question`, `answer`) VALUES ('5', 'question5', 'answer5');
INSERT INTO `QUIZCAPEN_QUES_ANS` (`id`, `question`, `answer`) VALUES ('6', 'question6', 'answer6');