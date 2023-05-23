use wileyjdbc;
show tables;

CREATE TABLE employee (
id INT NOT NULL,
name VARCHAR(45) NULL,
salary INT NULL,
age INT NULL,
PRIMARY KEY (id));
select * from employee;