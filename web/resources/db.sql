-- DDL
DROP TABLE IF EXISTS `EMPLOYEES`;
CREATE TABLE `EMPLOYEES` (
  `id`          int(11)     NOT NULL AUTO_INCREMENT,
  `FIRST_NAME`  varchar(45) NOT NULL,
  `LAST_NAME`   varchar(45) NOT NULL,
  `COMPANY`     varchar(45) NOT NULL,
  `EMPL_NUMBER` varchar(45) NOT NULL,
  `SALARY`      double      NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `COMPANIES`;
CREATE TABLE `COMPANIES` (
  `id`   int(11)     NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- DML
INSERT INTO employees (FIRST_NAME, LAST_NAME, COMPANY, EMPL_NUMBER, SALARY)
VALUES ('Mary', 'Hill', 'McGrow', 'AH12', 57600),
       ('John', 'Hilton', 'Dreams', 'AH18', 52000),
       ('Alessi', 'Marcuzzi', 'Sullivan', 'AH121', 66200);

INSERT INTO `jsfdemo`.`companies` (`NAME`)
VALUES ('Mc Neil Corp.'),
       ('Sanders'),
       ('MicroWave'),
       ('Holdmart CO'),
       ('Genesys'),
       ('Mosquitos');
