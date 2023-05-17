CREATE TABLE IF NOT EXISTS tasks (
    task_id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    start_date DATE,
    due_date DATE,
    priority TINYINT NOT NULL DEFAULT 3,
    description TEXT,
    PRIMARY KEY (task_id)
);



CREATE TABLE projects(
	project_id INT AUTO_INCREMENT, 
	name VARCHAR(100) NOT NULL,
	start_date DATE,
	end_date DATE,
	PRIMARY KEY(project_id)
);

INSERT INTO projects (name, start_date, end_date)
VALUES ('AI','2019-08-01','2013-02-31'),
('DS','2019-08-02','2013-03-31');

SHOW VARIABLES LIKE 'max_allowed_packet';
SET GLOBAL max_allowed_packet=100000000;


-- insert on duplicate key occurs
CREATE TABLE devices(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(10));
INSERT INTO devices (name) VALUES ("Router"),("Switch 1"),("Switch 2");
INSERT INTO devices(id,name) VALUES(4,"Printer") ON DUPLICATE KEY UPDATE name="My Printer";
SELECT * FROM devices;

--INSERT IGNORE 
CREATE TABLE subscribers(id INT AUTO_INCREMENT PRIMARY KEY, email VARCHAR(30) NOT NULL UNIQUE);
INSERT INTO subscribers(email) VALUES("vppr@gmail.com");
INSERT INTO subscribers(email) VALUES("vppr@gmail.com"), ("Gdaw@gmail.com");
INSERT IGNORE INTO subscribers(email) VALUES("vppr@gmail.com"),("dwibadw@gmail.com");
SELECT * FROM subscribers;

--update value
UPDATE employees SET email="marypatterson@gmail.com" WHERE `lastName`="Patterson" AND firstName="Mary";
SELECT email FROM employees WHERE firstName="Mary";
SELECT `email` from employees;

--update multiple VALUES
UPDATE employees SET email="marypatterson@gmail.com", lastName="Peterson" WHERE `lastName`="Patterson" AND firstName="Mary";

--update and replace values
UPDATE employees SET email=REPLACE(email,"@classicmodelcars.com","@wileyedge.com") WHERE `jobTitle`="Sales Rep" AND `officeCode`=0; 
