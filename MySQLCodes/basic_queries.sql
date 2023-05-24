-- show databases
show databases;
-- create database
CREATE database wiley;
-- select database
USE wiley;
SHOW TABLES;
-- create a table
CREATE TABLE students(
	id INTEGER, 
    Name VARCHAR(20),
    Contact VARCHAR(10), 
	Grade DOUBLE,
	UNIQUE(id)
);
-- inserting values into the table
INSERT INTO students value(1,
	"Praveen",
	"8610571051",
	90.6);
    INSERT INTO students value(2,
	"Anon",
	"9936829362",
	88.7);
-- show content of the tables
SELECT * FROM students;
-- drop table
DROP TABLE students;
ShOW TABLES;
-- drop the database
DROP DATABASE wiley;
SHOW DATABASES;