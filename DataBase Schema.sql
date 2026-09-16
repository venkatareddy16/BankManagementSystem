/*for console application bank system connecting java with mysql*/
create database casestudydb;
use casestudydb;

/* create account table*/
 create table Account(
 accno int primary key,
 accname varchar(30),
 phone varchar(30),
 balance double
 );
