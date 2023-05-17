CREATE TABLE IF NOT EXISTS tasks (
    task_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    start_date DATE,
    due_date DATE,
    status TINYINT NOT NULL,
    priority TINYINT NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS checklists (
    todo_id INT AUTO_INCREMENT,
    task_id INT,
    todo VARCHAR(255) NOT NULL,
    is_completed BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (todo_id , task_id),
    FOREIGN KEY (task_id)
        REFERENCES tasks (task_id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);

CREATE TABLE Vehicles(
    vehicleId INT,
    year YEAR NOT NULL,
    make VARCHAR(10) NOT NULL,
    PRIMARY KEY(vehicleId)
);

ALTER TABLE Vehicles ADD model VARCHAR(100) NOT NULL;
DESCRIBE Vehicles;

ALTER TABLE Vehicles
   -- ADD model VARCHAR(100) NOT NULL,
    ADD note VARCHAR(100) NOT NULL;

ALTER TABLE Vehicles
    MODIFY note VARCHAR(255) NOT NULL,
    MODIFY model VARCHAR(50) NOT NULL;

ALTER TABLE Vehicles
    CHANGE COLUMN note vehicleCondition VARCHAR(255) NOT NULL;

ALTER TABLE Vehicles
    DROP COLUMN vehicleCondition;

ALTER TABLE Vehicles RENAME TO cars; 

SELECT * FROM cars;

CREATE database newdb;
USE newdb;
CREATE DATABASE IF NOT EXISTS hr;
USE hr;

CREATE TABLE departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    dept_name VARCHAR(100)
);
CREATE TABLE employees (
    id int AUTO_INCREMENT primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    department_id int not null,
    FOREIGN KEY (department_id)
        REFERENCES departments (department_id)
);
INSERT INTO departments(dept_name)
VALUES('Sales'),('Markting'),('Finance'),('Accounting'),('Warehouses'),('Production');

INSERT INTO employees(first_name,last_name,department_id) 
VALUES('John','Doe',1),
		('Bush','Lily',2),
		('David','Dave',3),
		('Mary','Jane',4),
		('Jonatha','Josh',5),
		('Mateo','More',1);

SELECT * FROM departments;

--referenced by views 
--DROP view v_employee_info;
CREATE VIEW v_employee_info AS 
    SELECT * FROM employees
    INNER JOIN departments USING (department_id);


ALTER TABLE employees RENAME TO people;
SELECT * from v_employee_info;

--rename table employees to people
ALTER TABLE employees RENAME TO people;
ALTER TABLE departments RENAME TO depts;

DELETE FROM depts WHERE department_id=1; --error

--rename multiple tables
RENAME TABLES depts TO departments,people TO employees;

CREATE TEMPORARY TABLE lastNames SELECT DISTINCT last_name FROM employees;
SELECT * FROM lastNames;
RENAME TABLE lastNames TO unique_lastNames; --error
ALTER TABLE lastNames RENAME TO unique_lastname;
SELECT * FROM unique_lastname;
SHOW TABLES; --does not show unique_lastname


SELECT IF(COUNT(*) = 1 , "Exist", "Not Exist") AS result
FROM information_schema.columns
WHERE 
    `TABLE_NAME`="hr" AND `COLUMN_NAME`="location";

CREATE TABLE e1 (
    id int AUTO_INCREMENT primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    department_id int not null,
    FOREIGN KEY (department_id)
        REFERENCES departments (department_id)
);

CREATE TABLE e2 (
    id int AUTO_INCREMENT primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    department_id int not null,
    FOREIGN KEY (department_id)
        REFERENCES departments (department_id)
);

--DROP TABLE
--DROP TABLES

--DROP TABLE LIKE "%pattern%"
SET @schema = "hr";
SET @pattern = "test%";

SELECT CONCAT('DROP TABLE', GROUP_CONCAT(CONCAT(@schema,'.',table_name)),';')
INTO @dropLike 
FROM information_schema.tables 
WHERE @schema = database()
AND table_name LIKE @pattern;

SELECT @dropLike;

--GENREATED COLUMNS

CREATE TABLE IF NOT EXISTS contacts(
    id int AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    full_name VARCHAR(100) GENERATED ALWAYS AS (CONCAT(first_name,' ',last_name))
);

INSERT INTO contacts(first_name, last_name) VALUES ("Praveen","Rao"),("Anon","ymous");
SELECT * FROM contacts;

use wileyclassic;
SELECT * FROM products;
ALTER TABLE products DROP COLUMN totalStockPrice;
ALTER TABLE products ADD COLUMN totalStockPrice BIGINT GENERATED ALWAYS AS (quantityInStock*buyPrice) STORED;

