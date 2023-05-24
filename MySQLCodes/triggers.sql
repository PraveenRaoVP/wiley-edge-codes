use wileyjdbc;
show tables;

CREATE TABLE employee (
id INT NOT NULL,
name VARCHAR(45) NULL,
salary INT NULL,
age INT NULL,
PRIMARY KEY (id));
select * from candidates;

DELIMITER $$ CREATE PROCEDURE get_candidate_skills() BEGIN SELECT first_name, last_name, skills.skill_id as skill FROM candidates, candidate_skills as skills; END $$ DELIMITER;

ALTER TABLE candidates 
ADD COLUMN resume LONGBLOB NULL AFTER email;

SELECT * FROM candidates WHERE id=133;