SELECT * FROM tasks;
DROP TABLE tasks;
CREATE TABLE tasks(
    id INT AUTO_INCREMENT,
    task_name VARCHAR(100) NOT NULL UNIQUE,
    lastName VARCHAR(100) NOT NULL,
    PRIMARY KEY(id), FOREIGN KEY(id) REFERENCES employees(employeeNumber)
    --FOREIGN KEY(lastName) REFERENCES employees(lastName)
);
ALTER TABLE tasks AUTO_INCREMENT=1000;

SET foreign_key_checks = 0;
ALTER TABLE tasks DISABLE KEYS;

INSERT INTO tasks (task_name,lastName) VALUES ("Cooking", "Peterson");

DESCRIBE employees;
SELECT * FROM employees;
SELECT * FROM tasks;
