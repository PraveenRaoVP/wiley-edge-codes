--combine last name and first name of employees and customers into a single result set
SELECT firstName, lastName from employees UNION SELECT contactFirstName, contactLastName FROM customers;

--display full name
SELECT CONCAT(firstName,' ', lastName) AS fullName from employees UNION SELECT CONCAT(contactFirstName, ' ',contactLastName) FROM customers;

-- sort the fullname
SELECT CONCAT(firstName,' ', lastName) AS fullName from employees UNION SELECT CONCAT(contactFirstName, ' ',contactLastName) FROM customers ORDER BY fullName;

--print the type of person as an additional column
SELECT CONCAT(firstName,' ', lastName) AS fullName, "Employee" AS person_type  FROM employees
UNION
SELECT CONCAT(contactFirstName,' ', contactLastName) AS fullName, "Customer" AS person_type  FROM customers ORDER BY fullName;

-- SELECT a.firstName,a.lastName, b.contactFirstName, b.contactLastName FROM employees a, customers b;
--SELECT firstName, lastName from employees WHERE firstName="Leslie";
--SELECT contactFirstName, contactLastName from customers WHERE contactFirstName="Leslie";


