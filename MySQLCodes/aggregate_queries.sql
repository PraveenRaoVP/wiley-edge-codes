use wileyclassic;
select AVG(buyPrice) from products;

SELECT productLine, AVG(buyPrice) FROM products GROUP BY `productLine`;

SELECT COUNT(*) AS Total from products;

SELECT productLine, COUNT(*) AS TotalCount from products GROUP BY productLine;
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

SELECT a.firstName, a.lastName, GROUP_CONCAT(DISTINCT b.customerName) AS customers FROM employees a, customers b WHERE a.employeeNumber = b.`salesRepEmployeeNumber` GROUP BY a.`employeeNumber` ORDER BY a.firstName LIMIT 2;

SELECT firstName, lastName, GROUP_CONCAT(DISTINCT customerName ORDER BY customerName) customers
    FROM employees INNER JOIN customers ON customers.`salesRepEmployeeNumber`=`employeeNumber` GROUP BY `employeeNumber` ORDER BY firstName LIMIT 2;

--format
SELECT FORMAT(AVG(buyPrice),2) FROM products;


--using HAVING clause
SELECT productLine, AVG(buyPrice) FROM products GROUP BY `productLine` HAVING AVG(buyPrice) > 50;

SELECT pl_avg FROM (
    SELECT AVG(buyPrice) pl_avg
    FROM products GROUP BY productLine
) avgs;


--return customers and their orders
SELECT customerName, COUNT(*) AS orderCount FROM customers INNER JOIN orders ON customers.customerNumber = orders.customerNumber GROUP BY customerName LIMIT 10;

WITH cte AS (
    SELECT c.customerName, COUNT(o.customerNumber) AS order_count
    FROM customers c LEFT JOIN orders o ON c.`customerNumber` = o .`customerNumber`
    GROUP BY c.`customerNumber`, c.`customerName` 
) SELECT customerName, order_count,
CASE order_count
    WHEN 1 THEN "One Time customer"
    WHEN 2 THEN "Repeated customer"
    WHEN 3 THEN "Frequent Customer"
    ELSE "Loyal Customer"
    END customerType
FROM cte ORDER BY customerName;


--sort the customers by state if state is not null else sort the country if state is NULL
with cte_1 AS (
    SELECT customerName, IF(state is NULL,"N/A",state) state,country
    FROM customers
) SELECT customerName, state, country FROM cte_1 
ORDER BY CASE state
    WHEN "N/A" THEN country
    ELSE state
    END ;

SELECT SUM(
    CASE 
    WHEN status="Shipped" THEN 1
    ELSE 0
    END
) AS Shipped,
SUM(
    CASE 
    WHEN status="ON Hold" THEN 1
    ELSE 0
    END
) AS on_hold,
SUM(
    CASE 
    WHEN status="ON Hold" THEN 1
    ELSE 0
    END
) AS on_hold,
COUNT(*) AS Total
FROM orders;


SELECT IF (1=1, TRUE, FALSE);


SELECT 1/0;

SELECT orderNumber, orderDate, requiredDate, shippedDate, status FROM orders
WHERE orderDate BETWEEN "2003-06-01" AND "2003-06-30" ;

SELECT SUM(IF(status="Shipped",1,0)) / SUM(IF(status="Cancelled",1,0)) FROM orders
WHERE orderDate BETWEEN "2003-06-01" AND "2003-06-30" ; --returns null as denominator is zero

SELECT SUM(IF(status="Shipped",1,0)) / NULLIF(SUM(IF(status="Cancelled",1,0)),0) FROM orders
WHERE orderDate BETWEEN "2003-06-01" AND "2003-06-30" ; --returns null 

