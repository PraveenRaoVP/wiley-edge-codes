use wileyclassic;
select AVG(buyPrice) from products;

SELECT productLine, AVG(buyPrice) FROM products GROUP BY `productLine`;

SELECT COUNT(*) AS Total from products;

SELECT productLine, COUNT(*) AS Total from products GROUP BY productLine;
SELECT * FROM products;
SELECT a.productCode, SUM(b.quantityOrdered*b.priceEach) AS Total FROM products a, orderDetails b WHERE a.`productCode`= b.`productCode` 
GROUP BY `productCode` ORDER BY Total desc LIMIT 5;

SELECT b.productCode, a.`productName`, SUM(b.quantityOrdered*b.priceEach) AS Total FROM products a, orderDetails b WHERE a.`productCode`= b.`productCode` 
GROUP BY `productCode`;

SELECT MAX(buyPrice) FROM products;

SELECT productLine, MAX(buyPrice) FROM products GROUP BY `productLine`;

SELECT MIN(buyPrice) AS lowest_price FROM products;

SELECT productLine, MIN(buyPrice) FROM products GROUP BY `productLine`;

-- GROUP_CONCAT()
-- SELECT * FROM employees;

SELECT a.firstName, a.lastName, GROUP_CONCAT(b.customerName) AS customers FROM employees a, customers b WHERE a.employeeNumber = b.`salesRepEmployeeNumber` GROUP BY a.`employeeNumber` ORDER BY a.firstName LIMIT 2;
