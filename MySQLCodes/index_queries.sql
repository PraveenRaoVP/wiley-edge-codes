CREATE INDEX idx_jobTitle ON employees(jobTitle);
EXPLAIN FORMAT = JSON SELECT 
    employeeNumber,
    lastName,firstName
    FROM employees 
    WHERE jobTitle = "Sales Rep";

DROP INDEX idx_jobTitle ON employees ALGORITHM = INPLACE LOCK=DEFAULT;

SHOW INDEXES FROM contacts WHERE VISIBLE='NO';

CREATE TABLE contacts(
    contact_id INT AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    PRIMARY KEY(contact_id),
    UNIQUE(email),
    INDEX phone(phone) INVISIBLE,
    INDEX name(first_name, last_name) comment 'By first name and/or last name'
);

SELECT productName, buyPrice, msrp FROM products WHERE `productName` LIKE "1970%";

SELECT COUNT(DISTINCT LEFT(productName,20)) unique_rows
FROM products;

SELECT firstName, lastName, email from employees where lastName = "Patterson";
EXPLAIN FORMAT = JSON SELECT firstName, lastName, email from employees where lastName = "Patterson";
CREATE INDEX name ON employees(firstName, lastName, email);


SELECT productName, buyPrice FROM products WHERE buyPrice BETWEEN 10 AND 80;
EXPLAIN FORMAT = JSON SELECT productName, buyPrice FROM products WHERE buyPrice BETWEEN 10 AND 80 ORDER BY `buyPrice`;

CREATE INDEX idx_buyprice ON products(buyPrice);

CREATE INDEX extension ON employees 


