CREATE USER 'admindbuser'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'admindbuser'@'localhost' WITH GRANT OPTION;


CREATE SCHEMA `admindb`;


CREATE TABLE `admindb`.`HIBERNATE_SEQUENCE` (
 next_val bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `admindb`.`HIBERNATE_SEQUENCE` (`next_val`) VALUES (1);


CREATE TABLE `admindb`.`ADMIN_USER` (
 id int(11) NOT NULL,
 lastlogin datetime DEFAULT NULL,
 password varchar(255) DEFAULT NULL,
 username varchar(255) DEFAULT NULL,
 PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `admindb`.`SERVER` (
 id int(11) NOT NULL,
 ipid int(11) DEFAULT NULL,
 name varchar(255) DEFAULT NULL,
 url varchar(255) DEFAULT NULL,
 port int(11) DEFAULT NULL,
 PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `admindb`.`SERVER` (`id`, `ipid`, `name`, `url`, `port`) VALUES ('1', '1', 'NAME', 'DBName', 'port');
INSERT INTO `admindb`.`SERVER` (`id`, `ipid`, `name`, `url`, `port`) VALUES ('2', '2', 'Name', 'DBName', 'port');
INSERT INTO `admindb`.`SERVER` (`id`, `ipid`, `name`, `url`, `port`) VALUES ('3', '3', 'NaMe', 'DBName', 'port');
INSERT INTO `admindb`.`SERVER` (`id`, `ipid`, `name`, `url`, `port`) VALUES ('4', null, 'Name', 'DBName', null);
INSERT INTO `admindb`.`SERVER` (`id`, `ipid`, `name`, `url`, `port`) VALUES ('5', null, 'Name', 'DBName', 'port');
INSERT INTO `admindb`.`SERVER` (`id`, `ipid`, `name`, `url`, `port`) VALUES ('6', null, 'Name', 'DBName', 'port');
