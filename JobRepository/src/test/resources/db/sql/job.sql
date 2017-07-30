CREATE TABLE job_table (
  u_jobID INTEGER PRIMARY KEY,
  u_CompanyId int(11),
  u_UserId int(11),
  u_jobName varchar(25),
  u_joblocation varchar(25),
  u_jobrol varchar(25),
  u_latitude double,
  u_longitude double,
  u_positions int(11),
  u_salary double,
  u_status varchar(25),
  u_companyname varchar(25)
);