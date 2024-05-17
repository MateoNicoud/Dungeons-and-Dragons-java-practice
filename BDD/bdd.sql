-- Adminer 4.8.1 MySQL 10.6.16-MariaDB-0ubuntu0.22.04.1 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `Hero_id` int(11) NOT NULL,
                         `case_id` int(11) NOT NULL,
                         PRIMARY KEY (`id`,`Hero_id`,`case_id`),
                         KEY `fk_Board_Hero1_idx` (`Hero_id`),
                         KEY `fk_board_case1_idx` (`case_id`),
                         CONSTRAINT `board_ibfk_1` FOREIGN KEY (`Hero_id`) REFERENCES `hero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                         CONSTRAINT `board_ibfk_2` FOREIGN KEY (`case_id`) REFERENCES `case` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2007331443 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `case`;
CREATE TABLE `case` (
                        `id` int(11) NOT NULL,
                        `Content` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `defensiveEquipement`;
CREATE TABLE `defensiveEquipement` (
                                       `id` int(11) NOT NULL,
                                       `name` varchar(45) DEFAULT NULL,
                                       `defensePower` int(11) DEFAULT NULL,
                                       `type` varchar(45) DEFAULT NULL,
                                       `Hero_id` int(11) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       KEY `fk_OffensiveEquipement_Hero_idx` (`Hero_id`),
                                       CONSTRAINT `fk_OffensiveEquipement_Hero0` FOREIGN KEY (`Hero_id`) REFERENCES `hero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `Ennemy`;
CREATE TABLE `Ennemy` (
                          `id` int(11) NOT NULL,
                          `case_id` int(11) NOT NULL,
                          `Ennemy` varchar(45) DEFAULT NULL,
                          `healthPoint` int(11) DEFAULT NULL,
                          `attackPower` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `fk_Ennemy_case1_idx` (`case_id`),
                          CONSTRAINT `Ennemy_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `case` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `hero`;
CREATE TABLE `hero` (
                        `id` int(11) NOT NULL,
                        `name` varchar(45) DEFAULT NULL,
                        `Job` varchar(45) DEFAULT NULL,
                        `healthPoint` int(11) DEFAULT NULL,
                        `attackPower` int(11) DEFAULT NULL,
                        `defensePower` int(11) DEFAULT NULL,
                        `Position` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `MysteryBox`;
CREATE TABLE `MysteryBox` (
                              `id` int(11) NOT NULL,
                              `item` varchar(45) DEFAULT NULL,
                              `type` varchar(45) DEFAULT NULL,
                              `power` varchar(45) DEFAULT NULL,
                              `case_id` int(11) NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `fk_MysteryBox_case1_idx` (`case_id`),
                              CONSTRAINT `MysteryBox_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `case` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `offensiveEquipement`;
CREATE TABLE `offensiveEquipement` (
                                       `id` int(11) NOT NULL,
                                       `name` varchar(45) DEFAULT NULL,
                                       `attackPower` int(11) DEFAULT NULL,
                                       `type` varchar(45) DEFAULT NULL,
                                       `Hero_id` int(11) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       KEY `fk_OffensiveEquipement_Hero_idx` (`Hero_id`),
                                       CONSTRAINT `offensiveEquipement_ibfk_1` FOREIGN KEY (`Hero_id`) REFERENCES `hero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- 2024-05-17 08:20:28