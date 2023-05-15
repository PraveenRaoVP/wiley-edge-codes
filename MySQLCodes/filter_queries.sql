--where 
SELECT firstName, lastName,jobTitle from employees
WHERE jobTitle="Sales Rep" AND `officeCode`=1;

-- between
SELECT firstName, lastName,jobTitle, officeCode from employees
WHERE `officeCode` BETWEEN 1 AND 3;

--LIKE wildcard operator
SELECT lastName, firstName from employees where `lastName` LIKE "%son" ORDER BY `firstName`;

-- IN OPERATOR
SELECT firstName, lastName,jobTitle, officeCode from employees
WHERE `officeCode` IN (1,2,3);

--IS NULL
SELECT firstName, lastName, reportsTo from employees
WHERE `reportsTo` IS NULL;

-- <> operator
SELECT firstName, lastName, `jobTitle` from employees
WHERE `jobTitle` <> "Sales Rep";

--DISTINCT operator
SELECT DISTINCT lastName FROM employees ORDER BY `lastName`;

SELECT DISTINCT state,city FROM customers WHERE state IS NOT NULL ORDER BY state,city;  

SELECT customerName, country FROM customers WHERE country="USA" AND state="CA" AND creditLimit>100000;