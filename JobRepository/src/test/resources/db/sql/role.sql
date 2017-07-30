/*
SQLyog - Free MySQL GUI v5.02
Host - 5.0.19-nt : Database - job_repository
*********************************************************************
Server version : 5.0.19-nt
*/


create database if not exists `job_repository`;

USE `job_repository`;

/*Table structure for table `role_table` */

DROP TABLE IF EXISTS `role_table`;

CREATE TABLE `role_table` (
  `u_RoleId` varchar(255) NOT NULL,
  `u_RoleDesc` varchar(255) default NULL,
  `u_RoleName` varchar(255) default NULL,
  PRIMARY KEY  (`u_RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `role_table` */

insert into `role_table` values 
('1','manage jobs','Admin'),
('2','see jobs','user');
