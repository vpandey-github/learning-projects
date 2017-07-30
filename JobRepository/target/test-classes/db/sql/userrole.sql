/*
SQLyog - Free MySQL GUI v5.02
Host - 5.0.19-nt : Database - job_repository
*********************************************************************
Server version : 5.0.19-nt
*/


create database if not exists `job_repository`;

USE `job_repository`;

/*Table structure for table `user_role_table` */

DROP TABLE IF EXISTS `user_role_table`;

CREATE TABLE `user_role_table` (
  `u_UserId` int(11) NOT NULL,
  `u_RoleId` varchar(255) NOT NULL,
  KEY `FKj5584qr581h3jb6s469kkrn7r` (`u_RoleId`),
  KEY `FKh2kfp9ycommbi659k2c7pfita` (`u_UserId`),
  CONSTRAINT `FKh2kfp9ycommbi659k2c7pfita` FOREIGN KEY (`u_UserId`) REFERENCES `user_table` (`u_UserId`),
  CONSTRAINT `FKj5584qr581h3jb6s469kkrn7r` FOREIGN KEY (`u_RoleId`) REFERENCES `role_table` (`u_RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_role_table` */

insert into `user_role_table` values 
(1,'1'),
(2,'1'),
(3,'2');
