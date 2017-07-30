/*
SQLyog - Free MySQL GUI v5.02
Host - 5.0.19-nt : Database - job_repository
*********************************************************************
Server version : 5.0.19-nt
*/


create database if not exists `job_repository`;

USE `job_repository`;

/*Table structure for table `user_table` */

DROP TABLE IF EXISTS `user_table`;

CREATE TABLE `user_table` (
  `u_UserId` int(11) NOT NULL,
  `u_EmailId` varchar(255) default NULL,
  `u_Password` varchar(255) default NULL,
  `u_UserName` varchar(255) default NULL,
  `u_Token` varchar(255) default NULL,
  `action` varchar(255) default NULL,
  PRIMARY KEY  (`u_UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_table` */

insert into `user_table` values 
(1,'vp@gmail.com','123456','vijay','40851ff5-3bc2-43b4-99bb-c8dc965f61db',NULL),
(2,'vijay@gmail.com','123456','vpandey','11621331-4435-4359-be6e-ff2530672736',NULL),
(3,'v@gmail.com','123456','vp','3fd4e798-0e64-4306-9e52-adc1def82202',NULL);
